package com.conductor.shortenurl.common.type.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @program: ShortLinkResult
 * @description:
 * @author: 智慧的苏苏
 * @create: 2025-08-27 21:12
 **/



@Data
@Accessors(chain = true)
public class ShortLinkRes<T> implements Serializable {


    private static final long serialVersionUID = 5679018624309023727L;

    /**
     * 正确返回码
     */
    public static final String SUCCESS_CODE = "0";

    /**
     * 返回码
     */
    private String code;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 请求ID
     */
    private String requestId;

    public boolean isSuccess() {
        return SUCCESS_CODE.equals(code);
    }
}

