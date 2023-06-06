package br.com.screenmatch.modelos;

import br.com.screenmatch.modelos.excecao.ErroDeConversao;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo>{


//    @SerializedName("Title") // nome que esta vindo, esta usando record não necessita
    private String nome;
    //@SerializedName("Year") // nome que esta vindo, esta usando record não necessita
    private int anoDeLancamento;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();

        if (meuTituloOmdb.year().length() > 4){
            throw new ErroDeConversao("Não consegue converter ano, tem mais de 4 caracteres!");
        }


        this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0,2));//substring de onde começa/termina
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getTotalDeAvaliacoes(){
        return totalDeAvaliacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void exibirFichaTenica(){
        System.out.println("Nome do filme: " + nome + "\nAno de lançamento: " + anoDeLancamento);
    }

    public void avaliarNotas(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double obterMedia(){
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "Titulo(" +
                "nome = " + nome  +
                ", anoDeLancamento = " + anoDeLancamento +
                ", tempoDeDuração = " + duracaoEmMinutos + ")";
    }
}
