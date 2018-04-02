/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author hanse
 */
public class Student implements Serializable{
    private String idStudent;
    private String nameStudent;
    private String careerStudent;
    private int posicion;

    public Student() {
    }

    public Student(String idStudent, String nameStudent, String careerStudent) {
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
        this.careerStudent = careerStudent;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getCareerStudent() {
        return careerStudent;
    }

    public void setCareerStudent(String careerStudent) {
        this.careerStudent = careerStudent;
    }

    @Override
    public String toString() {
        return "Student{" + "idStudent=" + idStudent + ", nameStudent=" + nameStudent + ", careerStudent=" + careerStudent + '}';
    }
    
    public int elTamaño(){
        return this.idStudent.length()*2 + this.nameStudent.length()*2+this.careerStudent.length()*2;
    }//public int elTamaño()

        
}
