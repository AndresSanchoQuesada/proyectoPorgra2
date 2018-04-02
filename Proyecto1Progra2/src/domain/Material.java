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
public class Material implements Serializable{
    private String nameMaterial;
    private String codMaterial;
    private boolean available;

    public Material() {
    }

    public Material(String nameMaterial, String codMaterial, boolean available) {
        this.nameMaterial = nameMaterial;
        this.codMaterial = codMaterial;
        this.available = available;
    }

    public String getNameMaterial() {
        return nameMaterial;
    }

    public void setNameMaterial(String nameMaterial) {
        this.nameMaterial = nameMaterial;
    }

    public String getCodMaterial() {
        return codMaterial;
    }

    public void setCodMaterial(String codMaterial) {
        this.codMaterial = codMaterial;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Material{" + "nameMaterial=" + nameMaterial + ", codMaterial=" + codMaterial + ", available=" + available + '}';
    }
    
    
}
