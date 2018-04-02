/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import business.audioVisualBusiness;
import domain.AudioVisual;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author andres
 */
public class RegAudioVisual extends JInternalFrame implements ActionListener {
    private JLabel  jlNameAuVi, jlCodeAuVi;
    private JTextField jtfCodeAV,jtfNameAV;
    private JButton jbtRegister;
    
    
   public RegAudioVisual(){
        super("Registrar AudioVisual");
        this.setClosable(true);
        this.setLayout(null);
        this.setSize(320,250);
        init();
        this.setVisible(true);
   }
   
   public void init(){
        this.jlCodeAuVi=new JLabel("Codigo");
        this.jtfCodeAV=new JTextField();
        this.jlNameAuVi=new JLabel("Articulo AV");
        this.jtfNameAV=new JTextField();
        this.jbtRegister=new JButton("Registrar");
        this.jbtRegister.addActionListener(this);
        
        this.jbtRegister.setBounds(90, 160, 123, 30);
        this.jlNameAuVi.setBounds(40,10,140,33);
        this.jtfNameAV.setBounds(110,15,140,30);
        
        this.jlCodeAuVi.setBounds(42, 60, 140, 33);
        this.jtfCodeAV.setBounds(110, 65, 140, 30);
        
        
        this.add(jlNameAuVi);
        this.add(jtfCodeAV);
        this.add(jlCodeAuVi);
        this.add(jtfNameAV);     
        this.add(jlCodeAuVi);
        this.add(jbtRegister);
       
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jbtRegister){
            try {
                audioVisualBusiness audioVisualBusiness = new audioVisualBusiness();
                if (!audioVisualBusiness.obtaineAudioVisualNameBoolean(jtfCodeAV.getText())) {
                    AudioVisual audioVisual = new AudioVisual(jtfNameAV.getText(), jtfCodeAV.getText());
                    audioVisualBusiness.saveAudioVisual(audioVisual);
                    JOptionPane.showMessageDialog(this, "Se registró con exito");
                    this.jtfNameAV.setText(null);
                    this.jtfCodeAV.setText(null);
                } else {
                    JOptionPane.showMessageDialog(this, "AudioVisual Registrado");
                    this.jtfNameAV.setText(null);
                    this.jtfCodeAV.setText(null);                }
            } catch (IOException ex) {
                Logger.getLogger(RegStudent.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RegStudent.class.getName()).log(Level.SEVERE, null, ex);
            }


    
        }
    }
    
    
}
