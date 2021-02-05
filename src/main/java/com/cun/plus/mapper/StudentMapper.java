package com.cun.plus.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cun.plus.entity.Student;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 学生信息表 Mapper 接口
 * </p>
 *
 * @author Zhang.ning
 * @since 2021-02-03
 */
public interface StudentMapper extends BaseMapper<Student> {

    @Results(id="resMap",value = {
            @Result(property = "id",column = "Id"),
            @Result(property = "name",column = "SName"),
            @Result(property = "age",column = "Age"),
            @Result(property = "classId",column = "ClassID"),
            @Result(property = "studentClass",column = "ClassID",one = @One(select = "com.cun.plus.mapper.StudentClassMapper.selectById"))
    })
    @Select("select * from student where Id = #{id}")
    Student findStudentById(int id);


    @Results(id="resMap2",value = {
            @Result(property = "id",column = "Id"),
            @Result(property = "name",column = "SName"),
            @Result(property = "age",column = "Age"),
            @Result(property = "classId",column = "ClassID"),
            @Result(property = "studentClass",column = "ClassID",one = @One(select = "com.cun.plus.mapper.StudentClassMapper.selectById"))
    })
    @Select("select * from student where classID = #{classID}")
    List<Student> findStudentByClassId(int classID);
}
