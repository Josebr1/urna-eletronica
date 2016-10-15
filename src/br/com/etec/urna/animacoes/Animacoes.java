/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.urna.animacoes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Victor
 */
public class Animacoes {

    public static int alpha = 255;
    public static int increment = -5;
    public static Timer animaLbl, animaTxt;

    public static void animation(JLabel label) {
        animaLbl = new Timer(50, (ActionEvent e) -> {
            alpha += increment;
            if (alpha >= 255) {
                alpha = 255;
                increment = -increment;
            }
            if (alpha <= 0) {
                alpha = 0;
                increment = -increment;
            }
            label.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, alpha)));
        });

        animaLbl.start();
    }

    public static void cancelAnimation(JLabel label) {
        label.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        animaLbl.stop();
    }

    public static void animationText(JLabel label) {
        animaTxt = new Timer(50, (ActionEvent e) -> {
            alpha += increment;
            if (alpha >= 255) {
                alpha = 255;
                increment = -increment;
            }
            if (alpha <= 0) {
                alpha = 0;
                increment = -increment;
            }
            label.setForeground(new Color(0, 0, 0, alpha));
        });

        animaTxt.start();
    }

    public static void cancelAnimationText(JLabel label) {
        label.setForeground(new Color(0, 0, 0));
        animaTxt.stop();
    }
}
