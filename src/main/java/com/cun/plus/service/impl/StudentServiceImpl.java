package com.cun.plus.service.impl;

import com.cun.plus.entity.Student;
import com.cun.plus.mapper.StudentMapper;
import com.cun.plus.service.StudentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生信息表 服务实现类
 * </p>
 *
 * @author Zhang.ning
 * @since 2021-02-03
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
