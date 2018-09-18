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
import java.util.ArrayList;
public class Prova {
    private String nomeDisciplina;
    private int peso;
    private String local;
    private String data;
    private Objetiva[] questaoObjetiva;
    private Discursiva[] questaoDiscursiva;
    private ArrayList<Questao> questao; 
    
    public Prova(){
        questao = new ArrayList<>();
    }

    public String obtemDetalhes() {
        String retorno = "===========================================\r\n";
        retorno += "Disciplina: " + this.getNomeDisciplina() + "\r\n";
        retorno += "Peso: " + this.getPeso() + "\r\n";
        retorno += "Local: " + this.getLocal() + "\r\n";
        retorno += "Data: " + this.getData() + "\r\n";
        retorno += "===========================================\r\n\n";
        return retorno;
    }
    public String provaImpressao(){
        String retorno = "";
        retorno += "Questões: \r\n";
        for (int i = 0; i < this.questao.size(); i++){
            retorno += (i+1) + this.questao.get(i).retornaQuestao() + "\r\n";
        }
        return retorno;
    }
        /**
     * @return the questao
     */
    public ArrayList<Questao> getQuestao() {
        return questao;
    }

    /**
     * @param questao the questao to set
     */
    public void setQuestao(ArrayList<Questao> questao) {
        this.questao = questao;
    }
    
    /**
     * @return the nomeDisciplina
     */
    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    /**
     * @param nomeDisciplina the nomeDisciplina to set
     */
    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    /**
     * @return the peso
     */
    public int getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    /**
     * @return the local
     */
    public String getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the questaoObjetiva
     */
    public Objetiva[] getQuestaoObjetiva() {
        return questaoObjetiva;
    }

    /**
     * @param questaoObjetiva the questaoObjetiva to set
     */
    public void setQuestaoObjetiva(Objetiva[] questaoObjetiva) {
        this.questaoObjetiva = questaoObjetiva;
    }

    /**
     * @return the questaoDiscursiva
     */
    public Discursiva[] getQuestaoDiscursiva() {
        return questaoDiscursiva;
    }

    /**
     * @param questaoDiscursiva the questaoDiscursiva to set
     */
    public void setQuestaoDiscursiva(Discursiva[] questaoDiscursiva) {
        this.questaoDiscursiva = questaoDiscursiva;
    }
}
