package com.fy.spring.tx.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 基础实体User 类
 * 主键自增，userName为UNIQUE
 *
 * @author zhangjiuliang
 * @date 2018/07/20
 */
@Entity
@Table(name="USER")
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID", nullable = false)
	private int id;
	
	@Column(name="USERNAME", nullable = false)
	private String username;
	
	@Column(name="NAME", nullable = false)
	private String name;

}
