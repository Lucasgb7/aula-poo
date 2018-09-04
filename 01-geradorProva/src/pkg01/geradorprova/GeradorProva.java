package pkg01.geradorprova;
/**
 * @author lucasgb7
 */
import java.util.Scanner;
public class GeradorProva {
    public static void main(String[] args) {
        Prova p = new Prova(); // Criando a prova
        Scanner s = new Scanner(System.in); // Criando o scanner 
        
        System.out.println("Digite a disciplina: ");
        p.setNomeDisciplina(s.nextLine()); // Lê o nome da disciplina da prova
        
        System.out.println("Digite o local: ");
        p.setLocal(s.nextLine()); // Lê o local da prova
        
        System.out.println("Digite a data: ");
        p.setData(s.nextLine()); // Lê a data da prova
        
        System.out.println("Digite o peso: "); // Le o peso da prova
        while(!s.hasNextInt()){ // Verifica se o valor digitado é inteiro
            System.out.println("Por favor, digite um numero inteiro");
            s.next(); // Mensagem de erro, e da um next()
        }
        p.setPeso(s.nextInt()); // Lê o peso correto
        System.out.println(""); 
        s.nextLine();
        
        System.out.println("Digite a quantidade de questões discursivas: ");
        while(!s.hasNextInt()){
            System.out.println("Por favor, digite um numero inteiro");
            s.next();
        } // Lê a quantidade de questões discursivas e verifica se é inteiro
        int tamDiscursiva = s.nextInt();
        s.nextLine();
        
        System.out.println("Digite a quantidade de questões objetivas: ");
        while(!s.hasNextInt()){
            System.out.println("Por favor, digite um numero inteiro");
            s.next();
        }
        int tamObjetiva = s.nextInt();
        s.nextLine();
        System.out.println("\n\n");
        
        int i;
        Discursiva[] auxDiscursiva;
        auxDiscursiva = new Discursiva[tamDiscursiva];
        // Ârmazena um vetor auxiliar de questões discursivas
        for(i = 0; i < tamDiscursiva; i++){
            auxDiscursiva[i] = new Discursiva(); // Alocando espaço na memória
            System.out.println("Digite a pergunta da questão discursiva[" + i + "]: ");
            auxDiscursiva[i].setPergunta(s.nextLine());

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
            for (int j = 0; j < 5; j++){
                System.out.println("Alternativa[" + j + "]: ");
                opcao[j] = s.nextLine();
            } 
            auxObjetiva[i].setOpcao(opcao);
            // ^Leitura das alternativas da questão objetiva (i)
            int aux;
            do
            {
                System.out.println("Digite a alternativa correta (0 a 4) da questao"
                        + "[" + i + "]: ");
                while(!s.hasNextInt())
                {
                    System.out.println("Por favor, digite um número inteiro.");
                    s.next();
                }
                aux = s.nextInt();
                if(aux < 0 || aux > 4)
                    System.out.println("Por favor, digite um número entre 0 e 4.");
            }
            while(aux < 0 || aux > 4);
            auxObjetiva[i].setRespostaCorreta(aux); // Leitura da opção correta 
            s.nextLine();
        }        
        p.setQuestaoDiscursiva(auxDiscursiva); // Prova recebe as questões Discursivas
        p.setQuestaoObjetiva(auxObjetiva); // Prova recebe as questões Objetivas
        
        System.out.println(p.obtemDetalhes()); // Imprime o cabeçalho da prova
        System.out.println(p.provaImpressao()); // Imprime as questões  
    }
}