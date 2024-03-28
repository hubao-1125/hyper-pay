package io.github.easypaysingle.service.model;

import java.util.Date;

/**
 * Table: p_config_param
 */
public class PConfigParam {
    /**
     * Column: id
     * Type: BIGINT
     * Remark: 主键 ID
     */
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
     * Column: payway_code
     * Type: VARCHAR(32)
     * Remark: 支付方式编码
     */
    private String paywayCode;

    /**
     * Column: pay_terminal_code
     * Type: VARCHAR(32)
     * Remark: 支付终端编码
     */
    private String payTerminalCode;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSnowId() {
        return snowId;
    }

    public void setSnowId(Long snowId) {
        this.snowId = snowId;
    }

    public String getParamKey() {
        return paramKey;
    }

    public void setParamKey(String paramKey) {
        this.paramKey = paramKey == null ? null : paramKey.trim();
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue == null ? null : paramValue.trim();
    }

    public String getPaywayCode() {
        return paywayCode;
    }

    public void setPaywayCode(String paywayCode) {
        this.paywayCode = paywayCode == null ? null : paywayCode.trim();
    }

    public String getPayTerminalCode() {
        return payTerminalCode;
    }

    public void setPayTerminalCode(String payTerminalCode) {
        this.payTerminalCode = payTerminalCode == null ? null : payTerminalCode.trim();
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}