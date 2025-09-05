package com.conductor.shortenurl.repository;

/**
 * @program: BaseRepository
 * @description:
 * @author: 智慧的苏苏
 * @create: 2025-09-05 17:08
 **/


import com.conductor.shortenurl.common.BaseEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * repository基本操作
 *
 * @author weizuxiao
 */
@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, K> extends PagingAndSortingRepository<T, K> {

    /**
     * 根据id查询
     *
     * @param id 主键
     * @return Optional<T>
     */
    @Override
    @Transactional(readOnly = true)
    @Query(value = "select tb from #{#entityName} tb where tb.deleted = false and tb.id = ?1")
    Optional<T> findById(K id);

    /**
     * 是否存在
     *
     * @param id 主键
     * @return boolean
     */
    @Override
    @Transactional(readOnly = true)
    default boolean existsById(K id) {
        return findById(id).isPresent();
    }

    /**
     * 查询所有
     *
     * @return Iterable<T>
     */
    @Override
    @Transactional(readOnly = true)
    @Query(value = "select tb from #{#entityName} tb where tb.deleted = false")
    Iterable<T> findAll();

    /**
     * 根据id集查询
     *
     * @param ids 主键
     * @return Iterable<T>
     */
    @Override
    @Transactional(readOnly = true)
    @Query("select tb from #{#entityName} tb where tb.deleted = false and id in ?1")
    Iterable<T> findAllById(Iterable<K> ids);

    /**
     * 统计数量
     *
     * @return long
     */
    @Override
    @Transactional(readOnly = true)
    @Query("select count(1) from #{#entityName} tb where tb.deleted = false")
    long count();

    /**
     * 根据id删除
     *
     * @param id 主键
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    @Query("update #{#entityName} tb set tb.deleted = true where tb.id = ?1")
    @Modifying
    void deleteById(K id);

    /**
     * 删除实体
     *
     * @param entity 实体
     */

    @SuppressWarnings("unchecked")
    @Transactional(rollbackFor = Exception.class)
    default void delete(T entity) {
        deleteById((K) entity.getId());
    }

    /**
     * 根据id删除
     *
     * @param ids 主键
     */
    @SuppressWarnings("unchecked")
    @Transactional(rollbackFor = Exception.class)
    default void deleteAll(Iterable<? extends T> ids) {

        ids.forEach(entity -> deleteById((K) entity.getId()));
    }

    /**
     * 删除所有
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    @Query("update #{#entityName} tb set tb.deleted = true")
    @Modifying
    void deleteAll();

}

