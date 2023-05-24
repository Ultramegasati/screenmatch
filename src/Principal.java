import br.com.screenmatch.calculo.CalculadoraDeTempo;
import br.com.screenmatch.calculo.FiltroDeRecomendacao;
import br.com.screenmatch.modelos.Episodio;
import br.com.screenmatch.modelos.Filme;
import br.com.screenmatch.modelos.Serie;

public class Principal {
    public static void main(String[] args) {

        Filme filme = new Filme();

        filme.setNome("O poderoso chefao");
        filme.setAnoDeLancamento(1971);
        filme.setDuracaoEmMinutos(183);
        System.out.println("Duração do filme: " + filme.getDuracaoEmMinutos());

        filme.exibirFichaTenica();

        filme.avaliarNotas(6);
        filme.avaliarNotas(8);
        filme.avaliarNotas(10);


        System.out.println("Total de avaliações: " + filme.getTotalDeAvaliacoes());
        System.out.println("Média: " + filme.obterMedia());

        Serie serie = new Serie();
        serie.setNome("Lost");
        serie.setAnoDeLancamento(2000);
        serie.exibirFichaTenica();
        serie.setTemporadas(12);
        serie.setEpisodiosPorTemporada(9);
        serie.setMinutosPorEpisodio(50);
        System.out.println("Duração da serie: " + serie.getDuracaoEmMinutos());




        Filme outroFilme = new Filme();

        outroFilme.setNome("Avatar");
        outroFilme.setAnoDeLancamento(2023);
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








    }
}
