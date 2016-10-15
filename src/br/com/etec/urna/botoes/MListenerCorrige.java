/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.urna.botoes;

import static br.com.etec.urna.animacoes.Animacoes.animation;
import static br.com.etec.urna.animacoes.Animacoes.animationText;
import static br.com.etec.urna.animacoes.Animacoes.cancelAnimation;
import static br.com.etec.urna.animacoes.Animacoes.cancelAnimationText;
import static br.com.etec.urna.layout.Layout.brancoPressionado;
import static br.com.etec.urna.layout.Layout.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;

/**
 *
 * @author Victor
 */
public class MListenerCorrige implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent me
    ) {

    }

    @Override
    public void mousePressed(MouseEvent me
    ) {
        corrige = new ImageIcon(getClass().getResource(caminhoRecursos + "corrige_down.jpg"));
        lblCorrige.setIcon(corrige);
    }

    @Override
    public void mouseReleased(MouseEvent me
    ) {
        acaoCorrige();
    }

    @Override
    public void mouseEntered(MouseEvent me
    ) {
    }

    @Override
    public void mouseExited(MouseEvent me
    ) {
    }

    private void cancelar() {
        cancelAnimation(lblNum2);
        cancelAnimation(lblNum3);
        cancelAnimation(lblNum4);
        cancelAnimation(lblNum5);
        animationText(lblLegendaPeq);
        cancelAnimationText(lblLegendaPeq);
        cancelAnimationText(lblLegendaGrande);
        cancelAnimationText(lblNulo);
        cancelAnimationText(lblVotoBranco);
    }

    private void limpar() {
        lblNum1.setText("");
        lblNum2.setText("");
        lblNum3.setText("");
        lblNum4.setText("");
        lblNum5.setText("");
    }

    public void acaoCorrige() {
        corrige = new ImageIcon(getClass().getResource(caminhoRecursos + "corrige.jpg"));
        lblCorrige.setIcon(corrige);
        brancoPressionado = false;

        if (!lblFim.isVisible()) {
            desabilitado = false;
        }

        if (!desabilitado) {
            limpar();
            cancelar();
            animation(lblNum1);
            if (lblCargo.getText().equalsIgnoreCase("prefeito")) {
                lblNum1.setVisible(true);
                lblNum2.setVisible(true);
                lblNum3.setVisible(false);
                lblNum4.setVisible(false);
                lblNum5.setVisible(false);
            } else {
                lblNum1.setVisible(true);
                lblNum2.setVisible(true);
                lblNum3.setVisible(true);
                lblNum4.setVisible(true);
                lblNum5.setVisible(true);
            }

            lblInfo.setVisible(false);
            lblNumero.setVisible(false);
            lblNumeroErrado.setVisible(false);
            lblInstrucoes1.setVisible(false);
            lblInstrucoes2.setVisible(false);
            lblInstrucoes3.setVisible(false);
            lblLinha.setVisible(false);
            lblNome.setVisible(false);
            lblNomeCandidato.setVisible(false);
            lblPartido.setVisible(false);
            lblNomePartido.setVisible(false);
            lblLegendaPeq.setVisible(false);
            lblLegendaGrande.setVisible(false);
            lblNulo.setVisible(false);
            lblVotoBranco.setVisible(false);
            lblImgPrefeito.setVisible(false);
            lblImgVice.setVisible(false);
            lblImgCandidato.setVisible(false);
            lblCandidatoInexistente.setVisible(false);
        }
    }
}
