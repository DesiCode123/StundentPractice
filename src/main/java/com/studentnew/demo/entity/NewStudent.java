package com.studentnew.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "new_student")
public class NewStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long newStudentId;

    @NotEmpty(message = "First name cannot be null")
    @Size(min = 2, max = 30,message = "Firstname must be between 2 and 30 characters")
    private String firstName;
    private String lastName;

    @Email(message = "Email should be valid")
    private String email;
    @NotNull(message = "phoneNumber can not be null")
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Adress address;

    public Adress getAddress() {
        return address;
    }

    public void setAddress(Adress address) {
        this.address = address;
    }


    public Long getNewStudentId() {
        return newStudentId;
    }

    public void setNewStudentId(Long newStudentId) {
        this.newStudentId = newStudentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public NewStudent(Long newStudentId, String firstName, String lastName, String email, String phoneNumber, Adress address) {
        this.newStudentId = newStudentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    public NewStudent(){

    }
}
