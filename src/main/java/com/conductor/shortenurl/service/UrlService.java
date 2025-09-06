package com.conductor.shortenurl.service;

import com.conductor.shortenurl.common.type.dto.ShortLinkCreateReq;
import com.conductor.shortenurl.common.type.dto.ShortLinkCreateRes;
import com.conductor.shortenurl.common.type.dto.ShortLinkRes;

/**
 * @author renliangyu857
 */
public interface UrlService {

  /**
   * 根据长URL生成短URL(不带过期时间)
   *
   * @param longUrl 长Url
   * @param timeout 过期时间
   * @return 短Url
   */
  String generateShortUrl(String longUrl, String type, Integer timeout);


  /**
   * 根据短URL返回长URL
   *
   * @param shortUrl 短Url
   * @return 长URL
   */
  String getLongUrlByShortUrl(String shortUrl);

  ShortLinkRes<ShortLinkCreateRes> createShortLink(ShortLinkCreateReq requestParam);
}
