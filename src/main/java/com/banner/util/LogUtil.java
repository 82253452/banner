package com.banner.util;


import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

/**
 * 日志工具类
 * @see ===============================================================================================================
 * @see 【用法如下】
 * @see 说明：在想要记录日志的位置，执行LogUtil.setXxxLogger()，然后就可以LogUtil.getLogger().info("....")
 * @see 举例：假设一个SSH2工程中有个名为userLogin()的Action方法，其内部调用了UserService，UserService内部又调用了UserDAO
 * @see      我们在userLogin()、UserService、UserDAO中均使用了LogUtil.getLogger().info("....")记录相应的日志信息
 * @see      这时，我们的日志信息，会被自动记录到ecpaycus-default.log文件中
 * @see      同理，我们若在userLogin()方法的第一句话执行LogUtil.setWebCusLogger()
 * @see           则日志会被自动写入ecpaycus-webcus.log文件中，而不会写入到ecpaycus-default.log中了
 * @see ===============================================================================================================
 * @author  玄玉<http://blog.csdn.net/jadyer>
 * @version v2.1
 * @history v2.0:新增日志的数据库保存和邮件发送功能
 * @history v2.1:新增多线程情景下的日志集中打印功能
 * @editime Aug 5, 2012 6:59:38 PM
 * @created Dec 27, 2011 12:03:01 PM
 */
public class LogUtil {
    //自定义线程范围内共享的对象。即它会针对不同线程分别创建独立的对象
    //此时每个线程得到的将是自己的实例，各线程间得到的实例没有任何关联
    private static ThreadLocal<Log> currentLoggerMap = new ThreadLocal<Log>();

    /**默认日志记录器*/
    private static Log defaultLogger = LogFactory.getLog("defaultLogger");
    /**数据库存储记录器*/
    private static Log databaseLogger = LogFactory.getLog("databaseLogger");
    /**Web定制日志记录器*/
    private static Log webCusLogger = LogFactory.getLog("ecpaycusWebCusLogger");
    /**对账文件日志记录器*/
    private static Log recFileLogger = LogFactory.getLog("ecpaycusRecFileLogger");

    private LogUtil(){}

    /**
     * 获取当前线程中的日志记录器
     * @see 每个线程调用全局的ThreadLocal.set()方法
     * @see 相当于在其内部的Map中增加一条记录，key是各自的线程，value是各自set()的值
     * @see 取的时候，直接ThreadLocal.get()即可。。。。。。。。。。。至于其内部实现，你懂的
     * @see 我博客里对此有记载==>>http://blog.csdn.net/jadyer/article/details/7338071
     * @see Struts2就是这么做的，请见com.opensymphony.xwork2.ActionContex第43和166行源码
     */
    public static Log getLogger() {
        Log log = currentLoggerMap.get();
        if(null == log){
            return defaultLogger;
        }else{
            return log;
        }
    }

    /**
     * 设置日志记录器为当前会话时最初绑定的日志记录器
     * @see 该方法适用于整个会话由2个或2个以上的线程处理的情景
     * @see 比如Mina2.x中的exceptionCaught(IoSession session, Throwable cause),其用法如下
     * @see
    LogUtil.setCurrentLogger((Log)session.getAttribute("currentLog"))

     * @see
    LogUtil.getLogger().error("请求被拒绝or请求地址有误,堆栈信息如下", cause)

     * @see 最后,记得会话开始时,通过
    session.setAttribute("currentLog", LogUtil.getLogger())
    标记日志记录器
     */
    public static void setCurrentLogger(Log log){
        currentLoggerMap.set(log);
    }

    /**
     * 多线程情境下若想使用defaultLogger则最好在使用前调用一次该方法
     */
    public static void setDefaultLogger(){
        currentLoggerMap.set(defaultLogger);
    }

    /**
     * 数据库存储记录器
     */
    public static void setDatabaseLogger(){
        currentLoggerMap.set(databaseLogger);
    }

    /**
     * Web定制日志记录器
     */
    public static void setWebCusLogger(){
        currentLoggerMap.set(webCusLogger);
    }

    /**
     * 对账文件日志记录器
     */
    public static void setRecFileLogger(){
        currentLoggerMap.set(recFileLogger);
    }
}