/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

/**
 *
 * @author lucas
 */
public class GeradorProva {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Prova x = new Prova("POO");
        x.setLocal ("Lab 3 - Bloco B6");
        x.setData ("2018-08-28");
        
        // forma didtica
//        String retornoDoMetodo = x.obtemDetalhes();
//        System.out.println(retornoDoMetodo);
        /// forma resumida
        System.out.println(x.obtemDetalhes());
        
        Discursiva d = new Discursiva();
        d.setPergunta("Qual o seu nome?");
        d.setPeso(0);
        d.setCriteriosCorrecao("Saber o próprio nome");
        
        Objetiva o = new Objetiva();
        o.setPergunta("Qual o melhor time do Brasil?");
        o.setPeso(2);
        String[] opcao = new String[5];
        opcao[0] = "Grêmio";
        opcao[1] = "Internacional";
        opcao[2] = "Flamengo";
        opcao[3] = "Corinthians";
        opcao[4] = "São Paulo";
        o.setOpcao(opcao);
        o.setRespostaCorreta(2);
        
    }
    
}
