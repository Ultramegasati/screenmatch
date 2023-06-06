package br.com.screenmatch.principal;

import br.com.screenmatch.modelos.Titulo;
import br.com.screenmatch.modelos.TituloOmdb;
import br.com.screenmatch.modelos.excecao.ErroDeConversao;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner teclado = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()  //para formatar o json,fica mais fácil leitura
                .create();


        while(!busca.equalsIgnoreCase("sair")) {

            System.out.println("Digite filme para buscar");
             busca = teclado.nextLine();


             if (busca.equalsIgnoreCase("sair")){
                 break;
             }


            String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=cfee3793"; //replace substituir antigo/novo

            try {

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();


                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());


                String json = response.body();
                System.out.println(json);


                //Gson gson = new Gson();
                // Titulo meuTituloOmdb = gson.fromJson(json, Titulo.class);




                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(meuTituloOmdb);


                //try {
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println("Título convertido");
                System.out.println(meuTitulo);

// criar arquivo txt
//                FileWriter escrita = new FileWriter("filmes.txt");
//                escrita.write(meuTitulo.toString());
//                escrita.close();


                titulos.add(meuTitulo);

            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro!!!");
                System.out.println(e.getMessage());

            } catch (IllegalArgumentException e) {
                System.out.println("Erro no argumento!!!!");
                System.out.println(e.getMessage());

            } catch (ErroDeConversao e) {
                System.out.println(e.getMessage());

            } finally {
                System.out.println("Finalizado corretamente!");
            }


        }
        System.out.println(titulos);

        //criando json da busca
        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();

    }
}
