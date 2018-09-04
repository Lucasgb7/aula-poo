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
        String retorno = "";
        retorno += "Disciplina: " + this.getNomeDisciplina() + "\n";
        retorno += "Peso: " + this.getPeso() + "\n";
        retorno += "Local: " + this.getLocal() + "\n";
        retorno += "Data: " + this.getData() + "\n";
        return retorno;
    }
    public String imprimeProva(){
        String retorno = "";
        retorno += "Questões Discursivas: \n";
        for(int i = 0; i < this.questaoDiscursiva.length; i++){
            retorno += (i+1) + ") " + this.questaoDiscursiva[i].getPergunta() + 
                    " (" + this.questaoDiscursiva[i].getPeso() + ")" + "\n";
            retorno += "Critério de Avaliação: " + this.questaoDiscursiva[i].getCriteriosCorrecao() +
                    "\n\n";
        }
        retorno += "-------\n";
        retorno += "Questões Objetivas: \n";
        for(int i = 0; i < this.questaoObjetiva.length; i++){
            retorno += (i+1) + ") " + this.questaoObjetiva[i].getPergunta() +
                    " (" + this.questaoObjetiva[i].getPeso() + ") " + "\n";
            
            String[] opcao = this.questaoObjetiva[i].getOpcao();
            for (int j = 0; j < 5; j++) {
                retorno += "["+j+"]" + opcao[j] + "\n";
            }
            retorno += "Resposta correta: " + this.questaoObjetiva[i].getRespostaCorreta() + "\n";
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
