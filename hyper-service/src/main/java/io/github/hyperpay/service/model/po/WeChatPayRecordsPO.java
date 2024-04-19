package io.github.hyperpay.service.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * Table: p_we_chat_pay_records
 */
@Data
@Builder
@TableName("p_we_chat_pay_records")
public class WeChatPayRecordsPO {
    /**
     * Column: id
     * Type: BIGINT
     * Remark: 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * Column: snow_id
     * Type: BIGINT
     * Remark: 雪花算法 ID
     */
    private Long snowId;

    /**
     * Column: terminal_code
     * Type: VARCHAR(16)
     * Remark: 支付终端编码
     */
    private String terminalCode;

    /**
     * Column: terminal_name
     * Type: VARCHAR(16)
     * Remark: 支付终端编码
     */
    private String terminalName;

    /**
     * Column: goods_desc
     * Type: VARCHAR(64)
     * Remark: 商品描述
     */
    private String goodsDesc;

    /**
     * Column: pay_order_number
     * Type: VARCHAR(64)
     * Remark: 支付订单号
     */
    private String payOrderNumber;

    /**
     * Column: source_code
     * Type: VARCHAR(16)
     * Remark: 来源系统编码
     */
    private String sourceCode;

    /**
     * Column: source_name
     * Type: VARCHAR(16)
     * Remark: 来源系统名称
     */
    private String sourceName;

    /**
     * Column: main_order_number
     * Type: VARCHAR(64)
     * Remark: 主订单号
     */
    private String mainOrderNumber;

    /**
     * Column: main_flow_order_number
     * Type: VARCHAR(64)
     * Remark: 主流水号
     */
    private String mainFlowOrderNumber;

    /**
     * Column: third_order_number
     * Type: VARCHAR(64)
     * Remark: 三方支付订单号
     */
    private String thirdOrderNumber;

    /**
     * Column: pay_status
     * Type: BIT
     * Default value: 0
     * Remark: 支付状态 默认0支付中 1支付成功
     */
    private Boolean payStatus;

    /**
     * Column: amount
     * Type: BIGINT
     * Remark: 订单金额（分）
     */
    private Long amount;

    /**
     * Column: can_refund_amount
     * Type: BIGINT
     * Remark: 可退款订单金额（分）
     */
    private Long canRefundAmount;

    /**
     * Column: attach_info
     * Type: VARCHAR(32)
     * Remark: 附加信息
     */
    private String attachInfo;

    /**
     * Column: fail_code
     * Type: VARCHAR(64)
     * Remark: 失败编码
     */
    private String failCode;

    /**
     * Column: fail_reason
     * Type: VARCHAR(64)
     * Remark: 失败原因
     */
    private String failReason;

    /**
     * Column: notify_time
     * Type: DATETIME
     * Remark: 异步回调时间
     */
    private Date notifyTime;

    /**
     * Column: is_delete
     * Type: BIT
     * Default value: 0
     * Remark: 是否删除 0否 1是
     */
    private Boolean isDelete;

    /**
     * Column: gmt_create
     * Type: DATETIME
     * Default value: CURRENT_TIMESTAMP
     * Remark: 创建时间
     */
    private Date gmtCreate;

    /**
     * Column: gmt_update
     * Type: DATETIME
     * Remark: 更新时间
     */
    private Date gmtUpdate;

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

    public String getTerminalCode() {
        return terminalCode;
    }

    public void setTerminalCode(String terminalCode) {
        this.terminalCode = terminalCode == null ? null : terminalCode.trim();
    }

    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName == null ? null : terminalName.trim();
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc == null ? null : goodsDesc.trim();
    }

    public String getPayOrderNumber() {
        return payOrderNumber;
    }

    public void setPayOrderNumber(String payOrderNumber) {
        this.payOrderNumber = payOrderNumber == null ? null : payOrderNumber.trim();
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode == null ? null : sourceCode.trim();
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName == null ? null : sourceName.trim();
    }

    public String getMainOrderNumber() {
        return mainOrderNumber;
    }

    public void setMainOrderNumber(String mainOrderNumber) {
        this.mainOrderNumber = mainOrderNumber == null ? null : mainOrderNumber.trim();
    }

    public String getMainFlowOrderNumber() {
        return mainFlowOrderNumber;
    }

    public void setMainFlowOrderNumber(String mainFlowOrderNumber) {
        this.mainFlowOrderNumber = mainFlowOrderNumber == null ? null : mainFlowOrderNumber.trim();
    }

    public String getThirdOrderNumber() {
        return thirdOrderNumber;
    }

    public void setThirdOrderNumber(String thirdOrderNumber) {
        this.thirdOrderNumber = thirdOrderNumber == null ? null : thirdOrderNumber.trim();
    }

    public Boolean getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Boolean payStatus) {
        this.payStatus = payStatus;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getCanRefundAmount() {
        return canRefundAmount;
    }

    public void setCanRefundAmount(Long canRefundAmount) {
        this.canRefundAmount = canRefundAmount;
    }

    public String getAttachInfo() {
        return attachInfo;
    }

    public void setAttachInfo(String attachInfo) {
        this.attachInfo = attachInfo == null ? null : attachInfo.trim();
    }

    public String getFailCode() {
        return failCode;
    }

    public void setFailCode(String failCode) {
        this.failCode = failCode == null ? null : failCode.trim();
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason == null ? null : failReason.trim();
    }

    public Date getNotifyTime() {
        return notifyTime;
    }

    public void setNotifyTime(Date notifyTime) {
        this.notifyTime = notifyTime;
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

    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }
}