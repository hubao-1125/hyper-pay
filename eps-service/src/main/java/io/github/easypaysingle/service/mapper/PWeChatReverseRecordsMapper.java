package io.github.easypaysingle.service.mapper;

import static mapper.PWeChatReverseRecordsDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import java.util.List;
import java.util.Optional;
import model.PWeChatReverseRecords;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface PWeChatReverseRecordsMapper extends CommonCountMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BasicColumn[] selectList = BasicColumn.columnList(id, snowId, reverseType, oriPayOrderNumber, refundOrderNumber, orMainOrderNumber, oriMainFlowOrderNumber, thirdRefundOrderNumber, refundStatus, refundAmount, failCode, failReason, notifyTime, isDelete, gmtCreate, gmtUpdate);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PWeChatReverseRecordsResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="snow_id", property="snowId", jdbcType=JdbcType.BIGINT),
        @Result(column="reverse_type", property="reverseType", jdbcType=JdbcType.BIT),
        @Result(column="ori_pay_order_number", property="oriPayOrderNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="refund_order_number", property="refundOrderNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="or_main_order_number", property="orMainOrderNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="ori_main_flow_order_number", property="oriMainFlowOrderNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="third_refund_order_number", property="thirdRefundOrderNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="refund_status", property="refundStatus", jdbcType=JdbcType.BIT),
        @Result(column="refund_amount", property="refundAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="fail_code", property="failCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="fail_reason", property="failReason", jdbcType=JdbcType.VARCHAR),
        @Result(column="notify_time", property="notifyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_delete", property="isDelete", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_update", property="gmtUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<PWeChatReverseRecords> selectMany(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PWeChatReverseRecordsResult")
    Optional<PWeChatReverseRecords> selectOne(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, PWeChatReverseRecords, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<PWeChatReverseRecords> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, PWeChatReverseRecords, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<PWeChatReverseRecords> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, PWeChatReverseRecords, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<PWeChatReverseRecords> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, PWeChatReverseRecords, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<PWeChatReverseRecords> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }
}