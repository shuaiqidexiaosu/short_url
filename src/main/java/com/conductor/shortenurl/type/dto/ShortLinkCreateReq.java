package com.conductor.shortenurl.type.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: ShortLinkCreateReq
 * @description:
 * @author: 智慧的苏苏
 * @create: 2025-08-27 21:14
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkCreateReq implements Serializable {

    /**
     * 分组信息
     */
    private String gid;

    /**
     * 长链Hash62
     */
    private String shortUri;

    /**
     * 原始链接
     */
    private String originUrl;

    /**
     * 短链接
     */
    private String fullShortUrl;
}