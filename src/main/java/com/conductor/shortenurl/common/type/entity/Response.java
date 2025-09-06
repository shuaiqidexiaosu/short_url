package com.conductor.shortenurl.common.type.entity;

/*
 * @author: enping.jep
 * @create: 2023-04-18 3:01 PM
 */

import com.conductor.shortenurl.common.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Response")
public class Response extends BaseEntity {

  //返回码
  private Integer code;

  //返回信息
  private String msg;

  //业务数据
  private Object data;

  public static Response successs(String msg, Object data) {
    return new Response(200, msg, data);
  }

  public static Response create(Integer code, String msg) {
    return new Response(code, msg);
  }

  /**
   * 构造方法
   */
  public Response(Integer code, String msg, Object data) {
    this.code = code;
    this.msg = msg;
    this.data = data;
  }

  public Response(Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }
}
