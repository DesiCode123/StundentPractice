package com.studentnew.demo.controller;

import com.studentnew.demo.entity.NewStudent;
import com.studentnew.demo.exceptions.BadRequestException;
import com.studentnew.demo.services.NewStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController

public class StudentController {
    @Autowired
    private NewStudentService newStudentService;

    @PostMapping("/saveAll")
    public ResponseEntity<NewStudent> saveStudent(@Valid @RequestBody NewStudent student){
        NewStudent savedStud = newStudentService.saveStudent(student);
        return new ResponseEntity<>(savedStud, HttpStatus.CREATED);
    }
    @GetMapping("/testFrontend")
    public String testingMessege(Model model){
        System.out.println("hello world");

    }


    @PutMapping("/updateStudent/{newStudentId}")
    public NewStudent updateStudent(@PathVariable Long newStudentId, @RequestBody NewStudent student) {
        if(student.getNewStudentId() != null && !student.getNewStudentId().equals(newStudentId)) {
            throw new BadRequestException("ID in path does not match ID in request body");
        }//logic in service
        return newStudentService.updateStudent(newStudentId, student);
    }

    @GetMapping("/findById")
    public NewStudent findById(@RequestParam Long newStudentId){
        return newStudentService.getStudentById(newStudentId).get();
    }

    @DeleteMapping("/deleteById")
    public void deleteById(@RequestParam Long newStudentId){
        newStudentService.deleteById(newStudentId);
    }
}
