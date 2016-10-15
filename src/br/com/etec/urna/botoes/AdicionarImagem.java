/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.urna.botoes;

import br.com.etec.urna.dao.UrnaDao;
import static br.com.etec.urna.layout.Layout.lblImgCandidato;
import static br.com.etec.urna.layout.Layout.lblImgPrefeito;
import static br.com.etec.urna.layout.Layout.lblImgVice;
import static br.com.etec.urna.layout.Layout.lblNum1;
import static br.com.etec.urna.layout.Layout.lblNum2;
import static br.com.etec.urna.layout.Layout.lblNum3;
import static br.com.etec.urna.layout.Layout.lblNum4;
import static br.com.etec.urna.layout.Layout.lblNum5;
import br.com.etec.urna.utils.ExibirImagem;
import java.sql.SQLException;

/**
 *
 * @author Victor
 */
public class AdicionarImagem {

    public void setImagens() throws InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException {
        String numero = lblNum1.getText() + lblNum2.getText();
        numero = numero.replaceAll(" ", "");
        UrnaDao uDao = new UrnaDao();
        new ExibirImagem(uDao.selectImgCandidato(Integer.valueOf(numero)), lblImgPrefeito, "prefeito");
        new ExibirImagem(uDao.selectImgVice(Integer.valueOf(numero)), lblImgVice, "vice");
    }

    public void setImagem() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        String numero = lblNum1.getText() + lblNum2.getText() + lblNum3.getText() + lblNum4.getText() + lblNum5.getText();
        numero = numero.replaceAll(" ", "");
        UrnaDao uDao = new UrnaDao();
        new ExibirImagem(uDao.selectImgCandidato(Integer.valueOf(numero)), lblImgCandidato, "vereador");
    }
}
