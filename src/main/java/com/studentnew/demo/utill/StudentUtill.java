package com.studentnew.demo.utill;

import com.studentnew.demo.entity.NewStudent;

import java.util.List;

public class StudentUtill {
    public boolean studentIsPresent(List<NewStudent> studentList,String studentName){
        return studentList.stream().filter(student -> student.getFirstName().equals(studentName))
                .findFirst().isPresent();

    }


        //method find id
}
