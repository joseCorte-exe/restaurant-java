package shared.seeders;

import app.models.client.Bill;
import app.models.client.Client;
import app.models.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Seeder {
    List<Product> products = new ArrayList<Product>();
    List<Client> clients = new ArrayList<>();
    private void productsSeeder() {
        StringBuilder specifications1 = new StringBuilder();
        specifications1.append("(Disponivel) O nhoque é um prato tradicional da culinária italiana, conhecido por sua textura macia e \n");
        specifications1.append("sabor reconfortante. Feito a partir de uma massa de batatas, farinha e ovos, o nhoque é \n");
        specifications1.append("cozido e servido com diversos molhos, como o clássico molho de tomate ou molho pesto. \n");
        specifications1.append("Sua forma característica, com pequenos pedaços arredondados, torna-o uma opção \n");
        specifications1.append("visualmente atraente. O nhoque é uma escolha popular para quem busca uma refeição \n");
        specifications1.append("deliciosa e satisfatória. ");
        products.add(new Product("Nhoque", 10, specifications1));

        StringBuilder specifications2 = new StringBuilder();
        specifications2.append("(Disponivel) O spaghetti é um prato icônico da cozinha italiana, apreciado em todo o mundo. Consiste \n");
        specifications2.append("em fios longos e finos de massa cozidos al dente, que são combinados com uma variedade \n");
        specifications2.append("de molhos saborosos. Seja com molho de tomate clássico, bolonhesa, carbonara ou pesto, o \n");
        specifications2.append("spaghetti oferece uma experiência culinária versátil e deliciosa. Sua textura leve e \n");
        specifications2.append("escorregadia faz com que cada garfada seja uma explosão de sabores, tornando-o uma \n");
        specifications2.append("escolha popular tanto para ocasiões especiais como para refeições do dia a dia. \n");
        products.add(new Product("Spaghetti", 20, specifications2));

        StringBuilder specifications3 = new StringBuilder();
        specifications3.append("(Disponivel) A carbonara é uma receita tradicional italiana que conquista paladares ao redor do mundo. \n");
        specifications3.append("Feita com uma combinação irresistível de massa, ovos, queijo parmesão, pancetta e ");
        specifications3.append("pimenta preta, esse prato possui um sabor rico e reconfortante. A cremosidade da mistura \n");
        specifications3.append("de ovos e queijo se une perfeitamente aos pedaços crocantes de pancetta, criando uma \n");
        specifications3.append("harmonia de texturas que surpreende a cada garfada. A carbonara é um clássico que \n");
        specifications3.append("encanta amantes da gastronomia e é uma ótima opção para os apreciadores de uma \n");
        specifications3.append("refeição reconfortante e saborosa.");
        products.add(new Product("Carbonara", 30, specifications3));

        StringBuilder specifications4 = new StringBuilder();
        specifications4.append("(Disponivel) O ravioli é um prato tradicional italiano que conquista o paladar de muitas pessoas ao redor \n");
        specifications4.append("do mundo. Feito com uma massa delicada e recheado com uma variedade de ingredientes, \n");
        specifications4.append("como queijo, carne, vegetais ou até mesmo frutos do mar, cada mordida revela uma \n");
        specifications4.append("explosão de sabores. Os pequenos quadrados de massa são cuidadosamente dobrados e \n");
        specifications4.append("selados, resultando em uma apresentação visualmente atraente. Servido com um molho \n");
        specifications4.append("rico e saboroso, o ravioli é uma escolha sofisticada e deliciosa para os amantes da culinária \n");
        specifications4.append("italiana. \n");
        products.add(new Product("Raviolli", 40, specifications4));
    }
    private void clientsSeeder() {
        clients.add(new Client("Client 1", new Bill(), 1));
        clients.add(new Client("Client 2", new Bill(), 2));
        clients.add(new Client("Client 3", new Bill(), 3));
    }
    public Seeder() {
        productsSeeder();
        clientsSeeder();
    }

    public List<Product> getProducts() {
        return products;
    }
    public List<Client> getClients() {
        return clients;
    }
}
