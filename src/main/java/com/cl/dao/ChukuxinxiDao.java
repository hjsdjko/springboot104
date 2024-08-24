package com.cl.dao;

import com.cl.entity.ChukuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChukuxinxiView;


/**
 * 出库信息
 * 
 * @author 
 * @email 
 * @date 2024-03-10 20:37:33
 */
public interface ChukuxinxiDao extends BaseMapper<ChukuxinxiEntity> {
	
	List<ChukuxinxiView> selectListView(@Param("ew") Wrapper<ChukuxinxiEntity> wrapper);

	List<ChukuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ChukuxinxiEntity> wrapper);
	
	ChukuxinxiView selectView(@Param("ew") Wrapper<ChukuxinxiEntity> wrapper);
	

}
