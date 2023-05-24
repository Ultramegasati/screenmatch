package br.com.screenmatch.calculo;

import br.com.screenmatch.modelos.Titulo;

public class CalculadoraDeTempo {

    private int tempoTotal = 0;

    public int getTempoTotal() {
        return this.tempoTotal;
    }


//    public void incluir(Filme f){
//        this.tempoTotal += f.getDuracaoEmMinutos();
//    }
//
//    public void incluir(Serie s){
//        this.tempoTotal += s.getDuracaoEmMinutos();
//    }

    public void incluir(Titulo titulo){
        this.tempoTotal += titulo.getDuracaoEmMinutos();
    }
}
