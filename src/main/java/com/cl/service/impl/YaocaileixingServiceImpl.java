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


import com.cl.dao.YaocaileixingDao;
import com.cl.entity.YaocaileixingEntity;
import com.cl.service.YaocaileixingService;
import com.cl.entity.view.YaocaileixingView;

@Service("yaocaileixingService")
public class YaocaileixingServiceImpl extends ServiceImpl<YaocaileixingDao, YaocaileixingEntity> implements YaocaileixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YaocaileixingEntity> page = this.selectPage(
                new Query<YaocaileixingEntity>(params).getPage(),
                new EntityWrapper<YaocaileixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YaocaileixingEntity> wrapper) {
		  Page<YaocaileixingView> page =new Query<YaocaileixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YaocaileixingView> selectListView(Wrapper<YaocaileixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YaocaileixingView selectView(Wrapper<YaocaileixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
