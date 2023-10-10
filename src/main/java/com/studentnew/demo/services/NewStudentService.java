package com.studentnew.demo.services;

import com.studentnew.demo.entity.NewStudent;

import com.studentnew.demo.exceptions.StudentNotFoundException;
import com.studentnew.demo.repository.NewStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewStudentService {

    @Autowired
    public NewStudentRepository newStudentRepository;

    public NewStudent saveStudent(NewStudent student){
        return newStudentRepository.save(student);
    }

    public List<NewStudent> getAllStudents(){
        return newStudentRepository.findAll();
    }

    public NewStudent updateStudent(Long newStudentId, NewStudent student) {
        Optional<NewStudent> existingStudentOpt = newStudentRepository.findById(newStudentId);
        if (existingStudentOpt.isPresent()) {
            NewStudent existingStudent = existingStudentOpt.get();
            // Oppdater eksisterende student med verdier fra den innsendte studenten
            existingStudent.setFirstName(student.getFirstName());
            existingStudent.setLastName(student.getLastName());
            existingStudent.setAddress(student.getAddress());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setPhoneNumber(student.getPhoneNumber());
            // Gjør dette for alle andre felter...
            return newStudentRepository.save(existingStudent);
        }
        // Håndter tilfellet hvor studenten ikke finnes...
        throw new StudentNotFoundException("Student not found with ID: " + newStudentId);


    }

    public Optional<NewStudent> getStudentById(Long newStudentId) {
        if (newStudentRepository.findById(newStudentId).isPresent()) {
            return newStudentRepository.findById(newStudentId);
        }
        throw new StudentNotFoundException("Student you are trying to find is not exist" + newStudentId);
    }
    public void deleteById(Long newStudentId){
        if(newStudentRepository.findById(newStudentId).isPresent()){
            newStudentRepository.deleteById(newStudentId);
            System.out.println("sucessfully deleted" + newStudentId);
        }
        throw new StudentNotFoundException("Student you are trying delete is not found" + newStudentId);
    }

}
