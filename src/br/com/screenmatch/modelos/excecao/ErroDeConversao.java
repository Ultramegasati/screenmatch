package br.com.screenmatch.modelos.excecao;

public class ErroDeConversao extends RuntimeException {
    private String mensagem;
    public ErroDeConversao(String mensagem) {
        this.mensagem = mensagem;
    }
   @Override
    public String getMessage(){
        return this.mensagem;
   }
}
