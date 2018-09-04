package pkg01.geradorprova;
/**
 * @author lucasgb7
 */
import java.util.Scanner;
public class GeradorProva {
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
        while(!s.hasNextInt()){
            System.out.println("Por favor, digite um numero inteiro");
            s.next();
        }
        p.setPeso(s.nextInt());
        System.out.println("");
        s.nextLine();
        
        System.out.println("Digite a quantidade de questões discursivas: ");
        while(!s.hasNextInt()){
            System.out.println("Por favor, digite um numero inteiro");
            s.next();
        }
        int tamDiscursiva = s.nextInt();
        s.nextLine();
        
        System.out.println("Digite a quantidade de questões objetivas: ");
        while(!s.hasNextInt()){
            System.out.println("Por favor, digite um numero inteiro");
            s.next();
        }
        int tamObjetiva = s.nextInt();
        s.nextLine();
        
        int i;
        Discursiva[] auxDiscursiva;
        auxDiscursiva = new Discursiva[tamDiscursiva];
        // Ârmazena um vetor auxiliar de questões discursivas
        for(i = 0; i < tamDiscursiva; i++){
            auxDiscursiva[i] = new Discursiva(); // Alocando espaço na memória
            System.out.println("Digite a pergunta da questão discursiva[" + i + "]: ");
            auxDiscursiva[i].setPergunta(s.nextLine());
            System.out.println("");
            // ^Leitura da pergunta da questão discursiva (i)
            System.out.println("Digite o peso da questão discursiva[" + i + "]: ");
            while (!s.hasNextDouble()){
                System.out.println("Por favor, digite um numero inteiro/decimal");
                s.next();
            }
            auxDiscursiva[i].setPeso(s.nextDouble());
            s.nextLine();
            // ^Leitura do peso da questão discursiva (i)
            System.out.println("Digite os critérios de correção da questão discursiva[" + i + "]: ");
            auxDiscursiva[i].setCriteriosCorrecao(s.nextLine());
            System.out.println("\n\n");
            // ^Leitura dos critérios de avaliação
        }
        
        Objetiva[] auxObjetiva;
        auxObjetiva = new Objetiva[tamObjetiva];

        // ^Armazena um vetor auxiliar de questões objetivas
        for(i = 0; i < tamObjetiva; i++){
            auxObjetiva[i] = new Objetiva(); // Alocando espaço na memória
            
            System.out.println("Digite a pergunta da questão objetiva[" + i + "]: ");
            auxObjetiva[i].setPergunta(s.nextLine());
            // ^ Leitura da pergunta da questão objetiva (i)
            System.out.println("Digite o peso da questão objetiva[" + i + "]: ");
            while(!s.hasNextDouble()){
                System.out.println("Digite um numero inteiro/decimal");
                s.next();
            }
            auxObjetiva[i].setPeso(s.nextDouble());
            s.nextLine();
            // ^ Leitura do peso da questão objetiva (i)
            System.out.println("Digite as alternativas da questão[" + i +"]: ");
            String[] opcao = new String[5]; // Armazena 5 posições para vetor opcao
            s.nextLine();
            for (int j = 0; j < 5; j++){
                System.out.println("Alternativa[" + j + "]: ");
                opcao[j] = s.nextLine();
            } // Leitura das alternativas da questão objetiva (i)
            auxObjetiva[i].setOpcao(opcao);
            System.out.println("Digite a alternativa correta (1<=x<=5)da questão[" + i +"]: ");
            while(!s.hasNextInt()){
                System.out.println("Por favor digitar um numero inteiro entre 1 e 5");
                s.next();
            }
            while(s.nextInt() < 1 || s.nextInt() > 5){
                System.out.println("Por favor digitar um numero inteiro entre 1 e 5");
            }
            while(s.nextInt() < 1 || s.nextInt() > 5){
                auxObjetiva[i].setRespostaCorreta(s.nextInt());
                s.nextLine();
            }
            // ^Leitura da opção correta 
            s.nextLine();
        }
        p.setQuestaoDiscursiva(auxDiscursiva); // Prova recebe as questões Discursivas
        p.setQuestaoObjetiva(auxObjetiva); // Prova recebe as questões Objetivas
        
        System.out.println(p.obtemDetalhes()); // Imprime o cabeçalho da prova
        System.out.println(p.imprimeProva()); // Imprime as questões
           
    }
}