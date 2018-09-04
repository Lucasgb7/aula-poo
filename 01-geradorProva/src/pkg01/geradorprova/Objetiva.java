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
final class Objetiva extends Questao{
    private String[] opcao;
    private int respostaCorreta;
    
    public Objetiva (){
        this.opcao = new String[5];
    }
    public String retornaQuestao(){
        String retorno = ") " + this.getPergunta() + " (" + this.getPeso() + ") " + "\n";
        String[] opcao = this.getOpcao();
        for (int j = 0; j < this.getOpcao().length; j++) {
            retorno += "["+j+"]" + opcao[j] + "\n\n";
        }
//      retorno += "Resposta correta: " + this.getRespostaCorreta() + "\n";   
        return retorno;
    }

    /**
     * @return the opcao
     */
    public String[] getOpcao() {
        return opcao;
    }

    /**
     * @param opcao the opcao to set
     */
    public void setOpcao(String[] opcao) {
        this.opcao = opcao;
    }

    /**
     * @return the respostaCorreta
     */
    public int getRespostaCorreta() {
        return respostaCorreta;
    }

    /**
     * @param respostaCorreta the respostaCorreta to set
     */
    public void setRespostaCorreta(int respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }
}
