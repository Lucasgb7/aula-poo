package pkg01.geradorprova;
/**
 * @author lucas
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
        p.setPeso(s.nextInt());
        
        s.nextLine();
        System.out.println("");
        
        System.out.println("Digite a quantidade de questões discursivas: ");
        int tamDiscursiva = s.nextInt();
        s.nextLine();
        System.out.println("Digite a quantidade de questões objetivas: ");
        int tamObjetiva = s.nextInt();
        s.nextLine();
        
        int i;
        Discursiva[] auxDiscursiva;
        auxDiscursiva = new Discursiva[tamDiscursiva];
        for(i = 0; i < tamDiscursiva; i++){
            auxDiscursiva[i] = new Discursiva();
            System.out.println("Digite a pergunta da questão discursiva[" + i + "]: ");
            auxDiscursiva[i].setPergunta(s.nextLine());
            System.out.println("");
            
            System.out.println("Digite o peso da questão discursiva[" + i + "]: ");
            auxDiscursiva[i].setPeso(s.nextDouble());
            s.nextLine();
            System.out.println("");
            
            System.out.println("Digite os critérios de correção da questão discursiva[" + i + "]: ");
            auxDiscursiva[i].setCriteriosCorrecao(s.nextLine());
            System.out.println("\n");
        }
        Objetiva[] auxObjetiva;
        auxObjetiva = new Objetiva[tamObjetiva];
        s.nextLine();
        // ^Armazena um vetor auxiliar de questões objetivas
        for(i = 0; i < tamObjetiva; i++){
            auxObjetiva[i] = new Objetiva(); // Alocando espaço na memória
            
            System.out.println("Digite a pergunta da questão objetiva[" + i + "]: ");
            auxObjetiva[i].setPergunta(s.nextLine());
            // ^ Leitura da pergunta da questão objetiva (i)
            System.out.println("Digite o peso da questão objetiva[" + i + "]: ");
            auxObjetiva[i].setPeso(s.nextInt());
            // ^ Leitura do peso da questão objetiva (i)
            System.out.println("Digite as alternativas da questão[" + i +"]: ");
            String[] opcao = new String[5]; // Armazena 5 posições para vetor opcao
            s.nextLine();
            for (int j = 0; j < 5; j++){
                System.out.println("Alternativa[" + j + "]: ");
                opcao[j] = s.nextLine();
            } // Leitura das alternativas da questão objetiva (i)
            auxObjetiva[i].setOpcao(opcao);
            System.out.println("Digite a alternativa correta da questão[" + i +"]: ");
            auxObjetiva[i].setRespostaCorreta(s.nextInt());
            // ^Leitura da opção correta 
            s.nextLine();
        }
        p.setQuestaoDiscursiva(auxDiscursiva); // Prova recebe as questões Discursivas
        p.setQuestaoObjetiva(auxObjetiva); // Prova recebe as questões Objetivas
        
        System.out.println(p.obtemDetalhes()); // Imprime o cabeçalho da prova
        System.out.println(p.imprimeProva()); // Imprime as questões
           
    }
}
