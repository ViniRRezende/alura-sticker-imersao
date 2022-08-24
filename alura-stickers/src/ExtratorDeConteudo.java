import java.util.List;

public interface ExtratorDeConteudo {//Estamos criando uma abstracao dos extratores
    
    public List<Conteudo> extraiConteudos(String json);

}
