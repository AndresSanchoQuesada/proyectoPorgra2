/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class LogIn extends JInternalFrame implements ActionListener{
    private JLabel jlblNameStudent,jlblCarne;
    private JTextField txtNameStudent,txtCarne;
    private JButton btnEntrar;
    
    public LogIn(){
        super("Ingresar");
        this.setClosable(true);
        this.setLayout(null);
        this.setSize(300,200);
        init();
        this.setVisible(true);
    }//constructor
    
    public void init(){
        this.jlblNameStudent=new JLabel("Nombre");
        this.txtNameStudent=new JTextField();
        this.jlblCarne=new JLabel("Contraseña");
        this.txtCarne=new JTextField();
        this.btnEntrar=new JButton("Entrar");
        this.btnEntrar.addActionListener(this);
        
        this.btnEntrar.setBounds(90, 100, 100, 40);
        this.jlblNameStudent.setBounds(40,10,100,30);
        this.txtNameStudent.setBounds(130,15,110,30);
        
        this.jlblCarne.setBounds(40, 50, 100, 30);
        this.txtCarne.setBounds(130,55,110,30);
        
        this.add(this.jlblNameStudent);
        this.add(this.btnEntrar);
        this.add(this.jlblCarne);
        this.add(this.txtCarne);
        this.add(this.txtNameStudent);    
    }//public void init()

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnEntrar){
            JOptionPane.showMessageDialog(this, "ha iniciado secion con exito");
            this.txtCarne.setText(null);
            this.txtNameStudent.setText(null);
        }
    }
}//fin clase Entrar
