import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {

    // Função para colocar os links de produtos da página-chave
    public static List<String> getProductLinks(String seedUrl) throws IOException {
        Document doc = Jsoup.connect(seedUrl).get();
        Elements links = doc.select("a[href]");
        List<String> productLinks = new ArrayList<>();
        for (Element link : links) {
            String href = link.attr("abs:href");
            if (href.matches("^https://www.drogaraia.com.br/.+\\.html$")) {
                productLinks.add(href);
            }
        }
        return productLinks;
    }

    // Puxar as informações de um produto
    public static String scrapeProductInfo(String productUrl) throws IOException {
        Document doc = Jsoup.connect(productUrl).get();
//        Elements elementsPage = doc.select("[data-testid='product-name']");
//        if (elementsPage != null) {
//            for (Element element: elementsPage){
//                System.out.println(element.text());
//            }
//        }
        String name = doc.selectFirst("[data-testid='product-name']").text().trim();
        String price = doc.selectFirst(".additional-info").text().trim();
        System.out.println(name + price);

        Pattern pattern = Pattern.compile("SKU=(\\d+)");
        Matcher matcher = pattern.matcher(productUrl);
        String sku = matcher.find() ? matcher.group(1) : "";
        return String.format("Nome=\"%s\" Preco=%s SKU=%s\n", price, name, sku);
    }

    public static void main(String[] args) throws IOException {
        // URL das páginas-chave
        String[] seedUrls = {
                "https://www.drogaraia.com.br/medicamentos.html",
                "https://www.drogaraia.com.br/beleza.html",
                "https://www.drogaraia.com.br/cabelo.html",
                "https://www.drogaraia.com.br/bem-estar.html",
                "https://www.drogaraia.com.br/mamae-e-bebe.html"
        };

        // Obter links de produtos
        List<String> productLinks = new ArrayList<>();
        for (String seedUrl : seedUrls) {
            productLinks.addAll(getProductLinks(seedUrl));
        }

        // Gravar os links de produtos em um arquivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("produtos.txt"))) {
            for (String link : productLinks) {
                writer.write(link + "\n");
            }
        }

        // Extrair informações de cada produto e exibir ou salvar em um arquivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("informacoes_produtos.txt"))) {
            for (String productUrl : productLinks) {
                String productInfo = scrapeProductInfo(productUrl);
                writer.write(productInfo);
            }
        }
    }
}