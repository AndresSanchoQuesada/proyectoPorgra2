/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author hansel
 */
public class Book implements Serializable{
    private String tittleBook;
    private String codBook;
    private String conditionBook;
    private String annoPub;

    public Book() {
    }

    public Book(String tittleBook, String codBook, String annoPub, String conditionBook) {
        this.tittleBook = tittleBook;
        this.codBook = codBook;
        this.conditionBook = conditionBook;
        this.annoPub= annoPub;
    }

    public String getTittleBook() {
        return tittleBook;
    }

    public void setTittleBook(String tittleBook) {
        this.tittleBook = tittleBook;
    }

    public String getCodBook() {
        return codBook;
    }

    public void setCodBook(String codBook) {
        this.codBook = codBook;
    }

    public String getConditionBook() {
        return conditionBook;
    }

    public void setConditionBook(String conditionBook) {
        this.conditionBook = conditionBook;
    }

    public String getAnnoPub() {
        return annoPub;
    }

    public void setAnnoPub(String annoPub) {
        this.annoPub = annoPub;
    }

    @Override
    public String toString() {
        return "Book{" + "tittleBook=" + tittleBook + ", codBook=" + codBook + ", conditionBook=" + conditionBook + ", annoPub=" + annoPub + '}';
    }
}
