package io.github.hyperpay.service.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.hyperpay.service.model.po.ConfigParamPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ConfigParamMapper extends BaseMapper<ConfigParamPO> {

    default List<ConfigParamPO> selectList(ConfigParamPO configParamPO){
        LambdaQueryWrapper<ConfigParamPO> queryWrapper = new QueryWrapper<ConfigParamPO>().lambda()
                .eq(ConfigParamPO::getIsDelete, true)
                ;

        return null;
    }
}