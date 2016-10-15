/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.urna.botoes;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Victor
 */
public class MListener implements MouseListener {

    String texto;
    ImageIcon down;
    ImageIcon up;
    JLabel label;

    public MListener(JLabel label, String texto, ImageIcon down, ImageIcon up) {
        this.label = label;
        this.texto = texto;
        this.down = down;
        this.up = up;
    }

    @Override
    public void mouseClicked(MouseEvent me
    ) {

    }

    @Override
    public void mousePressed(MouseEvent me
    ) {
        label.setIcon(down);
    }

    @Override
    public void mouseReleased(MouseEvent me
    ) {
        label.setIcon(up);
        new GenericSteps(texto);
    }

    @Override
    public void mouseEntered(MouseEvent me
    ) {
    }

    @Override
    public void mouseExited(MouseEvent me
    ) {
    }
}
