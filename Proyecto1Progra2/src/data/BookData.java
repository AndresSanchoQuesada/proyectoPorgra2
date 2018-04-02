/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.Book;
import domain.Student;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hansel
 */
public class BookData {
    
    private String path;

    public BookData() {
        this.path = "book.dat";
    }//const


    public void saveBook(Book book) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        List<Book> bookList = new ArrayList<Book>();

        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            bookList = (List<Book>) aux;
            objectInputStream.close();
        }

        bookList.add(book);
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(bookList);
        output.close();
        
    }

    public Book obtaineTittleBook(String titleBook) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);

        List<Book> bookList = new ArrayList<Book>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            bookList = (List<Book>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        Book book = null;
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getTittleBook().equals(titleBook)) {
                book = bookList.get(i);
                break;//rompe el for, aquí se pone porque sino retornaría null, porq asi fue inicializado antes
            }//if(studentList.get(i).getCodBook().equals(codBook))
        }//for i
        
        return book;
    }
    
    public boolean obtaineTittleBookBoolean(String codBook) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);

        List<Book> bookList = new ArrayList<Book>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            bookList = (List<Book>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        Book notebook = null;
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getCodBook().equals(codBook)) {
                notebook = bookList.get(i);
                return true;//rompe el for, aquí se pone porque sino retornaría null, porq asi fue inicializado antes
            }//if(studentList.get(i).getCodBook().equals(codBook))
        }//for i
        
        return false;
    }//obtenerPersona
   
    
    
    public boolean updateBook(Book book) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);

        List<Book> bookList = new ArrayList<Book>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            bookList = (List<Book>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        Book notebook = null;
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getCodBook().equals(book.getCodBook())) {
                notebook = bookList.get(i);
                bookList.set(i, book);
                //rompe el for, aquí se pone porque sino retornaría null, porq asi fue inicializado antes
            }//if(studentList.get(i).getCodBook().equals(codBook))
        }//for i

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(bookList);
        output.close();
        
        return true;
    }//obtenerPersona
    
    public List<Book> arrays() throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);

        List<Book> bookList = new ArrayList<Book>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            bookList = (List<Book>) aux;
            objectInputStream.close();
        }//if(myFile.exists()

        return bookList;
    }
}
