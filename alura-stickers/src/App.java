import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        //Fazer conexão http e buscar os top 250 filmes
        //String url = "https://imdb-api.com/en/API/Top250Movies/k_vum6p3w7";
        //ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

        //String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
        //ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

        String url = "https://linguagens-api-rezende.herokuapp.com/linguagens";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoLinguagens();

        ClienteHttp http = new ClienteHttp();
        String json = http.buscaDados(url);
        
        //Exibir e manipular os dados
        List<Conteudo> conteudos = extrator.extraiConteudos(json);
        
        for(int i = 0; i < 3; i++){
            
            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitutlo() + ".png";

            var geradora = new GeradoraDeFigurinhas();
            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitutlo());
            System.out.println();
        }
        
    }
}
