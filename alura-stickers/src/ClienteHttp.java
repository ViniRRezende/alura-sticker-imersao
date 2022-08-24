import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClienteHttp {
    
    public String buscaDados(String url){
        
        try{
            URI endereco = URI.create(url);//podiamos usar o var //consome a url
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(endereco).GET().build();//get é a maneira de buscar dados de um servidor http
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            String body = response.body();//É o retorno que teremos da API
            return body;
        }catch(IOException | InterruptedException ex){
            throw new RuntimeException(ex);
        }


    }


}
