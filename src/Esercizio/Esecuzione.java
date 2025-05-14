package Esercizio;

import java.time.LocalDate;
import java.util.List;

public class Esecuzione {
    public static void main(String[] args) {
        //Prodotti books
        Product book1 = new Product(766876L,"Il Muro","Books",19.99);
        Product book2 = new Product(3894579756L,"Non Luoghi","Books",9.56);
        Product book3 = new Product(47693L,"Storia Antica","Books",156.99);
        //Prodotti Baby
        Product baby1 = new Product(458937L,"Pannolini","Baby",14.99);
        Product baby2 = new Product(34563424L,"Talco","Baby",4.76);
        Product baby3 = new Product(234657L,"Latte in polvere","Baby",34.99);
        //Prodotti Boys
        Product boys1 = new Product(4356737L,"Manga","Boys",8.99);
        Product boys2 = new Product(23454657L,"Scarpe","Boys",158.67);
        Product boys3 = new Product(23452345L,"Moto","Boys",3750.00);


        //lista prodotti
        List<Product> prodotti= List.of(book1,book2,book3,baby1,book3);
        List<Product> prodotti2 = List.of(book3,baby2,boys2);
        List<Product> prodotti3 = List.of(baby3,baby2,book3,boys2);

        //Clienti
        Customer c1 = new Customer(23435L,"Naruto Uzumaki",4);
        Customer c2 = new Customer(768458L,"Sasuke Uchiha",1);
        Customer c3 = new Customer(436398L,"Sakura Haruno",3);

        //Ordini
        Order or1 = new Order(345456L, "Spedito",LocalDate.of(2020,5,12),LocalDate.of(2020,5,29),prodotti,c1);
        Order or2 = new Order(344567L,"In consegna",LocalDate.of(2020,2,10),LocalDate.of(2020,6,20),prodotti2,c3);
        Order or3 = new Order(976457L,"Consegnato",LocalDate.of(2020,4,1),LocalDate.of(2020,9,24),prodotti3,c2);

        //Lista ordini
        List<Order> ordiniGlobali = List.of(or1,or2,or3);

        //Esercizio 1
        System.out.println("Primo Esercizio :");
        prodotti.stream().filter(product -> product.getCategory().contains("Books")).filter(product -> product.getPrice()>100).forEach(System.out::println);
        System.out.println("---------------------------");

        //Esercizio 2
        System.out.println("Secondo Esercizio");
        ordiniGlobali.stream().flatMap(order -> order.getProducts().stream().filter(product -> product.getCategory().contains("Baby"))).forEach(System.out::println);

        //Esercizio 3
        System.out.println("Esercizio 3");
        prodotti3.stream().filter(product -> product.getCategory().contains("Boys")).map(product -> product.getPrice()).map(price -> price * 0.9).forEach(System.out::println);

        //Esercizio4
        System.out.println("Esercizio 4");
        ordiniGlobali.stream().map(order -> order.getCustomer().getTier()).filter(integer -> integer ==2).forEach(System.out::println);


    }
}
