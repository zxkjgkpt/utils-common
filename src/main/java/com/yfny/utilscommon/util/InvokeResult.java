package com.yfny.utilscommon.util;

import java.text.MessageFormat;

/**
 * 统一调用响应格式
 * Created by jisongZhou on 2019/2/18.
 **/

public class InvokeResult<T> {

    private final static int SUCCESS = 0;
    private final static int FAILURE = 1;
    private final static int EXCEPTION = 2;

    //响应状态
    private String code;

    //响应消息
    private String message;

    //响应数据
    private T data;

    //配置读取器
    private static PropertiesLoader loader = new PropertiesLoader("props/returnCode.properties");

    public static <T> InvokeResult success(T data) {
        return success("", data, null);
    }

    public static <T> InvokeResult success(String code, T data, String... params) {
        return getResultInit("", "", data, SUCCESS, null);
    }

    public static InvokeResult failure() {
        return failure("10002", new String[]{"未知"});
    }

    public static InvokeResult failure(String code, String... params) {
        return failure(code, null, params);
    }

    public static <T> InvokeResult failure(String code, T data, String... params) {
        return getResultInit(code, "", data, FAILURE, params);
    }

    public static InvokeResult exception() {
        return exception("10003", new String[]{"未知"});
    }

    public static InvokeResult exception(String code, String... params) {
        return getResultInit(code, "", null, EXCEPTION, params);
    }

    /**
     * 接口数据统一格式化
     *
     * @param code
     * @param message
     * @param data
     * @param params
     * @return
     */
    private static InvokeResult getResultInit(String code, String message, Object data, int type, String[] params) {
        InvokeResult result = new InvokeResult();
        code = StringUtils.isNotBlank(code) ? code : "10001";
        message = StringUtils.isNotBlank(message) ? message : getMsgFromCfg(code, params);
        data = data != null ? data : StringUtils.isUTF8(message);
        if (type == SUCCESS) {
            code = "10001";
        }
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    /**
     * 从配置文件中获取错误信息
     *
     * @param code
     * @param params
     * @return
     */
    private static String getMsgFromCfg(String code, String[] params) {
        String message = loader.getProperty(code, "");
        return params == null ? message : MessageFormat.format(message,
                params);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
