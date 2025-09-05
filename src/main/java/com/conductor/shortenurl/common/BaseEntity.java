package com.conductor.shortenurl.common;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @program: BaseEntity
 * @description:
 * @author: 智慧的苏苏
 * @create: 2025-09-05 16:39
 **/
@Data
//用于标记一个类，表示这个类不是实体类，而是作为其他实体类的基类使用
@MappedSuperclass
public class BaseEntity implements Serializable {
    protected static final long serialVersionUID = 1L;

    /**
     * 自增ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;


}
