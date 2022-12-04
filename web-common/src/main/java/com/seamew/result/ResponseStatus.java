package com.seamew.result;

public enum ResponseStatus
{
    /**
     * 成功
     */
    SUCCESS(200, "success"),

    /**
     * 失败
     */
    FAIL(400, "fail");

    /**
     * 响应状态码
     */
    private int code;

    /**
     * 消息
     */
    private String message;

    ResponseStatus(int code, String message)
    {
        this.code = code;
        this.message = message;
    }

    public int getCode()
    {
        return code;
    }

    public String getMessage()
    {
        return message;
    }
}
