package com.seamew.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Result
{
    /**
     * 返回的数据
     */
    private Object data;

    /**
     * 信息
     */
    private String message;

    /**
     * 请求是否成功
     */
    private Boolean success;

    /**
     * 返回的消息
     */
    private ResponseStatus responseStatus;

    public static Result success(Object data, String message)
    {
        return Result.builder()
                .success(true)
                .data(data)
                .message(message)
                .responseStatus(ResponseStatus.SUCCESS)
                .build();
    }

    public static Result success(Object data)
    {
        return success(data, null);
    }

    public static Result success(String message)
    {
        return success(null, message);
    }

    public static Result success()
    {
        return success(null);
    }

    public static Result fail(Object data, String message)
    {
        return Result.builder()
                .success(false)
                .data(data)
                .message(message)
                .responseStatus(ResponseStatus.FAIL)
                .build();
    }

    public static Result fail(Object data)
    {
        return fail(data, null);
    }

    public static Result fail(String message)
    {
        return fail(null, message);
    }

    public static Result fail()
    {
        return fail(null);
    }
}
