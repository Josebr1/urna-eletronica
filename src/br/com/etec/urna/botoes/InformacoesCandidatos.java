/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.urna.botoes;

import br.com.etec.urna.dao.UrnaDao;
import static br.com.etec.urna.layout.Layout.lblNum1;
import static br.com.etec.urna.layout.Layout.lblNum2;
import static br.com.etec.urna.layout.Layout.lblNum3;
import static br.com.etec.urna.layout.Layout.lblNum4;
import static br.com.etec.urna.layout.Layout.lblNum5;
import java.sql.SQLException;

/**
 *
 * @author Victor
 */
public class InformacoesCandidatos {

    public String setNome(String cargo) throws InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException {

        int numero;
        if (cargo.equalsIgnoreCase("prefeito")) {
            numero = numero2Digitos();
        } else {
            numero = numero5Digitos();
        }
        return new UrnaDao().selectCandidato(numero);
    }

    public String setPartido() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        int numero = numero2Digitos();
        return new UrnaDao().selectPartido(numero);
    }

    public int numero2Digitos() {
        String numero = lblNum1.getText() + lblNum2.getText();
        numero = numero.replaceAll(" ", "");
        return Integer.valueOf(numero);
    }

    public int numero5Digitos() {
        String numero = lblNum1.getText() + lblNum2.getText() + lblNum3.getText() + lblNum4.getText() + lblNum5.getText();
        numero = numero.replaceAll(" ", "");
        return Integer.valueOf(numero);
    }
}
