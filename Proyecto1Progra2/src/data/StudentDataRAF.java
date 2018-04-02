/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.Student;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.JOptionPane;

/**
 *
 * @author hansel
 */
public class StudentDataRAF {
    private RandomAccessFile archive;
    private String myFilePath;
    private int regSize;
    private int regQuantity;
    
    public StudentDataRAF() throws IOException{
        this.myFilePath="students.dad";
        File file=new File(this.myFilePath);
        start(file);
    }//constructor
    
    private void start(File file) throws IOException{
        this.myFilePath=file.getPath();
        this.regSize=150;
        if(file.exists() && !file.isFile()){
            throw new IOException(file.getName() + " archivo invalido");
        }else{
            this.archive=new RandomAccessFile(file, "rw");
            this.regQuantity=(int)Math.ceil((double)this.archive.length()/(double)this.regSize);
        } //if(file.exists() && !file.isFile()) - //else
    } //private void creacionArchivo(File file)
    
    public boolean saveStudent(int position,Student studentRAF) throws IOException{
        if(position>=0 && position<=regQuantity){
            if(studentRAF.elTamaño()>this.regSize){
                return false;
            }else{
                this.archive.seek(position*this.regSize);
                this.archive.writeUTF(studentRAF.getIdStudent());
                this.archive.writeUTF(studentRAF.getNameStudent());
                this.archive.writeUTF(studentRAF.getCareerStudent());
                this.regQuantity++;
                return true;
            } // if(persona.size()>this.tamRegistro) - //else
        } // if(posicion>=0 && posicion<=cantRegis)
        return false;
    }//public boolean guardarJugador(int posicion,Jugador jugador)
    
    public boolean saveStudentAgain(Student studentRAF) throws IOException{
        return saveStudent(this.regQuantity, studentRAF);
    } //public boolean guardarJugador(Jugador jugador)
    
    public boolean checkStudentNameUnavailability(String nameStudent) throws IOException{
        for(int i=0;i<this.regQuantity;i++){
            Student aux=this.obtaineStudent(i);
            if(aux!=null){
                if(aux.getNameStudent().equalsIgnoreCase(nameStudent)){
                    return false;
                }//if(aux.getNombre().equalsIgnoreCase(nombre))
            }//if(aux!=null)
        }//for(int i=0;i<this.cantRegis;i++)
        return true;
    }//public boolean verificaDisponibilidadNombreJugador(String nombre)

    public Student obtaineStudent(int position) throws IOException{
        if(position>=0 && position<=regQuantity){
            this.archive.seek(position*regSize);
            Student studentRAF=new Student();
            studentRAF.setIdStudent(this.archive.readUTF());
            studentRAF.setNameStudent(this.archive.readUTF());
            studentRAF.setCareerStudent(this.archive.readUTF());
            return studentRAF;
        }// if(posicion>=0 && posicion<=cantRegis)
        return null;
    }//public Jugador obtenerJugador(int posicion)
    
    public void updateArchive(Student studentRAF) throws IOException{
        int i=0;
        for(i=i;i<this.regQuantity;i++){
            this.archive.seek(i*this.regSize);
            if(studentRAF.getNameStudent().equalsIgnoreCase(this.archive.readUTF())){
                   break;
            }//if(jugador.getNombre().equalsIgnoreCase(this.archivo.readUTF()))
        }//for(i=i;i<this.cantRegis;i++)
        this.archive.seek(i*this.regSize);
        this.archive.writeUTF(studentRAF.getIdStudent());
        this.archive.writeUTF(studentRAF.getNameStudent());
        this.archive.writeUTF(studentRAF.getCareerStudent());
        JOptionPane.showMessageDialog(null, "SE registró");
    }//public void actualizarArchivo(Jugador jugador)
}
