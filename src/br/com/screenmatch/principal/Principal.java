package br.com.screenmatch.principal;

import br.com.screenmatch.calculo.CalculadoraDeTempo;
import br.com.screenmatch.calculo.FiltroDeRecomendacao;
import br.com.screenmatch.modelos.Episodio;
import br.com.screenmatch.modelos.Filme;
import br.com.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {

        Filme filme = new Filme("O poderoso chefão", 1971);

        //filme.setNome("O poderoso chefão");    sem o construtor
        //filme.setAnoDeLancamento(1971);   sem o construtor
        filme.setDuracaoEmMinutos(183);
        System.out.println("Duração do filme: " + filme.getDuracaoEmMinutos());

        filme.exibirFichaTenica();

        filme.avaliarNotas(6);
        filme.avaliarNotas(8);
        filme.avaliarNotas(10);


        System.out.println("Total de avaliações: " + filme.getTotalDeAvaliacoes());
        System.out.println("Média: " + filme.obterMedia());

        Serie serie = new Serie("Lost", 2000);
        //serie.setNome("Lost");   sem o construtor
        //serie.setAnoDeLancamento(2000);   sem o construtor
        serie.exibirFichaTenica();
        serie.setTemporadas(12);
        serie.setEpisodiosPorTemporada(9);
        serie.setMinutosPorEpisodio(50);
        System.out.println("Duração da serie: " + serie.getDuracaoEmMinutos());




        Filme outroFilme = new Filme("Avatar", 2023);

       // outroFilme.setNome("Avatar");     sem o construtor
        //outroFilme.setAnoDeLancamento(2023);    sem o construtor
        outroFilme.setDuracaoEmMinutos(200);

        CalculadoraDeTempo caluladora = new CalculadoraDeTempo();
        caluladora.incluir(filme);
        caluladora.incluir(outroFilme);
        caluladora.incluir(serie);
        System.out.println(caluladora.getTempoTotal());


        FiltroDeRecomendacao filtro = new FiltroDeRecomendacao();
        filtro.filtra(filme);


        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(serie);
        episodio.setTotalDeVisualizacoes(300);
        filtro.filtra(episodio);


        var filme1 = new Filme("Dogville", 2003);
        //filme1.setNome("Dogville");  sem o construtor
        //filme1.setAnoDeLancamento(2003);  sem o construtor
        filme1.setDuracaoEmMinutos(200);
        filme1.avaliarNotas(9);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filme);
        listaDeFilmes.add(outroFilme);
        listaDeFilmes.add(filme1);
        System.out.println("Tamanho da lista de filmes: " + listaDeFilmes.size());
        System.out.println("Primeiro filme: " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);
        System.out.println("toString primero fime: " + listaDeFilmes.get(0).getNome());

        System.out.println(filme1.toString());











    }
}
