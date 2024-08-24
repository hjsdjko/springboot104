package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YaocaixinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YaocaixinxiView;


/**
 * 药材信息
 *
 * @author 
 * @email 
 * @date 2024-03-10 20:37:33
 */
public interface YaocaixinxiService extends IService<YaocaixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YaocaixinxiView> selectListView(Wrapper<YaocaixinxiEntity> wrapper);
   	
   	YaocaixinxiView selectView(@Param("ew") Wrapper<YaocaixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YaocaixinxiEntity> wrapper);
   	

}

