/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.urna.model;

/**
 *
 * @author Aluno_2
 */
public class Urna{
    private int numero;
    private byte[] imagem;
    private String candidato, partido;
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }       

    public byte[] getImagem() {
        return imagem;
    }   

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }    

    public String getCandidato() {
        return candidato;
    }

    public void setCandidato(String candidato) {
        this.candidato = candidato;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }    
}
