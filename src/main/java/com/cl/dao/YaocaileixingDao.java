package com.cl.dao;

import com.cl.entity.YaocaileixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YaocaileixingView;


/**
 * 药材类型
 * 
 * @author 
 * @email 
 * @date 2024-03-10 20:37:33
 */
public interface YaocaileixingDao extends BaseMapper<YaocaileixingEntity> {
	
	List<YaocaileixingView> selectListView(@Param("ew") Wrapper<YaocaileixingEntity> wrapper);

	List<YaocaileixingView> selectListView(Pagination page,@Param("ew") Wrapper<YaocaileixingEntity> wrapper);
	
	YaocaileixingView selectView(@Param("ew") Wrapper<YaocaileixingEntity> wrapper);
	

}
