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
import java.util.Scanner;
public class GeradorProva {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Prova p = new Prova();
        Scanner s = new Scanner(System.in);
        System.out.println("Digite a disciplina: ");
        p.setNomeDisciplina(s.nextLine());
        System.out.println("Digite o local: ");
        p.setLocal(s.nextLine());
        System.out.println("Digite a data: ");
        p.setData(s.nextLine());
        System.out.println("Digite o peso: ");
        p.setPeso(s.nextInt());
        
        System.out.println("Digite a quantidade de questões discursivas: ");
        int tamDiscursiva = s.nextInt();
        System.out.println("Digite a quantidade de questões objetivas: ");
        int tamObjetiva = s.nextInt();
        
        int i;
        Discursiva[] auxDiscursiva = new Discursiva[tamDiscursiva];
        for(i = 0; i < tamDiscursiva; i++){
            System.out.println("Preencha o enunciado da questão discursiva ["+i+"]: ");
            auxDiscursiva[i].setPergunta(s.nextLine());
            
            System.out.println("Informe o peso da questão ["+i+"]: ");
            auxDiscursiva[i].setPeso(s.nextInt());
            
            System.out.println("Digite os critérios de avaliação da questão ["+i+"]: ");
            auxDiscursiva[i].setCriteriosCorrecao(s.nextLine());
        }
        
        for(i = 0; i < tamObjetiva; i++){
            
        }
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
