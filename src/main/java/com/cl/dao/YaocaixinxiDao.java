package com.cl.dao;

import com.cl.entity.YaocaixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YaocaixinxiView;


/**
 * 药材信息
 * 
 * @author 
 * @email 
 * @date 2024-03-10 20:37:33
 */
public interface YaocaixinxiDao extends BaseMapper<YaocaixinxiEntity> {
	
	List<YaocaixinxiView> selectListView(@Param("ew") Wrapper<YaocaixinxiEntity> wrapper);

	List<YaocaixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<YaocaixinxiEntity> wrapper);
	
	YaocaixinxiView selectView(@Param("ew") Wrapper<YaocaixinxiEntity> wrapper);
	

}
