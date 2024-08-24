package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ChukuxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChukuxinxiView;


/**
 * 出库信息
 *
 * @author 
 * @email 
 * @date 2024-03-10 20:37:33
 */
public interface ChukuxinxiService extends IService<ChukuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChukuxinxiView> selectListView(Wrapper<ChukuxinxiEntity> wrapper);
   	
   	ChukuxinxiView selectView(@Param("ew") Wrapper<ChukuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChukuxinxiEntity> wrapper);
   	

}

