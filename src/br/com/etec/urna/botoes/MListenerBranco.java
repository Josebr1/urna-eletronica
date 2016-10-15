/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.urna.botoes;

import br.com.etec.urna.animacoes.Animacoes;
import static br.com.etec.urna.animacoes.Animacoes.cancelAnimation;
import static br.com.etec.urna.layout.Layout.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;

/**
 *
 * @author Victor
 */
public class MListenerBranco implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent me
    ) {

    }

    @Override

    public void mousePressed(MouseEvent me
    ) {
        branco = new ImageIcon(getClass().getResource(caminhoRecursos + "branco_down.jpg"));
        lblBranco.setIcon(branco);
    }

    @Override
    public void mouseReleased(MouseEvent me
    ) {
        acaoBranco();
    }

    @Override
    public void mouseEntered(MouseEvent me
    ) {
    }

    @Override
    public void mouseExited(MouseEvent me
    ) {
    }

    public void acaoBranco() {
        branco = new ImageIcon(getClass().getResource(caminhoRecursos + "branco.jpg"));
        lblBranco.setIcon(branco);
        if (!lblFim.isVisible()) {
            desabilitado = false;
        }

        brancoDesabilitado = !lblNum1.getText().isEmpty();

        if (!desabilitado) {
            if (!brancoDesabilitado) {
                lblVotoBranco.setVisible(true);
                Animacoes.animationText(lblVotoBranco);
                brancoPressionado = true;
                lblNum1.setVisible(false);
                lblNum2.setVisible(false);
                lblNum3.setVisible(false);
                lblNum4.setVisible(false);
                lblNum5.setVisible(false);
                cancelAnimation(lblNum1);
                cancelAnimation(lblNum2);
                cancelAnimation(lblNum3);
                cancelAnimation(lblNum4);
                cancelAnimation(lblNum5);
                lblNumero.setVisible(false);
                lblNumeroErrado.setVisible(false);
                lblInstrucoes1.setVisible(true);
                lblInstrucoes2.setVisible(true);
                lblInstrucoes3.setVisible(true);
                lblLinha.setVisible(true);
                lblInfo.setVisible(true);
                lblNome.setVisible(false);
                lblNomeCandidato.setVisible(false);
                lblPartido.setVisible(false);
                lblNomePartido.setVisible(false);
                lblLegendaPeq.setVisible(false);
                lblLegendaGrande.setVisible(false);
                lblNulo.setVisible(false);
            }
        }
    }
}
