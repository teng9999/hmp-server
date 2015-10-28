/*
 * ThriftServiceInitializationLock.java Copyright Bejing Passion Tech Co.,Ltd.
 * All Rights Reserved.
 */
package cn.pl.hmp.server.global;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Thrift初始化锁
 *
 * @author alanyuan
 */
public final class ThriftServiceInitializationLock {
    private static Lock       lock   = new ReentrantLock();
    private static LockStatus status = LockStatus.UNLOCK;
    private static boolean    ok     = false;
                                     
    public synchronized static boolean lock() {
        if (status.equals(LockStatus.UNLOCK)) {
            status = LockStatus.LOCK;
            lock.lock();
            return true;
        } else {
            return false;
        }
    }
    
    public static void unlock() {
        if (status.equals(LockStatus.LOCK)) {
            status = LockStatus.UNLOCK;
            ok = true;
            lock.unlock();
        }
    }
    
    /**
     * @return the ok
     */
    public static boolean isOk() {
        return ok;
    }
    
    private enum LockStatus {
        LOCK( 1, "Lock" ), UNLOCK( 2, "Unlock" ), WAIT( 3, "Wait" );
        
        @SuppressWarnings( "unused" )
        private int    status;
        @SuppressWarnings( "unused" )
        private String msg;
                       
        private LockStatus(int status, String msg) {
            this.status = status;
            this.msg = msg;
        }
        
    }
}
