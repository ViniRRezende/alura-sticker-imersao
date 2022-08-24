import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    
    void cria(InputStream inputStream, String nomeArquivo) throws IOException{

        //Leitura da img
        //InputStream inputStream = new FileInputStream(new File("entrada/Filme.jpg")); puxando figurinha pela diretório
        //InputStream inputStream = //puxa da internet/URL
        //                new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg")
        //                .openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        //Cria nova img em memória com transparência e tamanho novo
        int largura = imagemOriginal.getWidth();//pega largura orig
        int altura = imagemOriginal.getHeight();//pega altura orig
        int novaAltura = altura + 200;//cria nova imagem um pouco maior
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //Copiar a img original para a nova img (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        //Configurar a fonte
        Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.yellow);
        graphics.setFont(fonte);

        //Escrever uma frase na nova img
        graphics.drawString("TOPZERA", (largura/4)+"TOPZERA".length(), novaAltura - 100);

        //Escrever a nova img em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }
}
