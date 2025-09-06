package com.conductor.shortenurl.common.type.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: ShortLinkCreateRes
 * @description:
 * @author: 智慧的苏苏
 * @create: 2025-08-27 21:12
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkCreateRes {

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
