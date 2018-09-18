package pkg01.geradorprova;
/**
 * @author lucasgb7
 */
import javax.swing.JOptionPane;
import java.util.ArrayList;    
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class GeradorProva {
    public static void main(String[] args){
//        File arquivo = new File("prova.txt");
////        FileOutputStream fos = new FileOutputStream(arquivo);
////        if (arquivo.createNewFile()){
////            System.out.println("Arquivo criado com sucesso!");
////        }else{
////            System.out.println("Nao foi possivel criar o arquivo");
////        }      
        Prova p = new Prova(); // Criando a prova
        
        p.setNomeDisciplina(JOptionPane.showInputDialog("Digite o nome da disipina")); // Lê o nome da discplina
        p.setLocal(JOptionPane.showInputDialog("Digite o local da prova")); // Lê o local da prova
        p.setData(JOptionPane.showInputDialog("Digite a data: "));// Lê a data da prova
        
        while (true) {
            try {
                p.setPeso(Integer.parseInt(JOptionPane.showInputDialog("Digite o peso da prova: ")));
                break; // Lê o peso como String e transforma para Inteiro
            }catch (Exception erro) {
                JOptionPane.showMessageDialog(null, erro);
            }
        }
        ArrayList<Questao> list = new ArrayList();
        String simOunao;
        do {
            String opc;
            try{
                opc = JOptionPane.showInputDialog("Discursiva(D) ou Objetiva(O)?");
                if ("D".equals(opc)){
                    Discursiva auxDiscursiva = new Discursiva();
                    
                    auxDiscursiva.setPergunta(JOptionPane.showInputDialog("Digite a pergunta: "));
                    auxDiscursiva.setCriteriosCorrecao(JOptionPane.showInputDialog("Digite os critérios de correção: "));
                    while (true) {
                        try {
                            auxDiscursiva.setPeso(Integer.parseInt(JOptionPane.showInputDialog("Digite o peso da questão: ")));
                            break; // Lê o peso como String e transforma para Inteiro
                        }catch (Exception erro) {
                            JOptionPane.showMessageDialog(null, erro);
                        }
                    }
                    
                    list.add(auxDiscursiva); // Adicionando a questão na lista
                }
                if ("O".equals(opc)){
                    Objetiva auxObjetiva = new Objetiva();
                    
                    auxObjetiva.setPergunta(JOptionPane.showInputDialog("Digite a pergunta"));
                    String[] opcao = new String[5];
                    for (int i = 0; i < opcao.length; i++){
                        opcao[i] = JOptionPane.showInputDialog("Digite a alternativa ["+i+"]: ");
                    }
                    auxObjetiva.setOpcao(opcao);
                    
                    while (true) {
                        try {
                            auxObjetiva.setRespostaCorreta(Integer.parseInt(JOptionPane.showInputDialog("Digite a opção correta(0<=x<=4): ")));
                            if (auxObjetiva.getRespostaCorreta() < 0 || auxObjetiva.getRespostaCorreta() > 4){
                                JOptionPane.showMessageDialog(null, "Digite um valor entre 0 e 4!");
                            }
                            break; // Lê o peso como String e transforma para Inteiro
                        }catch (Exception erro) {
                            JOptionPane.showMessageDialog(null, erro);
                        }
                    }
                    while (true) {
                        try {
                            auxObjetiva.setPeso(Integer.parseInt(JOptionPane.showInputDialog("Digite o peso da questão: ")));
                            break; // Lê o peso como String e transforma para Inteiro
                        }catch (Exception erro) {
                            JOptionPane.showMessageDialog(null, erro);
                        }
                    }
                    
                    list.add(auxObjetiva);
                }
            }catch (IllegalArgumentException erro){
                JOptionPane.showMessageDialog(null, erro);
            }catch (Exception erro){
                JOptionPane.showMessageDialog(null, erro);
            }
            do{
                simOunao = JOptionPane.showInputDialog("Deseja adicionar mais uma questão? (S-Sim | N-Não)");
                if (!"S".equals(simOunao) && !"N".equals(simOunao)){
                    JOptionPane.showMessageDialog(null, "Digite 'S' ou 'N'");
                }
            }while(!"S".equals(simOunao) && !"N".equals(simOunao));
        }while("S".equals(simOunao));
        
        p.setQuestao(list);
        System.out.println(p.obtemDetalhes());
        System.out.println(p.provaImpressao());
        
        String provaImpressa = p.obtemDetalhes() + p.provaImpressao();
        try{
            File arquivo = new File("prova.txt");
            FileWriter escritor = new FileWriter(arquivo);
            PrintWriter saida = new PrintWriter(escritor);
            // Como ja tem a prova impressa é so colocar no arquivo
            saida.println(provaImpressa);
            saida.close();
            System.out.println("Arquivo salvo!");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, erro);
        }
    }
}