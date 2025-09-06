package com.conductor.shortenurl.repository;

import com.conductor.shortenurl.type.entity.UrlMappingEntity;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * @author renliangyu857
 */
@Repository
public interface UrlRepository extends  BaseRepository<UrlMappingEntity, Long>,
        JpaSpecificationExecutor<UrlMappingEntity> {


  @Query(value = "select * from url_mapping where short_url = ?1 ", nativeQuery = true)
  Optional<UrlMappingEntity> getLongUrlByShortUrl(String shortUrl);


  @Modifying
  @Transactional
  @Query(value = "delete from url_mapping where short_url = ?1", nativeQuery = true)
  void deleteUrlMapping(String shortUrl);

  @Modifying
  @Transactional
  @Query(value = "delete from url_mapping where expirationTime < now()", nativeQuery = true)
  void deleteExpiredUrlMappings();
}
