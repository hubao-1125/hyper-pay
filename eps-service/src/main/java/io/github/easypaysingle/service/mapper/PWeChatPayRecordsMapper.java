package io.github.easypaysingle.service.mapper;

import static mapper.PWeChatPayRecordsDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import java.util.List;
import java.util.Optional;
import model.PWeChatPayRecords;
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
public interface PWeChatPayRecordsMapper extends CommonCountMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BasicColumn[] selectList = BasicColumn.columnList(id, snowId, terminalCode, terminalName, goodsDesc, payOrderNumber, sourceCode, sourceName, mainOrderNumber, mainFlowOrderNumber, thirdOrderNumber, payStatus, amount, canRefundAmount, attachInfo, failCode, failReason, notifyTime, isDelete, gmtCreate, gmtUpdate);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PWeChatPayRecordsResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="snow_id", property="snowId", jdbcType=JdbcType.BIGINT),
        @Result(column="terminal_code", property="terminalCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="terminal_name", property="terminalName", jdbcType=JdbcType.VARCHAR),
        @Result(column="goods_desc", property="goodsDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_order_number", property="payOrderNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="source_code", property="sourceCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="source_name", property="sourceName", jdbcType=JdbcType.VARCHAR),
        @Result(column="main_order_number", property="mainOrderNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="main_flow_order_number", property="mainFlowOrderNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="third_order_number", property="thirdOrderNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_status", property="payStatus", jdbcType=JdbcType.BIT),
        @Result(column="amount", property="amount", jdbcType=JdbcType.BIGINT),
        @Result(column="can_refund_amount", property="canRefundAmount", jdbcType=JdbcType.BIGINT),
        @Result(column="attach_info", property="attachInfo", jdbcType=JdbcType.VARCHAR),
        @Result(column="fail_code", property="failCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="fail_reason", property="failReason", jdbcType=JdbcType.VARCHAR),
        @Result(column="notify_time", property="notifyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_delete", property="isDelete", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_update", property="gmtUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<PWeChatPayRecords> selectMany(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PWeChatPayRecordsResult")
    Optional<PWeChatPayRecords> selectOne(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, PWeChatPayRecords, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<PWeChatPayRecords> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, PWeChatPayRecords, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<PWeChatPayRecords> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, PWeChatPayRecords, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<PWeChatPayRecords> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, PWeChatPayRecords, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<PWeChatPayRecords> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }
}