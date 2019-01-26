package mrzhang.com.wanandroid.study.utils.logger;

import com.orhanobut.logger.Logger;

/**
 * @author mrzhang
 * @date 2019/1/26
 */
public class LogHelper {

    public synchronized static void v(String msg) {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
        String toStringBuffer = "[" + traceElement.getFileName() + " | " +
                traceElement.getLineNumber() + " | " + traceElement.getMethodName() + "]" + msg;
        Logger.t("PEGASILOG").i(toStringBuffer);
    }

    public synchronized static void d(String msg) {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
        String toStringBuffer = "[" + traceElement.getFileName() + " | " +
                traceElement.getLineNumber() + " | " + traceElement.getMethodName() + "] " + msg;
        Logger.t("PEGASILOG").i(toStringBuffer);
    }

    public synchronized static void i(String msg) {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
        String toStringBuffer = "[" + traceElement.getFileName() + " | " +
                traceElement.getLineNumber() + " | " + traceElement.getMethodName() + "] " + msg;
        Logger.t("PEGASILOG").i(toStringBuffer);
    }

    public synchronized static void w(String msg) {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
        String toStringBuffer = "[" + traceElement.getFileName() + " | " +
                traceElement.getLineNumber() + " | " + traceElement.getMethodName() + "] " + msg;
        Logger.t("PEGASILOG").w(toStringBuffer);
    }

    public synchronized static void e(String msg) {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
        String toStringBuffer = "[" + traceElement.getFileName() + " | " +
                traceElement.getLineNumber() + " | " + traceElement.getMethodName() + "] " + msg;
        Logger.t("PEGASILOG").e(toStringBuffer);
    }
}
