package io.github.hyperpay.service.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * Table: p_we_chat_reverse_records
 */
@Data
@Builder
@TableName("p_we_chat_reverse_records")
public class WeChatReverseRecordsPO {
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
     * Column: reverse_type
     * Type: BIT
     * Remark: 逆向类型 1退款 2撤销 3关闭
     */
    private Boolean reverseType;

    /**
     * Column: ori_pay_order_number
     * Type: VARCHAR(64)
     * Remark: 原支付订单号
     */
    private String oriPayOrderNumber;

    /**
     * Column: refund_order_number
     * Type: VARCHAR(64)
     * Remark: 退款订单号
     */
    private String refundOrderNumber;

    /**
     * Column: or_main_order_number
     * Type: VARCHAR(64)
     * Remark: 原主订单号
     */
    private String orMainOrderNumber;

    /**
     * Column: ori_main_flow_order_number
     * Type: VARCHAR(64)
     * Remark: 原主流水号
     */
    private String oriMainFlowOrderNumber;

    /**
     * Column: third_refund_order_number
     * Type: VARCHAR(64)
     * Remark: 三方退款订单号
     */
    private String thirdRefundOrderNumber;

    /**
     * Column: refund_status
     * Type: BIT
     * Default value: 0
     * Remark: 逆向状态 默认 0 处理中 1处理成功
     */
    private Boolean reverseStatus;

    /**
     * Column: refund_amount
     * Type: BIGINT
     * Remark: 退款金额（分）
     */
    private Long refundAmount;

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

}