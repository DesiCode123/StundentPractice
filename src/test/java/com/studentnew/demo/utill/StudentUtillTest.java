package com.studentnew.demo.utill;

import com.studentnew.demo.entity.NewStudent;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class StudentUtillTest {
    private StudentUtill studentUtill = new StudentUtill();

    @Test
    public void studentIsPresentTest() {
        assertEquals(true,studentUtill.studentIsPresent(getStudentList(),"Sharmila"));
        assertEquals(false,studentUtill.studentIsPresent(getStudentList(),"test"));
    }
    //take studentlist-return student object with minimum id value,lamda
    public List<NewStudent> getStudentList(){
        List<NewStudent> student = new ArrayList<>();
        student.add(new NewStudent(1L,"Sharmila","Ratnasingam","sharmila@live.no","4790104261",null));
        student.add(new NewStudent(2L,"Desi","Ratnasingam","desi@live.no","4790133261",null));
        student.add(new NewStudent(3L,"Sila","Ragam","shaa@live.no","4704261",null));
        return student;

    }

    @Test
    public void getStudentByIdTest() {
        assertNotNull(getStudentById().getNewStudentId());
        assertEquals(Long.valueOf(4),getStudentById().getNewStudentId());

    }

    public static NewStudent getStudentById(){
        List<NewStudent> studId = new ArrayList<>();
        studId.add(new NewStudent(4L,"Sharmila","Ratnasingam","sharmila@live.no","4790104261",null));
        studId.add(new NewStudent(5L,"Desi","Ratnasingam","desi@live.no","4790133261",null));
        studId.add(new NewStudent(7L,"Sila","Ragam","shaa@live.no","4704261",null));

       NewStudent result = studId.stream().min(Comparator.comparing(NewStudent::getNewStudentId))
                .orElse(null);
        System.out.println(result);
       return result;


    }
}