/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.AudioVisual;
import domain.AudioVisual;
import domain.Book;
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
 * @author andres
 */
public class AudioVisualData {
    private String path;

    public AudioVisualData() {
        this.path = "audiovisual.dat";
    }//const


    public void saveAudiovisual(AudioVisual audioVisual) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);
        List<AudioVisual> audioVisualList = new ArrayList<AudioVisual>();

        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            audioVisualList = (List<AudioVisual>) aux;
            objectInputStream.close();
        }

        audioVisualList.add(audioVisual);
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(audioVisualList);
        output.close();
        
    }

    public AudioVisual obtaineNameAudioVisual(String nameAv) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);

        List<AudioVisual> audioVisualList = new ArrayList<AudioVisual>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            audioVisualList = (List<AudioVisual>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        AudioVisual audioVisual = null;
        for (int i = 0; i < audioVisualList.size(); i++) {
            if (audioVisualList.get(i).getNameAv().equals(nameAv)) {
                audioVisual = audioVisualList.get(i);
                break;//rompe el for, aquí se pone porque sino retornaría null, porq asi fue inicializado antes
            }//if(studentList.get(i).getCodBook().equals(codBook))
        }//for i
        
        return audioVisual;
    }
    
    public boolean obtaineAudioVisualNameBoolean(String codeAv) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);

        List<AudioVisual> audioVisualList = new ArrayList<AudioVisual>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            audioVisualList = (List<AudioVisual>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        AudioVisual typeX = null;
        for (int i = 0; i < audioVisualList.size(); i++) {
            if (audioVisualList.get(i).getCodAv().equals(codeAv)) {
                typeX = audioVisualList.get(i);
                return true;//rompe el for, aquí se pone porque sino retornaría null, porq asi fue inicializado antes
            }//if(studentList.get(i).getCodBook().equals(codBook))
        }//for i
        
        return false;
    }//obtenerPersona
   
    
    
    public boolean updateAudioVisual(AudioVisual audioVisual) throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);

        List<AudioVisual> audioVisualList = new ArrayList<AudioVisual>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            audioVisualList = (List<AudioVisual>) aux;
            objectInputStream.close();
        }//if(myFile.exists())

        AudioVisual typeX = null;
        for (int i = 0; i < audioVisualList.size(); i++) {
            if (audioVisualList.get(i).getCodAv().equals(audioVisual.getCodAv())) {
                typeX = audioVisualList.get(i);
                audioVisualList.set(i, audioVisual);
                //rompe el for, aquí se pone porque sino retornaría null, porq asi fue inicializado antes
            }//if(studentList.get(i).getCodBook().equals(codBook))
        }//for i

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
        output.writeUnshared(audioVisualList);
        output.close();
        
        return true;
    }//obtenerPersona
    
    public List<AudioVisual> arrays() throws IOException, ClassNotFoundException {
        File myFile = new File(this.path);

        List<AudioVisual> audioVisualList = new ArrayList<AudioVisual>();
        if (myFile.exists()) {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(myFile));
            Object aux = objectInputStream.readObject();
            audioVisualList = (List<AudioVisual>) aux;
            objectInputStream.close();
        }//if(myFile.exists()

        return audioVisualList;
    }
}
