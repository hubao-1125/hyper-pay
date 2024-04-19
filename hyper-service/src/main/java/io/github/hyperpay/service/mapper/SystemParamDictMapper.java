package io.github.hyperpay.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.hyperpay.service.model.po.SystemParamDictPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 功能描述: 系统参数字典-接口
 *
 * @author hubao
 * @since 2024/3/29$ 18:00$
 */
@Mapper
public interface SystemParamDictMapper extends BaseMapper<SystemParamDictPO> {
}
