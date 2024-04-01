package io.github.easypaysingle.service.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 功能描述: 系统参数字典表-类
 *
 * @author hubao
 * @since 2024/3/29$ 17:38$
 */
@Data
@Builder
@TableName("p_system_param_dict")
public class SystemParamDictPO implements Serializable {
    /**
     * Column: id
     * Type: BIGINT
     * Remark: 主键 ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * Column: snow_id
     * Type: BIGINT
     * Remark: 雪花 ID
     */
    private Long snowId;

    /**
     * Column: param_key
     * Type: VARCHAR(32)
     * Remark: 参数 key
     */
    private String paramKey;

    /**
     * Column: param_value
     * Type: VARCHAR(5000)
     * Remark: 参数 value
     */
    private String paramValue;


    /**
     * Column: is_delete
     * Type: BIT
     * Default value: 0
     * Remark: 是否删除 默认 0 否 1 是
     */
    private Boolean isDelete;

    /**
     * Column: gmt_create
     * Type: DATETIME
     * Default value: CURRENT_TIMESTAMP
     * Remark: 创建时间
     */
    private Date gmtCreate;

}
