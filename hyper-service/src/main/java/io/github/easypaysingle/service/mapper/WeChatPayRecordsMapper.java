package io.github.easypaysingle.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.easypaysingle.service.model.po.WeChatPayRecordsPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WeChatPayRecordsMapper extends BaseMapper<WeChatPayRecordsPO> {

}