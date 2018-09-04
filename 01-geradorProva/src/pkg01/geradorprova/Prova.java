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
public class Prova {

    private String nomeDisciplina;
    private int peso;
    private String local;
    private String data;
    private Objetiva[] questaoObjetiva;
    private Discursiva[] questaoDiscursiva;

    public Prova(){
        
    }

    public String obtemDetalhes() {
        String retorno = "===========================================\n";
        retorno += "Disciplina: " + this.getNomeDisciplina() + "\n";
        retorno += "Peso: " + this.getPeso() + "\n";
        retorno += "Local: " + this.getLocal() + "\n";
        retorno += "Data: " + this.getData() + "\n";
        retorno += "===========================================\n\n";
        return retorno;
    }
    public String provaImpressao(){
        String retorno = "";
        retorno += "Questões Discursivas: \n";
        for (int i = 0; i < this.questaoDiscursiva.length; i++){
            retorno += i + this.questaoDiscursiva[i].retornaQuestao();
        }
        retorno += "-------------------------------------------\n";
        retorno += "Questões Objetivas: \n";
        for (int i = 0; i < this.questaoObjetiva.length; i++){
            retorno += i + this.questaoObjetiva[i].retornaQuestao();
        }
        retorno += "\n\n";
        return retorno;
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
