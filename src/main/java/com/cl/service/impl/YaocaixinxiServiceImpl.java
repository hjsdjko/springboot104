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


import com.cl.dao.YaocaixinxiDao;
import com.cl.entity.YaocaixinxiEntity;
import com.cl.service.YaocaixinxiService;
import com.cl.entity.view.YaocaixinxiView;

@Service("yaocaixinxiService")
public class YaocaixinxiServiceImpl extends ServiceImpl<YaocaixinxiDao, YaocaixinxiEntity> implements YaocaixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YaocaixinxiEntity> page = this.selectPage(
                new Query<YaocaixinxiEntity>(params).getPage(),
                new EntityWrapper<YaocaixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YaocaixinxiEntity> wrapper) {
		  Page<YaocaixinxiView> page =new Query<YaocaixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YaocaixinxiView> selectListView(Wrapper<YaocaixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YaocaixinxiView selectView(Wrapper<YaocaixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
