/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import Business.StudentBusiness;
import business.StudentBusinessRAF;
import java.awt.event.ActionEvent;
import domain.Student;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author hansel
 */
public class RegStudent extends JInternalFrame implements ActionListener{
    private JLabel jlblIdStudent,jlblNameStudent, jlblCareerStudent;
    private JTextField txtIdStudent,txtNameStudent, txtcareerStudent;
    private JButton btnRegister;
    private StudentBusinessRAF studentBusinessRAF;
    
    public RegStudent(){
        super("Registrar Estudiantes");
        this.setClosable(true);
        this.setLayout(null);
        this.setSize(320,250);
        init();
        this.setVisible(true);
        
        try {
            this.studentBusinessRAF=new StudentBusinessRAF();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al guardar en el archivo");
        }//try - catch
    }//constructor
    
    public void init(){
        this.jlblIdStudent=new JLabel("Carné");
        this.txtIdStudent=new JTextField();
        this.jlblNameStudent=new JLabel("Nombre");
        this.txtNameStudent=new JTextField();
        this.jlblCareerStudent=new JLabel("Carrera");
        this.txtcareerStudent=new JTextField();
        this.btnRegister=new JButton("Registrar");
        this.btnRegister.addActionListener(this);
        
        this.btnRegister.setBounds(90, 160, 123, 30);
        this.jlblIdStudent.setBounds(40,10,140,30);
        this.txtIdStudent.setBounds(110,15,140,25);
        
        this.jlblNameStudent.setBounds(40, 50, 140, 30);
        this.txtNameStudent.setBounds(110,55,140,25);
        
        this.jlblCareerStudent.setBounds(40, 90, 140, 30);
        this.txtcareerStudent.setBounds(110,95,140,25);
        
        this.add(this.jlblIdStudent);
        this.add(this.btnRegister);
        this.add(this.jlblCareerStudent);
        this.add(this.txtcareerStudent);
        this.add(this.txtIdStudent); 
        this.add(this.jlblNameStudent);
        this.add(this.txtNameStudent);
    }//public void init()

    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            if(studentBusinessRAF.saveStudent(new Student(this.txtNameStudent.getText(),this.txtIdStudent.getText(),this.txtcareerStudent.getText()))){
                JOptionPane.showMessageDialog(this, "Se registró con exito");
                this.txtIdStudent.setText(null);
                this.txtNameStudent.setText(null);
                this.txtcareerStudent.setText(null);
            }else{
                JOptionPane.showMessageDialog(this, "El carne ya está registrado");
                this.txtIdStudent.setText(null);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al registrar al estudiante");
            this.txtIdStudent.setText(null);
            this.txtNameStudent.setText(null);
            this.txtcareerStudent.setText(null);
        }//try - catch
    }//if(e.getSource()==btnRegistrar)
}//fin clase Entrar
