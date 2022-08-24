public class Conteudo {
    //final é usado para mostrar que o valor é imutável
    private final String titulo; 
    private final String urlImagem;

    public Conteudo(String titulo, String urlImagem){
        this.titulo = titulo;
        this.urlImagem = urlImagem;
    }

    public String getTitutlo(){
        return titulo;
    }

    public String getUrlImagem(){
        return urlImagem;
    }

}
