package com.cun.plus.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cun.plus.entity.SuccessKilled;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 秒杀记录表 Mapper 接口
 * </p>
 *
 * @author Zhang.ning
 * @since 2021-02-04
 */
@Mapper
@Repository
public interface SuccessKilledMapper extends BaseMapper<SuccessKilled> {

}