package com.cun.plus.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.*;

import java.util.List;

@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "stuclass")
public class StudentClass {
    @TableId(value = "ClassId",type = IdType.AUTO)
    private int classId;
    @TableField(value = "ClassName")
    private String className;

    @TableField(exist = false)
    private List<Student> studentLists;
}