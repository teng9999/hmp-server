/*
 * ServerStatisticUtil.java Copyright Bejing Passion Tech Co.,Ltd. All Rights
 * Reserved.
 */
package cn.pl.hmp.server.utils;

/**
 * 服务统计工具
 *
 * @author alanyuan
 */
public class ServerStatisticUtil {
    /**
     * 获取所有线程
     *
     * @return
     */
    public static Thread[] findAllThreads() {
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        ThreadGroup topGroup = group;
        // traverse the ThreadGroup tree to the top
        while (group != null) {
            topGroup = group;
            group = group.getParent();
        }
        // Create a destination array that is about
        // twice as big as needed to be very confident
        // that none are clipped.
        int estimatedSize = topGroup.activeCount() * 2;
        Thread[] slackList = new Thread[estimatedSize];
        // Load the thread references into the oversized
        // array. The actual number of threads loaded
        // is returned.
        int actualSize = topGroup.enumerate(slackList);
        // copy into a list that is the exact size
        Thread[] list = new Thread[actualSize];
        System.arraycopy(slackList, 0, list, 0, actualSize);
        return list;
    }
}
