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
     * 请求是否成功
     */
    private Boolean success;

    /**
     * 返回的消息
     */
    private ResponseStatus responseStatus;

    public static Result success(Object data)
    {
        return Result.builder()
                .success(true)
                .responseStatus(ResponseStatus.SUCCESS)
                .data(data)
                .build();
    }

    public static Result fail(Object data)
    {
        return Result.builder()
                .success(false)
                .responseStatus(ResponseStatus.FAIL)
                .data(data)
                .build();
    }

    public static Result fail()
    {
        return fail(null);
    }
}
