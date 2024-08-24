package com.cl.dao;

import com.cl.entity.KucunxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KucunxinxiView;


/**
 * 库存信息
 * 
 * @author 
 * @email 
 * @date 2024-03-10 20:37:33
 */
public interface KucunxinxiDao extends BaseMapper<KucunxinxiEntity> {
	
	List<KucunxinxiView> selectListView(@Param("ew") Wrapper<KucunxinxiEntity> wrapper);

	List<KucunxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<KucunxinxiEntity> wrapper);
	
	KucunxinxiView selectView(@Param("ew") Wrapper<KucunxinxiEntity> wrapper);
	

}
