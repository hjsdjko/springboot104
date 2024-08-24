package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.KucunxinxiEntity;
import com.cl.entity.view.KucunxinxiView;

import com.cl.service.KucunxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 库存信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-10 20:37:33
 */
@RestController
@RequestMapping("/kucunxinxi")
public class KucunxinxiController {
    @Autowired
    private KucunxinxiService kucunxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KucunxinxiEntity kucunxinxi,
		HttpServletRequest request){
        EntityWrapper<KucunxinxiEntity> ew = new EntityWrapper<KucunxinxiEntity>();

		PageUtils page = kucunxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kucunxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KucunxinxiEntity kucunxinxi, 
		HttpServletRequest request){
        EntityWrapper<KucunxinxiEntity> ew = new EntityWrapper<KucunxinxiEntity>();

		PageUtils page = kucunxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kucunxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KucunxinxiEntity kucunxinxi){
       	EntityWrapper<KucunxinxiEntity> ew = new EntityWrapper<KucunxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kucunxinxi, "kucunxinxi")); 
        return R.ok().put("data", kucunxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KucunxinxiEntity kucunxinxi){
        EntityWrapper< KucunxinxiEntity> ew = new EntityWrapper< KucunxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kucunxinxi, "kucunxinxi")); 
		KucunxinxiView kucunxinxiView =  kucunxinxiService.selectView(ew);
		return R.ok("查询库存信息成功").put("data", kucunxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KucunxinxiEntity kucunxinxi = kucunxinxiService.selectById(id);
		kucunxinxi = kucunxinxiService.selectView(new EntityWrapper<KucunxinxiEntity>().eq("id", id));
        return R.ok().put("data", kucunxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KucunxinxiEntity kucunxinxi = kucunxinxiService.selectById(id);
		kucunxinxi = kucunxinxiService.selectView(new EntityWrapper<KucunxinxiEntity>().eq("id", id));
        return R.ok().put("data", kucunxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KucunxinxiEntity kucunxinxi, HttpServletRequest request){
    	kucunxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kucunxinxi);
        kucunxinxiService.insert(kucunxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KucunxinxiEntity kucunxinxi, HttpServletRequest request){
    	kucunxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kucunxinxi);
        kucunxinxiService.insert(kucunxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KucunxinxiEntity kucunxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kucunxinxi);
        kucunxinxiService.updateById(kucunxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kucunxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
