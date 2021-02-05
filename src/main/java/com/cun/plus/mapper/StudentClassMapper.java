package com.cun.plus.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cun.plus.entity.StudentClass;
import org.apache.ibatis.annotations.*;

public interface StudentClassMapper extends BaseMapper<StudentClass> {
    /**
     * 一对多
     * @param classID
     * @return
     */
    @Results(id="resMap",value = {
            @Result(property = "classId",column = "ClassId"),
            @Result(property = "className",column = "ClassName"),
            @Result(property = "studentLists",column = "ClassId",many= @Many(select = "com.cun.plus.mapper.StudentMapper.findStudentByClassId"))
    })
    @Select("select * from stuclass where ClassId = #{classID}")
    StudentClass findStudentClassById(int classID);
}