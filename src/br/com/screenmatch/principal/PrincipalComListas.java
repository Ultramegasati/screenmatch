package br.com.screenmatch.principal;

import br.com.screenmatch.modelos.Filme;
import br.com.screenmatch.modelos.Serie;
import br.com.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrincipalComListas {
    public static void main(String[] args) {

        Filme filme = new Filme("O poderoso chefão", 1971);
        filme.avaliarNotas(9);
        Filme outroFilme = new Filme("Avatar", 2023);
        outroFilme.avaliarNotas(7);
        var filme1 = new Filme("Dogville", 2003);
        filme1.avaliarNotas(10);
        Serie serie = new Serie("Lost", 2000);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filme);
        lista.add(outroFilme);
        lista.add(filme1);
        lista.add(serie);

        for (Titulo item : lista) {
            System.out.println(item.getNome());

//            Filme fFilme = (Filme) item;
//            System.out.println("Classificação " + fFilme.getClassificacao());

            if (item instanceof Filme fFilme && fFilme.getClassificacao() >= 2){
                //instanceof: se é do tipo Filme e já declarado a variável e se o fFilme for >= 5
                System.out.println("Classifcação: " + fFilme.getClassificacao());
            }

        }


        List<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("João");
        buscaPorArtista.add("Alberto");
        buscaPorArtista.add("Carlos");
        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);
        System.out.println("Depois da odenação: " + buscaPorArtista);


        Collections.sort(lista);//implementar Comparable a Titulo e reescrever método compareTo
        System.out.println(lista);

        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        //para cada Título comparar com ano de lançamento
        //comparando os títulos com ano de laçamento
        System.out.println("Ordenado por ano: " + lista);

    }
}
