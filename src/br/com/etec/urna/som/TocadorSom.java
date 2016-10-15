/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.urna.som;

/**
 *
 * @author Victor
 */
import br.com.etec.urna.layout.Layout;
import static br.com.etec.urna.layout.Layout.lblFim;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class TocadorSom implements Runnable {

    URL url;

    public TocadorSom(String arquivo) {
       url = getClass().getResource(arquivo);         
    }

    @Override
    public void run() {
        //Cria uma instancia da classe player passando para ele o InpuStream do arquivo
        try {
            Clip oClip = AudioSystem.getClip();
            AudioInputStream oStream = AudioSystem.getAudioInputStream(url);
            oClip.open(oStream);
            oClip.loop(0);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
        }
        if(!Layout.lblCargo.getText().equalsIgnoreCase("prefeito")){
            lblFim.setVisible(true);
        }
        

    }
}
