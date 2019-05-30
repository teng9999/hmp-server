package cn.pl.hmp.server;

/**
 * HMP服务主程序
 */
public class HmpServer {
    
    public static void main(String[] args) {
        // 注册Shutdown Hook
        HmpDaemon.shutdownHook();
        // 服务启动
        //
        HmpDaemon.startup();
    }
}
