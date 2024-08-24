package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.KucunxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KucunxinxiView;


/**
 * 库存信息
 *
 * @author 
 * @email 
 * @date 2024-03-10 20:37:33
 */
public interface KucunxinxiService extends IService<KucunxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KucunxinxiView> selectListView(Wrapper<KucunxinxiEntity> wrapper);
   	
   	KucunxinxiView selectView(@Param("ew") Wrapper<KucunxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KucunxinxiEntity> wrapper);
   	

}

