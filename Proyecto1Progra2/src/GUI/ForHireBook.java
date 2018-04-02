/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import domain.Book;
import domain.ForHire;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hansel
 */
public class ForHireBook extends javax.swing.JInternalFrame {
    
    Book objBook;	        // un Libro
    ForHire objArr;	// todos los Libros
    DefaultTableModel miModelo;
    String[] cabecera={"Nº","Codigo","Nombre de Libro","Tipo","Año"};
    String[][] data={};
    //variables globales
    int num = 0;
    /**
     * Creates new form ForHireBook
     */
    public ForHireBook() {
        initComponents();
        // Seteando el modelo de la tabla
        miModelo=new DefaultTableModel(data,cabecera);
        tblRegistros.setModel(miModelo);
        // objeto que administra la información de los Libros
	objArr = new ForHire();
        // proceso de carga de data del archivo al arreglo de objetos
	cargaData();
        //actualizando la tabla
        actualizar_tabla();
        //llamando al metodo resumen para mostrar los datos de salida
        resumen();
        //colocando el cursor en el text Codigo
        jtxtCodigo.requestFocus();
    }
    
    
    public void cargaData(){
	// lee la data del objeto serializado
	try {
	   FileInputStream fis = new FileInputStream("book.dat");
	   ObjectInputStream in = new ObjectInputStream(fis);
	   if (in != null){
		objArr = (ForHire)in.readObject();
		in.close();
	   }
	}catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error al cargar el archivo.."+ex);
	}// fin del catch
    }// fin de cargaData

    public void vaciar_tabla(){
    int filas=tblRegistros.getRowCount();
    for(int i=0;i<filas;i++)
    miModelo.removeRow(0); // removiendo la fila de la tabla
    }
    
    public void mensaje(String texto){
	JOptionPane.showMessageDialog(this,texto);
}// fin de mensaje
    
    public void actualizar_tabla()
{   vaciar_tabla();// Vaciandola informacion de la tabla
    //capturando el tamaño del arreglo
    int n=objArr.numeroLibros();
    for(int i=0;i<n;i++)
    {   // Se extrae la informacion de cada objeto del Arreglo
        String cod = objArr.getLibro(i).getCodBook();
        String nom = objArr.getLibro(i).getTittleBook();
        String an=objArr.getLibro(i).getAnnoPub();
        String ti=objArr.getLibro(i).getConditionBook();
        //Insertando la informacion en el Tabla
        insertar(i+1,cod,nom,ti,an);
    }
}
    
     void resumen()
 {  //Declaración de las variables para la extracción de datos
    String sA="",sB="",sD1="",sD2="";
    int mayor=-99,menor=999999,sC=0;
    double maycos=-99;
    int n=objArr.numeroLibros(); //Numero de Libros   
    for(int i=0;i<n;i++)
    {   // Se extrae la informacion de cada objeto del Arreglo
        String cod = objArr.getLibro(i).getCodBook();
        String nombre = objArr.getLibro(i).getTittleBook();
        String tipo =  objArr.getLibro(i).getConditionBook();
        String anio=objArr.getLibro(i).getAnnoPub();
        //calculando los datos de salida
       //Nombre del Libro con el Año de Edición más reciente
//           if(anio>mayor)
//            {  mayor=anio;
//               sA=nombre; }
       //Nombre de la Editorial que tiene el libro con el Menor número de páginas.
//            if(num_pag<menor)
//             {  menor=num_pag;
//                sB=tipo; }
       //Numero de Libros que supera el costo de S/ 100 que sean de la Editorial A
       //y sean de Gestión
//           if(costo>100 && tipo.equalsIgnoreCase("GESTION") && clase.equalsIgnoreCase("A"))
//               sC++;
//        //Nombre del Libro que tenga el mayor costo y a que editorial del pertenece.
//           if(costo>maycos)
//             {  maycos=costo;
//                sD1=nombre;
//                sD2=tipo; }
         }   
            //colocando la información en los TextField
//            jtxtsA.setText(sA);
//            jtxtsB.setText(sB);
//            jtxtsC.setText(String.valueOf(sC));
//            jtxtsD1.setText(sD1);
//            jtxtsD2.setText(sD2);      
 }
    
     
     public void eliminar(){
    // se llamada metodo consulta para ver los datos a borrar
    consulta();    
    //Se llama al metodo busca en el arreglo que devuelve la posicion
    // del codigo buscado
    int p = objArr.busca(jtxtCodigo.getText().toUpperCase());
    if (p!=-1)
    {
       int r = JOptionPane.showConfirmDialog(this, "Esta seguro de eliminar a éste registro ?"
                ,"Reponder",0);
       if (r==0)// si
       {   objArr.elimina(p); // eliminado el objeto en la posicion p
           limpiar_entradas();//Limpiando las entradas
           actualizar_tabla();//actualizando la tabla
           //llamando al metodo resumen para mostrar los datos de salida
           resumen();
          jtxtCodigo.requestFocus();//colocando el cursor en el text Codigo
       }
    }// fin del else

}// fin de elimina
     
     
      public void consulta(){
    String cod = jtxtCodigo.getText().toUpperCase();
    //Se llama al metodo busca en el arreglo que devuelve la posicion
    // del codigo buscado     	
    int p = objArr.busca(cod);
	if (p==-1)
        {  mensaje("Codigo no existe");
           limpiar_entradas();    }
	else{
		// se extrae todo el objeto con toda la informacion
                objBook= objArr.getLibro(p);
                // se extrae la informacion de los campos del objeto
//                String cod = objBook.getCodBook();
                String nombre = objBook.getTittleBook();
                String tipo =  objBook.getConditionBook();
                String anio=objBook.getAnnoPub();  
                //colocando la informacion en los objetos
                jtxtNombre.setText(nombre);
                //colocando la informacion en el combobox tipo
                            
                //colocando la informacion en el combobox clase
                           
                // Informacion para los text field y la portada del libro
                jtxtNombre.setText(nombre);
                jtxtAnio.setText(String.valueOf(anio));
                
	}
    }
      
      void limpiar_entradas() {
        jtxtCodigo.setText("");
        jtxtNombre.setText("");
        jtxtAnio.setText("");
        
        //deseleccionando los ComboBox
        
        jtxtCodigo.requestFocus(true);
    }
      
      void insertar(int num,String codigo,String nombre,String tipo, String anio)
    {
        String co;
        //dando Formato al sueldo
        DecimalFormat df2 = new DecimalFormat("####.00");
        
        Object[] fila={num,codigo,nombre,tipo,String.valueOf(anio)};
        miModelo.addRow(fila);
    }   
     
     
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtxtCodigo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtNombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtxtAnio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistros = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);

        jtxtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtCodigoKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Còdigo");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Nombre");

        jtxtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtNombreKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Año Ed.");

        jtxtAnio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtAnioKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("PRESTAMO DE LIBROS");

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminar.setText("Prestar");
        btnEliminar.setToolTipText("Elimina un registro en el Archivo Binario");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnConsultar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnConsultar.setText("Buscar");
        btnConsultar.setToolTipText("Busca la información del Arreglo");
        btnConsultar.setMaximumSize(new java.awt.Dimension(121, 59));
        btnConsultar.setMinimumSize(new java.awt.Dimension(21, 59));
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 255));
        jLabel5.setText("Lista de libros");

        tblRegistros.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tblRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblRegistros);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(240, 240, 240))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jtxtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addComponent(jtxtCodigo))
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtCodigoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtCodigoKeyPressed

    private void jtxtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtNombreKeyPressed
        
    }//GEN-LAST:event_jtxtNombreKeyPressed

    private void jtxtAnioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtAnioKeyPressed
        
    }//GEN-LAST:event_jtxtAnioKeyPressed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // Llamada al metodo que elimina un registro
        eliminar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // Llamada al metodo para hacer la consulta
        consulta();
    }//GEN-LAST:event_btnConsultarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtxtAnio;
    private javax.swing.JTextField jtxtCodigo;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JTable tblRegistros;
    // End of variables declaration//GEN-END:variables
}
