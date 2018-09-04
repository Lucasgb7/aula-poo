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
final class Discursiva extends Questao {
    private String criteriosCorrecao;
    
    public Discursiva(){
    }
    public String retornaQuestao(){
        String retorno = ") " + this.getPergunta() + " (" + this.getPeso() + ")" + "\n";
        retorno += "Critério de Avaliação: " + this.getCriteriosCorrecao() +
                    "\n\n";
        return retorno;
    }
    /**
     * @return the criteriosCorrecao
     */
    public String getCriteriosCorrecao() {
        return criteriosCorrecao;
    }

    /**
     * @param criteriosCorrecao the criteriosCorrecao to set
     */
    public void setCriteriosCorrecao(String criteriosCorrecao) {
        this.criteriosCorrecao = criteriosCorrecao;
    }
}
