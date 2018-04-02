/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import business.BookBusiness;
import domain.Book;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author hansel
 */
public class RegBook extends JInternalFrame implements ActionListener{
    private JLabel jlblTittleBoook,jlblCodBook, jlblConditionBook, jlblAnnoPub;
    private JTextField txtTittleBook,txtCodBook, txtAnnoPub, txtCondition;
    private JButton btnRegistrar;
    
    public RegBook(){
        super("Registrar libros");
        this.setClosable(true);
        this.setLayout(null);
        this.setSize(320,320);
        init();
        this.setVisible(true);
    }//constructor
    
    public void init(){
        this.jlblTittleBoook=new JLabel("Titulo");
        this.txtTittleBook=new JTextField();
        this.jlblCodBook=new JLabel("Código");
        this.txtCodBook=new JTextField();
        this.jlblAnnoPub=new JLabel("Año");
        this.txtAnnoPub=new JTextField();
        this.btnRegistrar=new JButton("Registrar");
        this.btnRegistrar.addActionListener(this);
        this.jlblConditionBook= new JLabel("Tipo");
        this.txtCondition= new JTextField();
        
        this.btnRegistrar.setBounds(90, 240, 123, 30);
        
        this.jlblTittleBoook.setBounds(40,30,140,30);
        this.txtTittleBook.setBounds(110,35,140,25);
        
        this.jlblCodBook.setBounds(40, 75, 140, 30);
        this.txtCodBook.setBounds(110,80,140,25);
        
        this.jlblConditionBook.setBounds(40,130,140,30);
        this.txtCondition.setBounds(110, 130, 140, 30);
        
        this.jlblAnnoPub.setBounds(40, 175, 140, 30);
        this.txtAnnoPub.setBounds(110,180,140,25);
        
        this.add(this.jlblTittleBoook);
        this.add(this.btnRegistrar);
        this.add(this.txtTittleBook); 
        this.add(this.jlblCodBook);
        this.add(this.txtCodBook);
        this.add(this.jlblConditionBook);
        this.add(this.txtCondition);
        this.add(this.jlblAnnoPub);
        this.add(this.txtAnnoPub);
    }//public void init()

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnRegistrar){
            try {
                BookBusiness bookBusiness = new BookBusiness();
                if (!bookBusiness.obtaineTittleBookBoolean(txtCodBook.getText())) {
                    Book book = new Book(txtTittleBook.getText(), txtCodBook.getText(), txtCondition.getText(), txtAnnoPub.getText());
                    bookBusiness.SaveBook(book);
                    JOptionPane.showMessageDialog(this, "Se registró con exito");
                    this.txtTittleBook.setText(null);
                    this.txtCodBook.setText(null);
                    this.txtAnnoPub.setText(null);
                } else {
                    JOptionPane.showMessageDialog(this, "Libro registrado");
                    this.txtTittleBook.setText(null);
                    this.txtCodBook.setText(null);
                    this.txtAnnoPub.setText(null);
                }
            } catch (IOException ex) {
                Logger.getLogger(RegStudent.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RegStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
