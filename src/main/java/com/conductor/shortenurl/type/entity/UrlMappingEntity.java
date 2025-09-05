package com.conductor.shortenurl.type.entity;

import com.conductor.shortenurl.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import java.util.Date;

/**
 *
 */
@Getter
@Setter
@Entity(name = "url_mapping")
@Where(clause = "deleted = 0")
public class UrlMappingEntity extends BaseEntity {

	private static final long DEFAULT_TIMEOUT = 30 * 24 * 60 * 60L;

	private String shortUrl;

	private String longUrl;

	private Date createdTime;

	private Date expireTime;

	public UrlMappingEntity(String shortUrl, String longUrl, Integer timeout) {
		this.shortUrl = shortUrl;
		this.longUrl = longUrl;
		this.createdTime = new Date();
		expireTime = new Date(this.createdTime.getTime() + (timeout != null ? timeout * 60 : DEFAULT_TIMEOUT));
	}

	public UrlMappingEntity() {

	}
}
