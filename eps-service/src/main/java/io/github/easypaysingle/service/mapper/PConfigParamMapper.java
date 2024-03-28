package io.github.easypaysingle.service.mapper;

import static mapper.PConfigParamDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import java.util.List;
import java.util.Optional;
import model.PConfigParam;
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
public interface PConfigParamMapper extends CommonCountMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BasicColumn[] selectList = BasicColumn.columnList(id, snowId, paramKey, paramValue, paywayCode, payTerminalCode, isDelete, gmtCreate);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PConfigParamResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="snow_id", property="snowId", jdbcType=JdbcType.BIGINT),
        @Result(column="param_key", property="paramKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="param_value", property="paramValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="payway_code", property="paywayCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_terminal_code", property="payTerminalCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_delete", property="isDelete", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<PConfigParam> selectMany(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PConfigParamResult")
    Optional<PConfigParam> selectOne(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, PConfigParam, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<PConfigParam> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, PConfigParam, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<PConfigParam> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, PConfigParam, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<PConfigParam> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, PConfigParam, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<PConfigParam> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }
}