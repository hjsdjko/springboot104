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

import com.cl.entity.YaocaileixingEntity;
import com.cl.entity.view.YaocaileixingView;

import com.cl.service.YaocaileixingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 药材类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-10 20:37:33
 */
@RestController
@RequestMapping("/yaocaileixing")
public class YaocaileixingController {
    @Autowired
    private YaocaileixingService yaocaileixingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YaocaileixingEntity yaocaileixing,
		HttpServletRequest request){
        EntityWrapper<YaocaileixingEntity> ew = new EntityWrapper<YaocaileixingEntity>();

		PageUtils page = yaocaileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yaocaileixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YaocaileixingEntity yaocaileixing, 
		HttpServletRequest request){
        EntityWrapper<YaocaileixingEntity> ew = new EntityWrapper<YaocaileixingEntity>();

		PageUtils page = yaocaileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yaocaileixing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YaocaileixingEntity yaocaileixing){
       	EntityWrapper<YaocaileixingEntity> ew = new EntityWrapper<YaocaileixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yaocaileixing, "yaocaileixing")); 
        return R.ok().put("data", yaocaileixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YaocaileixingEntity yaocaileixing){
        EntityWrapper< YaocaileixingEntity> ew = new EntityWrapper< YaocaileixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yaocaileixing, "yaocaileixing")); 
		YaocaileixingView yaocaileixingView =  yaocaileixingService.selectView(ew);
		return R.ok("查询药材类型成功").put("data", yaocaileixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YaocaileixingEntity yaocaileixing = yaocaileixingService.selectById(id);
		yaocaileixing = yaocaileixingService.selectView(new EntityWrapper<YaocaileixingEntity>().eq("id", id));
        return R.ok().put("data", yaocaileixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YaocaileixingEntity yaocaileixing = yaocaileixingService.selectById(id);
		yaocaileixing = yaocaileixingService.selectView(new EntityWrapper<YaocaileixingEntity>().eq("id", id));
        return R.ok().put("data", yaocaileixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YaocaileixingEntity yaocaileixing, HttpServletRequest request){
    	yaocaileixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yaocaileixing);
        yaocaileixingService.insert(yaocaileixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YaocaileixingEntity yaocaileixing, HttpServletRequest request){
    	yaocaileixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yaocaileixing);
        yaocaileixingService.insert(yaocaileixing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YaocaileixingEntity yaocaileixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yaocaileixing);
        yaocaileixingService.updateById(yaocaileixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yaocaileixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
