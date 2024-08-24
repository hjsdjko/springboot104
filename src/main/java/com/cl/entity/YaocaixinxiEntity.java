package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 药材信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-10 20:37:33
 */
@TableName("yaocaixinxi")
public class YaocaixinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YaocaixinxiEntity() {
		
	}
	
	public YaocaixinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 药材名称
	 */
					
	private String yaocaimingcheng;
	
	/**
	 * 药材类型
	 */
					
	private String yaocaileixing;
	
	/**
	 * 药材图片
	 */
					
	private String yaocaitupian;
	
	/**
	 * 规格
	 */
					
	private String guige;
	
	/**
	 * 储藏方式
	 */
					
	private String chuzangfangshi;
	
	/**
	 * 适宜人群
	 */
					
	private String shiyirenqun;
	
	/**
	 * 主要功效
	 */
					
	private String zhuyaogongxiao;
	
	/**
	 * 价格/g
	 */
					
	private Double price;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：药材名称
	 */
	public void setYaocaimingcheng(String yaocaimingcheng) {
		this.yaocaimingcheng = yaocaimingcheng;
	}
	/**
	 * 获取：药材名称
	 */
	public String getYaocaimingcheng() {
		return yaocaimingcheng;
	}
	/**
	 * 设置：药材类型
	 */
	public void setYaocaileixing(String yaocaileixing) {
		this.yaocaileixing = yaocaileixing;
	}
	/**
	 * 获取：药材类型
	 */
	public String getYaocaileixing() {
		return yaocaileixing;
	}
	/**
	 * 设置：药材图片
	 */
	public void setYaocaitupian(String yaocaitupian) {
		this.yaocaitupian = yaocaitupian;
	}
	/**
	 * 获取：药材图片
	 */
	public String getYaocaitupian() {
		return yaocaitupian;
	}
	/**
	 * 设置：规格
	 */
	public void setGuige(String guige) {
		this.guige = guige;
	}
	/**
	 * 获取：规格
	 */
	public String getGuige() {
		return guige;
	}
	/**
	 * 设置：储藏方式
	 */
	public void setChuzangfangshi(String chuzangfangshi) {
		this.chuzangfangshi = chuzangfangshi;
	}
	/**
	 * 获取：储藏方式
	 */
	public String getChuzangfangshi() {
		return chuzangfangshi;
	}
	/**
	 * 设置：适宜人群
	 */
	public void setShiyirenqun(String shiyirenqun) {
		this.shiyirenqun = shiyirenqun;
	}
	/**
	 * 获取：适宜人群
	 */
	public String getShiyirenqun() {
		return shiyirenqun;
	}
	/**
	 * 设置：主要功效
	 */
	public void setZhuyaogongxiao(String zhuyaogongxiao) {
		this.zhuyaogongxiao = zhuyaogongxiao;
	}
	/**
	 * 获取：主要功效
	 */
	public String getZhuyaogongxiao() {
		return zhuyaogongxiao;
	}
	/**
	 * 设置：价格/g
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * 获取：价格/g
	 */
	public Double getPrice() {
		return price;
	}

}
