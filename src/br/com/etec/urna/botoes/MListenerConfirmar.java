/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.urna.botoes;

import br.com.etec.urna.animacoes.Animacoes;
import static br.com.etec.urna.animacoes.Animacoes.animation;
import static br.com.etec.urna.animacoes.Animacoes.cancelAnimation;
import static br.com.etec.urna.animacoes.Animacoes.cancelAnimationText;
import br.com.etec.urna.dao.UrnaDao;
import static br.com.etec.urna.layout.Layout.*;
import br.com.etec.urna.som.TocadorSom;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Victor
 */
public class MListenerConfirmar implements MouseListener {

    int numero;

    @Override
    public void mouseClicked(MouseEvent me
    ) {

    }

    @Override
    public void mousePressed(MouseEvent me
    ) {
    }

    @Override
    public void mouseReleased(MouseEvent me
    ) {
        acaoConfirmar();
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
        Animacoes.animationText(lblLegendaPeq);
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

    private void restart() {
        if (cargo.equalsIgnoreCase("vereador")) {

            TocadorSom tocador = new TocadorSom("inter.wav");
            Thread t = new Thread(tocador);
            t.start();

            lblCargo.setText("Prefeito");

            lblNum1.setVisible(true);
            lblNum2.setVisible(true);
            lblNum3.setVisible(false);
            lblNum4.setVisible(false);
            lblNum5.setVisible(false);
        } else {
            TocadorSom tocador = new TocadorSom("fim.wav");
            Thread t = new Thread(tocador);
            t.start();

            lblFim.setVisible(true);
            lblCargo.setVisible(false);
            lblNum1.setVisible(false);
            lblNum2.setVisible(false);
            lblNum3.setVisible(false);
            lblNum4.setVisible(false);
            lblNum5.setVisible(false);
            Timer timer;
            timer = new Timer(2000, (ActionEvent e) -> {
                lblFim.setVisible(false);
                lblCargo.setVisible(true);
                lblNum1.setVisible(true);
                lblNum2.setVisible(true);
                lblNum3.setVisible(true);
                lblNum4.setVisible(true);
                lblNum5.setVisible(true);
            });
            timer.setRepeats(false);
            timer.start();
            

            lblCargo.setText("Vereador");
            desabilitado = true;
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

    private boolean computarVoto() {
        if (lblNulo.isVisible()) {
            return votoNulo();
        } else if (lblVotoBranco.isVisible()) {
            return votoBranco();
        } else if (cargo.equalsIgnoreCase("prefeito")) {
            try {
                numero = new InformacoesCandidatos().numero2Digitos();
            } catch (NumberFormatException nfe) {
                return votoNulo();
            }

            try {
                if (!(String.valueOf(numero).length() < 2)) {
                    new UrnaDao().updateVotosPrefeito(numero);
                } else {
                    return votoNulo();
                }
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
                return false;
            }
        } else if (cargo.equalsIgnoreCase("vereador")) {
            if (lblLegendaGrande.isVisible() || lblLegendaPeq.isVisible()) {
                votoLegenda();
            } else {
                try {
                    numero = new InformacoesCandidatos().numero5Digitos();
                } catch (NumberFormatException nfe) {
                    return votoNulo();
                }
                if (!(String.valueOf(numero).length() < 5)) {
                    try {
                        new UrnaDao().updateVotosVereador(numero);
                        votoLegenda();
                        return true;
                    } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
                        return false;
                    }
                }

                return true;
            }

            return true;
        }

        return true;
    }

    private boolean votoNulo() {
        try {
            if (cargo.equalsIgnoreCase("prefeito")) {
                new UrnaDao().updateNulosPrefeito();
            } else {
                new UrnaDao().updateNulosVereador();
            }
            return true;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            return false;
        }
    }

    private boolean votoBranco() {
        try {
            if (cargo.equalsIgnoreCase("prefeito")) {
                new UrnaDao().updateBrancosPrefeito();
            } else {
                new UrnaDao().updateBrancosVereador();
            }

            return true;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            return false;
        }
    }

    private boolean votoLegenda() {
        numero = new InformacoesCandidatos().numero2Digitos();
        try {
            new UrnaDao().updateVotosPartido(numero);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            return votoNulo();
        }

        return true;
    }

    public void acaoConfirmar() {
        brancoPressionado = false;
        brancoDesabilitado = true;

        if (!lblFim.isVisible()) {
            desabilitado = false;
        }

        if (!desabilitado) {

            cargo = lblCargo.getText(); //pega o cargo que está sendo votado atualmente

            //Computa o voto
            voto = computarVoto();

            if (!voto) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro e o voto não foi computado", "Erro ao Votar", JOptionPane.ERROR_MESSAGE);
            }
            //Fim da Computação

            cancelar();

            animation(lblNum1);

            limpar();

            restart();

            if (cargo.equalsIgnoreCase("prefeito")) {

            }
        }
    }
}
