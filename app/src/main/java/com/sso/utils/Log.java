package com.sso.utils;

/**
 * log管理工具类
 * @Author 王立强
 */
public class Log {
    public static boolean mIsShow = true;

    /**
     * 设置是否打开log日志开关
     *
     * @param pIsShow
     */
    public static void setShow(boolean pIsShow) {
        mIsShow = pIsShow;
    }

    /**
     * 根据tag打印相关v信息
     *
     * @param tag
     * @param msg
     */
    public static void v(String tag, String msg) {
        if (mIsShow) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String traceInfo = ste.getClassName() + "::";
            traceInfo += ste.getMethodName();
            traceInfo += "@" + ste.getLineNumber() + ">>>";
            android.util.Log.v(tag, traceInfo + msg);
        }
    }

    /**
     * 根据tag打印v信息,包括Throwable的信息
     * * @param tag
     *
     * @param msg
     * @param tr
     */
    public static void v(String tag, String msg, Throwable tr) {
        if (mIsShow) {
            android.util.Log.v(tag, msg, tr);
        }
    }


    /**
     * 根据tag打印输出debug信息
     *
     * @param tag
     * @param msg
     */
    public static void d(String tag, String msg) {
        if (mIsShow) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String traceInfo = ste.getClassName() + "::";
            traceInfo += ste.getMethodName();
            traceInfo += "@" + ste.getLineNumber() + ">>>";
            android.util.Log.d(tag, traceInfo + msg);
        }
    }

    /**
     * 根据tag打印输出debug信息 包括Throwable的信息
     * * @param tag
     *
     * @param msg
     * @param tr
     */
    public static void d(String tag, String msg, Throwable tr) {
        if (mIsShow) {
            android.util.Log.d(tag, msg, tr);
        }
    }

    /**
     * 根据tag打印输出info的信息
     * * @param tag
     *
     * @param msg
     */
    public static void i(String tag, String msg) {
        if (mIsShow) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String traceInfo = ste.getClassName() + "::";
            traceInfo += ste.getMethodName();
            traceInfo += "@" + ste.getLineNumber() + ">>>";
            android.util.Log.i(tag, traceInfo + msg);
        }
    }

    /**
     * 根据tag打印输出info信息 包括Throwable的信息
     *
     * @param tag
     * @param msg
     * @param tr
     */
    public static void i(String tag, String msg, Throwable tr) {
        if (mIsShow) {
            android.util.Log.i(tag, msg, tr);
        }
    }

    /**
     * 根据tag打印输出error信息
     *
     * @param tag
     * @param msg
     */
    public static void e(String tag, String msg) {
        if (mIsShow) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String traceInfo = ste.getClassName() + "::";
            traceInfo += ste.getMethodName();
            traceInfo += "@" + ste.getLineNumber() + ">>>";
            android.util.Log.e(tag, traceInfo + msg);
        }
    }

    /**
     * 根据tag打印输出的error信息 包括Throwable的信息
     *
     * @param tag
     * @param msg
     * @param tr
     */
    public static void e(String tag, String msg, Throwable tr) {
        if (mIsShow) {
            android.util.Log.e(tag, msg, tr);
        }
    }
}

