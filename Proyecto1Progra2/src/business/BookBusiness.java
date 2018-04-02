/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.BookData;
import domain.Book;
import domain.Student;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author hansel
 */
public class BookBusiness {
    BookData bookData;

    public BookBusiness() {
        this.bookData=new BookData();
    }
    
    public void SaveBook(Book book) throws IOException, ClassNotFoundException {
        this.bookData.saveBook(book);
    }
    
    public Book obtaineTittleBook(String tittleBook) throws IOException, ClassNotFoundException {
        return this.bookData.obtaineTittleBook(tittleBook);
    }
    public boolean updateStudent(Book book) throws IOException, ClassNotFoundException {
        return this.bookData.updateBook(book);
    }
    
    public boolean obtaineTittleBookBoolean(String codBook) throws IOException, ClassNotFoundException {
        return this.bookData.obtaineTittleBookBoolean(codBook);
    }
    
    public List<Book> arrays() throws IOException, ClassNotFoundException {
        return this.bookData.arrays();
    }
}
