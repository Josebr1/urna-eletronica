/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.urna.dao;

import br.com.etec.urna.model.Urna;
import br.com.etec.urna.utils.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Aluno_2
 */
public class UrnaDao {

    Connection connection;

    public boolean updateBrancosPrefeito() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

        String sql = "update voto_branco set voto_branco_prefeito=?";
        connection = ConexaoBD.getConnection();
        PreparedStatement statement = ConexaoBD.getPreparedStatement(connection, sql);
        statement.setInt(1, (selectBrancosPrefeito() + 1));
        statement.execute();

        if (connection != null) {
            connection.close();
        }

        return true;

    }

    public boolean updateBrancosVereador() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

        String sql = "update voto_branco set voto_branco_vereador=?";
        connection = ConexaoBD.getConnection();
        PreparedStatement statement = ConexaoBD.getPreparedStatement(connection, sql);
        statement.setInt(1, (selectBrancosVereador() + 1));
        statement.execute();

        if (connection != null) {
            connection.close();
        }

        return true;

    }

    public boolean updateNulosPrefeito() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

        String sql = "update voto_nulo set voto_nulo_prefeito=?";
        connection = ConexaoBD.getConnection();
        PreparedStatement statement = ConexaoBD.getPreparedStatement(connection, sql);
        statement.setInt(1, (selectNulosPrefeito() + 1));

        statement.execute();

        if (connection != null) {
            connection.close();
        }
        return true;
    }

    public boolean updateNulosVereador() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

        String sql = "update voto_nulo set voto_nulo_vereador=?";
        connection = ConexaoBD.getConnection();
        PreparedStatement statement = ConexaoBD.getPreparedStatement(connection, sql);
        statement.setInt(1, (selectNulosVereador() + 1));

        statement.execute();

        if (connection != null) {
            connection.close();
        }

        return true;
    }

    public int selectVotosPrefeito(int numero) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        ResultSet resultSet;
        try {
            connection = ConexaoBD.getConnection();
            String sql = "select votos from prefeito where numero=?";
            PreparedStatement statement = ConexaoBD.getPreparedStatement(connection, sql);
            statement.setInt(1, numero);

            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("votos");
            } else {
                return 0;
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public int selectVotosPartido(int numero) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        ResultSet resultSet;
        try {
            connection = ConexaoBD.getConnection();
            String sql = "select votos from partido where numero=?";
            PreparedStatement statement = ConexaoBD.getPreparedStatement(connection, sql);
            statement.setInt(1, numero);

            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("votos");
            } else {
                return 0;
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public int selectVotosVereador(int numero) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        ResultSet resultSet;
        try {
            connection = ConexaoBD.getConnection();
            String sql = "select votos from vereador where numero=?";
            PreparedStatement statement = ConexaoBD.getPreparedStatement(connection, sql);
            statement.setInt(1, numero);

            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("votos");
            } else {
                return 0;
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public int selectBrancosPrefeito() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        ResultSet resultSet;
        try {
            connection = ConexaoBD.getConnection();
            String sql = "select voto_branco_prefeito from voto_branco";
            PreparedStatement statement = ConexaoBD.getPreparedStatement(connection, sql);

            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("voto_branco_prefeito");
            } else {
                return 0;
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public int selectNulosPrefeito() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        ResultSet resultSet;
        try {
            connection = ConexaoBD.getConnection();
            String sql = "select voto_nulo_prefeito from voto_nulo";
            PreparedStatement statement = ConexaoBD.getPreparedStatement(connection, sql);

            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("voto_nulo_prefeito");
            } else {
                return 0;
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public int selectBrancosVereador() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        ResultSet resultSet;
        try {
            connection = ConexaoBD.getConnection();
            String sql = "select voto_branco_vereador from voto_branco";
            PreparedStatement statement = ConexaoBD.getPreparedStatement(connection, sql);

            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("voto_branco_vereador");
            } else {
                return 0;
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public int selectNulosVereador() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        ResultSet resultSet;
        try {
            connection = ConexaoBD.getConnection();
            String sql = "select voto_nulo_vereador from voto_nulo";
            PreparedStatement statement = ConexaoBD.getPreparedStatement(connection, sql);

            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("voto_nulo_vereador");
            } else {
                return 0;
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public byte[] selectImgVice(int numero) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        ResultSet resultSet;
        try {
            connection = ConexaoBD.getConnection();
            String sql = "select foto from vice_prefeito where (select prefeito.id_vice from prefeito where numero=?) = vice_prefeito.id_vice";
            PreparedStatement statement = ConexaoBD.getPreparedStatement(connection, sql);
            statement.setInt(1, numero);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Urna urna = new Urna();
                urna.setImagem(resultSet.getBytes("foto"));
                return urna.getImagem();
            } else {
                return null;
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public byte[] selectImgCandidato(int numero) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        ResultSet resultSet;
        try {
            connection = ConexaoBD.getConnection();
            String sql;
            if (String.valueOf(numero).length() <= 2) {
                sql = "select foto from prefeito where numero=?";
            } else {
                sql = "select foto from vereador where numero=?";
            }
            PreparedStatement statement = ConexaoBD.getPreparedStatement(connection, sql);
            statement.setInt(1, numero);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Urna urna = new Urna();
                urna.setImagem(resultSet.getBytes("foto"));
                return urna.getImagem();
            } else {
                return null;
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public String selectPartido(int numero) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        ResultSet resultSet;
        try {
            connection = ConexaoBD.getConnection();
            String sql = "select sigla from partido where numero=?";
            PreparedStatement statement = ConexaoBD.getPreparedStatement(connection, sql);
            statement.setInt(1, numero);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Urna urna = new Urna();
                urna.setPartido(resultSet.getString("sigla"));
                return urna.getPartido();
            } else {
                return null;
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public String selectCandidato(int numero) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        ResultSet resultSet;
        try {
            connection = ConexaoBD.getConnection();
            String sql;
            if (String.valueOf(numero).length() <= 2) {
                sql = "select nome from prefeito where numero=?";
            } else {
                sql = "select nome from vereador where numero=?";
            }

            PreparedStatement statement = ConexaoBD.getPreparedStatement(connection, sql);
            statement.setInt(1, numero);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Urna urna = new Urna();
                urna.setCandidato(resultSet.getString("nome"));
                return urna.getCandidato();
            } else {
                return null;
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public boolean updateVotosPrefeito(int numero) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        String sql = "update prefeito set votos=? where numero=?";
        connection = ConexaoBD.getConnection();
        PreparedStatement statement = ConexaoBD.getPreparedStatement(connection, sql);
        statement.setInt(1, (selectVotosPrefeito(numero) + 1));
        statement.setInt(2, numero);
        statement.execute();

        if (connection != null) {
            connection.close();
        }
        return true;
    }

    public boolean updateVotosVereador(int numero) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        String sql = "update vereador set votos=? where numero=?";
        connection = ConexaoBD.getConnection();
        PreparedStatement statement = ConexaoBD.getPreparedStatement(connection, sql);
        statement.setInt(1, (selectVotosVereador(numero) + 1));
        statement.setInt(2, numero);
        statement.execute();

        if (connection != null) {
            connection.close();
        }
        return true;
    }

    public boolean partidoExiste(int numero) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        ResultSet resultSet;
        try {
            connection = ConexaoBD.getConnection();
            String sql = "select * from partido where numero=?";
            PreparedStatement statement = ConexaoBD.getPreparedStatement(connection, sql);
            statement.setInt(1, numero);
            resultSet = statement.executeQuery();
            return resultSet.next();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public boolean numeroExiste(int numero) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        ResultSet resultSet;
        try {
            connection = ConexaoBD.getConnection();
            String sql;
            if (String.valueOf(numero).length() <= 2) {
                sql = "select * from prefeito where numero=?";
            } else {
                sql = "select * from vereador where numero=?";
            }
            PreparedStatement statement = ConexaoBD.getPreparedStatement(connection, sql);
            statement.setInt(1, numero);
            resultSet = statement.executeQuery();
            return resultSet.next();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public boolean viceExiste(int numero) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        ResultSet resultSet;
        try {
            connection = ConexaoBD.getConnection();
            String sql = "select * from vice_prefeito where (select id_prefeito from prefeito where numero=? and id_prefeito = vice_prefeito.id_prefeito)";
            PreparedStatement statement = ConexaoBD.getPreparedStatement(connection, sql);
            statement.setInt(1, numero);
            resultSet = statement.executeQuery();
            return resultSet.next();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public boolean updateVotosPartido(int numero) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        String sql = "update partido set votos=? where numero=?";
        connection = ConexaoBD.getConnection();
        PreparedStatement statement = ConexaoBD.getPreparedStatement(connection, sql);
        statement.setInt(1, (selectVotosPartido(numero) + 1));
        statement.setInt(2, numero);

        statement.execute();

        if (connection != null) {
            connection.close();
        }
        return true;
    }
}
