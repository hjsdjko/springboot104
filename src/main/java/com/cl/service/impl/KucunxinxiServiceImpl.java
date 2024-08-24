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


import com.cl.dao.KucunxinxiDao;
import com.cl.entity.KucunxinxiEntity;
import com.cl.service.KucunxinxiService;
import com.cl.entity.view.KucunxinxiView;

@Service("kucunxinxiService")
public class KucunxinxiServiceImpl extends ServiceImpl<KucunxinxiDao, KucunxinxiEntity> implements KucunxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KucunxinxiEntity> page = this.selectPage(
                new Query<KucunxinxiEntity>(params).getPage(),
                new EntityWrapper<KucunxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KucunxinxiEntity> wrapper) {
		  Page<KucunxinxiView> page =new Query<KucunxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<KucunxinxiView> selectListView(Wrapper<KucunxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KucunxinxiView selectView(Wrapper<KucunxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
