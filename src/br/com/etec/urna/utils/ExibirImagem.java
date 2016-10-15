/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.urna.utils;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ExibirImagem {

    public ExibirImagem(byte[] minhaimagem, JLabel label, String cargo) {

        if (minhaimagem != null) {
            InputStream input = new ByteArrayInputStream(minhaimagem);
            try {

                BufferedImage imagem = ImageIO.read(input);
                imagem = resize(imagem, cargo);
                label.setIcon(new ImageIcon(imagem));
            } catch (IOException ex) {
            }
        } else {
            BufferedImage imagem = null;
            try {
                imagem = ImageIO.read(getClass().getResource("semimagem.jpg"));

                imagem = resize(imagem, cargo);
            } catch (IOException ex) {
            }
            label.setIcon(new ImageIcon(imagem));
        }
    }

    private BufferedImage setImagemDimensao(BufferedImage imagem, int newWidth, int newHeight) {
        Graphics2D g2d;
        BufferedImage novaImagem;

        novaImagem = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        g2d = novaImagem.createGraphics();
        g2d.drawImage(imagem, 0, 0, newWidth, newHeight, null);

        return novaImagem;
    }

    private BufferedImage resize(BufferedImage imagem, String cargo) {
        if (!cargo.equalsIgnoreCase("vice")) {
            imagem = setImagemDimensao(imagem, 120, 165);
        } else {
            imagem = setImagemDimensao(imagem, 95, 140);
        }

        return imagem;
    }
}
