/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.urna.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Aluno_2
 */
public class ConexaoBD {
    public static Connection getConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        String stringConexao = "jdbc:mysql://169.254.36.63:3306/eleicao?user='root'&pass=";
        Connection connection = DriverManager.getConnection(stringConexao);
        return connection;

    }

    public static ResultSet getResultSet(Connection connection, String sql) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    }

    public static PreparedStatement getPreparedStatement(Connection connection, String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }
}
