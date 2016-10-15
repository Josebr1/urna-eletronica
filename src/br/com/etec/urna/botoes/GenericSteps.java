/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.urna.botoes;

import static br.com.etec.urna.animacoes.Animacoes.animation;
import static br.com.etec.urna.animacoes.Animacoes.animationText;
import static br.com.etec.urna.animacoes.Animacoes.cancelAnimation;
import br.com.etec.urna.dao.UrnaDao;
import static br.com.etec.urna.layout.Layout.brancoPressionado;
import static br.com.etec.urna.layout.Layout.desabilitado;
import static br.com.etec.urna.layout.Layout.lblCandidatoInexistente;
import static br.com.etec.urna.layout.Layout.lblCargo;
import static br.com.etec.urna.layout.Layout.lblFim;
import static br.com.etec.urna.layout.Layout.lblImgCandidato;
import static br.com.etec.urna.layout.Layout.lblImgPrefeito;
import static br.com.etec.urna.layout.Layout.lblImgVice;
import static br.com.etec.urna.layout.Layout.lblInfo;
import static br.com.etec.urna.layout.Layout.lblInstrucoes1;
import static br.com.etec.urna.layout.Layout.lblInstrucoes2;
import static br.com.etec.urna.layout.Layout.lblInstrucoes3;
import static br.com.etec.urna.layout.Layout.lblLegendaGrande;
import static br.com.etec.urna.layout.Layout.lblLegendaPeq;
import static br.com.etec.urna.layout.Layout.lblLinha;
import static br.com.etec.urna.layout.Layout.lblNome;
import static br.com.etec.urna.layout.Layout.lblNomeCandidato;
import static br.com.etec.urna.layout.Layout.lblNomePartido;
import static br.com.etec.urna.layout.Layout.lblNulo;
import static br.com.etec.urna.layout.Layout.lblNum1;
import static br.com.etec.urna.layout.Layout.lblNum2;
import static br.com.etec.urna.layout.Layout.lblNum3;
import static br.com.etec.urna.layout.Layout.lblNum4;
import static br.com.etec.urna.layout.Layout.lblNum5;
import static br.com.etec.urna.layout.Layout.lblNumero;
import static br.com.etec.urna.layout.Layout.lblNumeroErrado;
import static br.com.etec.urna.layout.Layout.lblPartido;
import java.sql.SQLException;

/**
 *
 * @author Victor
 */
public class GenericSteps {

    private boolean numeroExiste, partidoExiste, viceExiste;

    public GenericSteps(String numeroBotao) {
        if (!lblFim.isVisible()) {
            desabilitado = false;
        }

        if (!desabilitado) {
            if (!brancoPressionado) {
                if (lblNum1.getText().isEmpty()) {
                    lblNum1.setText(numeroBotao);
                    cancelAnimation(lblNum1);
                    animation(lblNum2);
                } else if (lblNum2.getText().isEmpty()) {
                    lblNum2.setText(numeroBotao);
                    cancelAnimation(lblNum2);
                    animation(lblNum3);
                    lblInfo.setVisible(true);
                    lblNumero.setVisible(true);

                    if (lblCargo.getText().equalsIgnoreCase("prefeito")) {

                        int numero = new InformacoesCandidatos().numero2Digitos();
                        try {
                            numeroExiste = new UrnaDao().numeroExiste(numero);
                            viceExiste = new UrnaDao().viceExiste(numero);
                        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
                        }

                        if (numeroExiste) {
                            if (viceExiste) {
                                try {
                                    lblNomeCandidato.setText(new InformacoesCandidatos().setNome(lblCargo.getText()));
                                    lblNomePartido.setText(new InformacoesCandidatos().setPartido());
                                } catch (InstantiationException | IllegalAccessException | SQLException | ClassNotFoundException ex) {
                                }

                                lblNome.setVisible(true);
                                lblNomeCandidato.setVisible(true);
                                lblPartido.setVisible(true);
                                lblNomePartido.setVisible(true);

                                try {
                                    new AdicionarImagem().setImagens();
                                } catch (InstantiationException | IllegalAccessException | SQLException | ClassNotFoundException ex) {
                                }

                                lblImgPrefeito.setVisible(true);
                                lblImgVice.setVisible(true);
                            } else {
                                votoNulo();
                            }
                        } else {
                            votoNulo();
                        }
                    } else {
                        int numero = new InformacoesCandidatos().numero2Digitos();
                        try {
                            partidoExiste = new UrnaDao().partidoExiste(numero);
                        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
                        }
                        if (partidoExiste) {
                            try {
                                lblNomePartido.setText(new InformacoesCandidatos().setPartido());
                            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
                            }
                            lblPartido.setVisible(true);
                            lblNomePartido.setVisible(true);
                            lblLegendaPeq.setVisible(true);
                            animationText(lblLegendaPeq);
                        } else {
                            votoNulo();
                        }
                    }
                    lblInstrucoes1.setVisible(true);
                    lblInstrucoes2.setVisible(true);
                    lblInstrucoes3.setVisible(true);
                    lblLinha.setVisible(true);
                } else if (lblNum3.getText().isEmpty()) {
                    lblNum3.setText(numeroBotao);
                    cancelAnimation(lblNum3);
                    animation(lblNum4);
                } else if (lblNum4.getText().isEmpty()) {
                    lblNum4.setText(numeroBotao);
                    cancelAnimation(lblNum4);
                    animation(lblNum5);
                } else if (lblNum5.getText().isEmpty()) {
                    lblNum5.setText(numeroBotao);
                    cancelAnimation(lblNum5);
                    if (lblCargo.getText().equalsIgnoreCase("vereador")) {
                        int numero = new InformacoesCandidatos().numero5Digitos();
                        try {
                            lblNomeCandidato.setText(new InformacoesCandidatos().setNome(lblCargo.getText()));
                            lblNomePartido.setText(new InformacoesCandidatos().setPartido());
                            numeroExiste = new UrnaDao().numeroExiste(numero);

                            numero = new InformacoesCandidatos().numero2Digitos();
                            partidoExiste = new UrnaDao().partidoExiste(numero);
                        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
                        }

                        if (partidoExiste) {
                            lblPartido.setVisible(true);
                            lblNomePartido.setVisible(true);
                            if (!numeroExiste) {
                                lblCandidatoInexistente.setVisible(true);
                                lblLegendaGrande.setVisible(true);
                                lblLegendaPeq.setVisible(false);
                                animationText(lblLegendaGrande);
                            } else {
                                lblNome.setVisible(true);
                                lblNomeCandidato.setVisible(true);
                                lblLegendaPeq.setVisible(false);
                                try {
                                    new AdicionarImagem().setImagem();
                                } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
                                }

                                lblImgCandidato.setVisible(true);
                            }
                        } else {
                            votoNulo();
                        }
                    }
                }
            }
        }        
    }

    private void votoNulo() {
        lblNumeroErrado.setVisible(true);
        lblNulo.setVisible(true);
        animationText(lblNulo);
    }
}
