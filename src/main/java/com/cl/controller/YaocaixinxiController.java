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

import com.cl.entity.YaocaixinxiEntity;
import com.cl.entity.view.YaocaixinxiView;

import com.cl.service.YaocaixinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 药材信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-10 20:37:33
 */
@RestController
@RequestMapping("/yaocaixinxi")
public class YaocaixinxiController {
    @Autowired
    private YaocaixinxiService yaocaixinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YaocaixinxiEntity yaocaixinxi,
		HttpServletRequest request){
        EntityWrapper<YaocaixinxiEntity> ew = new EntityWrapper<YaocaixinxiEntity>();

		PageUtils page = yaocaixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yaocaixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YaocaixinxiEntity yaocaixinxi, 
		HttpServletRequest request){
        EntityWrapper<YaocaixinxiEntity> ew = new EntityWrapper<YaocaixinxiEntity>();

		PageUtils page = yaocaixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yaocaixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YaocaixinxiEntity yaocaixinxi){
       	EntityWrapper<YaocaixinxiEntity> ew = new EntityWrapper<YaocaixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yaocaixinxi, "yaocaixinxi")); 
        return R.ok().put("data", yaocaixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YaocaixinxiEntity yaocaixinxi){
        EntityWrapper< YaocaixinxiEntity> ew = new EntityWrapper< YaocaixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yaocaixinxi, "yaocaixinxi")); 
		YaocaixinxiView yaocaixinxiView =  yaocaixinxiService.selectView(ew);
		return R.ok("查询药材信息成功").put("data", yaocaixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YaocaixinxiEntity yaocaixinxi = yaocaixinxiService.selectById(id);
		yaocaixinxi = yaocaixinxiService.selectView(new EntityWrapper<YaocaixinxiEntity>().eq("id", id));
        return R.ok().put("data", yaocaixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YaocaixinxiEntity yaocaixinxi = yaocaixinxiService.selectById(id);
		yaocaixinxi = yaocaixinxiService.selectView(new EntityWrapper<YaocaixinxiEntity>().eq("id", id));
        return R.ok().put("data", yaocaixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YaocaixinxiEntity yaocaixinxi, HttpServletRequest request){
    	yaocaixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yaocaixinxi);
        yaocaixinxiService.insert(yaocaixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YaocaixinxiEntity yaocaixinxi, HttpServletRequest request){
    	yaocaixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yaocaixinxi);
        yaocaixinxiService.insert(yaocaixinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YaocaixinxiEntity yaocaixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yaocaixinxi);
        yaocaixinxiService.updateById(yaocaixinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yaocaixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
