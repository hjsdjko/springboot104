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

import com.cl.entity.ChukuxinxiEntity;
import com.cl.entity.view.ChukuxinxiView;

import com.cl.service.ChukuxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 出库信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-10 20:37:33
 */
@RestController
@RequestMapping("/chukuxinxi")
public class ChukuxinxiController {
    @Autowired
    private ChukuxinxiService chukuxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChukuxinxiEntity chukuxinxi,
		HttpServletRequest request){
        EntityWrapper<ChukuxinxiEntity> ew = new EntityWrapper<ChukuxinxiEntity>();

		PageUtils page = chukuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chukuxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChukuxinxiEntity chukuxinxi, 
		HttpServletRequest request){
        EntityWrapper<ChukuxinxiEntity> ew = new EntityWrapper<ChukuxinxiEntity>();

		PageUtils page = chukuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chukuxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChukuxinxiEntity chukuxinxi){
       	EntityWrapper<ChukuxinxiEntity> ew = new EntityWrapper<ChukuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chukuxinxi, "chukuxinxi")); 
        return R.ok().put("data", chukuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChukuxinxiEntity chukuxinxi){
        EntityWrapper< ChukuxinxiEntity> ew = new EntityWrapper< ChukuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chukuxinxi, "chukuxinxi")); 
		ChukuxinxiView chukuxinxiView =  chukuxinxiService.selectView(ew);
		return R.ok("查询出库信息成功").put("data", chukuxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChukuxinxiEntity chukuxinxi = chukuxinxiService.selectById(id);
		chukuxinxi = chukuxinxiService.selectView(new EntityWrapper<ChukuxinxiEntity>().eq("id", id));
        return R.ok().put("data", chukuxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChukuxinxiEntity chukuxinxi = chukuxinxiService.selectById(id);
		chukuxinxi = chukuxinxiService.selectView(new EntityWrapper<ChukuxinxiEntity>().eq("id", id));
        return R.ok().put("data", chukuxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChukuxinxiEntity chukuxinxi, HttpServletRequest request){
    	chukuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chukuxinxi);
        chukuxinxiService.insert(chukuxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChukuxinxiEntity chukuxinxi, HttpServletRequest request){
    	chukuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chukuxinxi);
        chukuxinxiService.insert(chukuxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChukuxinxiEntity chukuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chukuxinxi);
        chukuxinxiService.updateById(chukuxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chukuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
