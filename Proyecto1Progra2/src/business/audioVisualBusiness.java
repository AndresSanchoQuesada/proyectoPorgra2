/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.AudioVisualData;
import data.BookData;
import domain.AudioVisual;
import domain.Book;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author andres
 */
public class audioVisualBusiness {
    AudioVisualData audioVisualData;

    public audioVisualBusiness() {
        this.audioVisualData=new AudioVisualData();
    }
    
    public void saveAudioVisual(AudioVisual audioVisual) throws IOException, ClassNotFoundException {
        this.audioVisualData.saveAudiovisual(audioVisual);
    }
    
    public AudioVisual obtaineAudioVisual(String nameAv) throws IOException, ClassNotFoundException {
        return this.audioVisualData.obtaineNameAudioVisual(nameAv);
    }
    public boolean updateAudioVisual(AudioVisual audioVisual) throws IOException, ClassNotFoundException {
        return this.audioVisualData.updateAudioVisual(audioVisual);
    }
    
    public boolean obtaineAudioVisualNameBoolean(String codeAv) throws IOException, ClassNotFoundException {
        return this.audioVisualData.obtaineAudioVisualNameBoolean(codeAv);
    }
    
    public List<AudioVisual> arrays() throws IOException, ClassNotFoundException {
        return this.audioVisualData.arrays();
    }
}
