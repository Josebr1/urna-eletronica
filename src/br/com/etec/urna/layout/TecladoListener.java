/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.urna.layout;

import br.com.etec.urna.botoes.*;
import java.awt.event.*;
import javax.swing.JTextField;

/**
 *
 * @author Victor
 */
public class TecladoListener implements KeyListener {

    private String txtNumero;
    JTextField tf;

    public TecladoListener(JTextField tf) {
        this.tf = tf;
    }

    @Override
    public void keyTyped(KeyEvent ke) {

        tf.setText("");
        if (Character.isDigit(ke.getKeyChar())) {
            txtNumero = " " + ke.getKeyChar();            
            new GenericSteps(txtNumero);
        }
    }

    @Override
    public void keyPressed(KeyEvent ke
    ) {

    }

    @Override
    public void keyReleased(KeyEvent ke
    ) {
        tf.setText("");
        if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
            new MListenerConfirmar().acaoConfirmar();
        } else if (ke.getKeyChar() == '*') {
            new MListenerCorrige().acaoCorrige();
        } else if(ke.getKeyChar() == '/') {
            new MListenerBranco().acaoBranco();
        }else if((ke.getKeyChar() == '-') ||(ke.getKeyChar() == '+') ||(ke.getKeyChar() == '.')) {
            new MListenerConfirmar().acaoConfirmar();
        }
    }
}
