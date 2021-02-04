package com.cun.plus;

import com.cun.plus.entity.Student;
import com.cun.plus.entity.StudentClass;
import com.cun.plus.mapper.StudentClassMapper;
import com.cun.plus.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author ning11.zhang
 * @Description:
 * @date 2021/2/3
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTests {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentClassMapper studentClassMapper;

    @Test
    public void selectById() {
//        Student studentById = studentMapper.findStudentById(8);
//        System.out.println(studentById);


//        List<Student> studentByClassId = studentMapper.findStudentByClassId(7);
//        for (Student student : studentByClassId) {
//            System.out.println(student);
//        }

        StudentClass studentClassById = studentClassMapper.findStudentClassById(7);
        System.out.println(studentClassById);

        List<Student> studentLists = studentClassById.getStudentLists();
        for (Student studentList : studentLists) {
            System.out.println(studentList);
        }

    }
}
