package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ChukuxinxiDao;
import com.cl.entity.ChukuxinxiEntity;
import com.cl.service.ChukuxinxiService;
import com.cl.entity.view.ChukuxinxiView;

@Service("chukuxinxiService")
public class ChukuxinxiServiceImpl extends ServiceImpl<ChukuxinxiDao, ChukuxinxiEntity> implements ChukuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChukuxinxiEntity> page = this.selectPage(
                new Query<ChukuxinxiEntity>(params).getPage(),
                new EntityWrapper<ChukuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChukuxinxiEntity> wrapper) {
		  Page<ChukuxinxiView> page =new Query<ChukuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ChukuxinxiView> selectListView(Wrapper<ChukuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChukuxinxiView selectView(Wrapper<ChukuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
