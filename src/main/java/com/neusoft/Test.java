package com.neusoft;

import com.neusoft.bean.Classes;
import com.neusoft.bean.Student;
import com.neusoft.dao.ClassesMapper;
import com.neusoft.dao.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args)
    {
        try {

            String path="mybatisConfig.xml";
            InputStream ips= Resources.getResourceAsStream(path);
            SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(ips);
            SqlSession session=sessionFactory.openSession();

//           StudentMapper mapper=session.getMapper(StudentMapper.class);
//          List<Student> students=mapper.selectAll();
//            for (Student stu:students
//                 ) {
//                System.out.println(stu.getStudentname()+"--"+stu.getClasses().getClassname());
//            }

            ClassesMapper mapper=session.getMapper(ClassesMapper.class);
            List<Classes> list=mapper.selectAll();
            for (Classes cl:list
                 ) {
                System.out.println(cl.getClassname()+"有"+cl.getStudents().size()+"位学生");
                for (Student s:cl.getStudents()
                     ) {
                    System.out.println(s.getStudentname());
                }
            }


        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
