package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YaocaileixingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YaocaileixingView;


/**
 * 药材类型
 *
 * @author 
 * @email 
 * @date 2024-03-10 20:37:33
 */
public interface YaocaileixingService extends IService<YaocaileixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YaocaileixingView> selectListView(Wrapper<YaocaileixingEntity> wrapper);
   	
   	YaocaileixingView selectView(@Param("ew") Wrapper<YaocaileixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YaocaileixingEntity> wrapper);
   	

}

