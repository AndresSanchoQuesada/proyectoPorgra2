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
public class AudioVisual implements Serializable{
    private String nameAv;
    private String codAv;

    public AudioVisual() {
    }

    public AudioVisual(String nameAv, String codAv) {
        this.nameAv = nameAv;
        this.codAv = codAv;
    }

    public String getNameAv() {
        return nameAv;
    }

    public void setNameAv(String nameAv) {
        this.nameAv = nameAv;
    }

    public String getCodAv() {
        return codAv;
    }

    public void setCodAv(String codAv) {
        this.codAv = codAv;
    }

    @Override
    public String toString() {
        return "AudioVisual{" + "nameAv=" + nameAv + ", codAv=" + codAv + '}';
    }
        
        
}
