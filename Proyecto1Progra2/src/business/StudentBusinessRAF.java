/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.StudentDataRAF;
import domain.Student;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author hansel
 */
public class StudentBusinessRAF {
    private StudentDataRAF studentDataRAF;
    private ArrayList<Student>StudentsReg;
    
    public StudentBusinessRAF() throws IOException{
        this.studentDataRAF=new StudentDataRAF();
    }//constructor
    
    public boolean saveStudent(Student studentRAF) throws IOException{
        if(this.studentDataRAF.checkStudentNameUnavailability(studentRAF.getNameStudent()))    
            return this.studentDataRAF.saveStudentAgain( studentRAF);
        else
            return false;
    }//public boolean guardarJugador(Jugador jugador)
    
    public void actualizarArchivo(Student studentRAF){
        try{
            this.studentDataRAF.updateArchive(studentRAF);
        }catch (IOException ex) {
            Logger.getLogger(StudentBusinessRAF.class.getName()).log(Level.SEVERE, null, ex);
        }//try - catch
    }//public void actualizarArchivo(Jugador jugador)
}
