package Exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {

    static void checkAge(int age) throws ArithmeticException {
        if (age < 18 || age > 100) {
            throw new ArithmeticException();
        } else {
            System.out.println("You are old enough!");
        }
        /* throw new ArithmeticException("You must be at least 18 years old.");
        } else {
            System.out.println("You are old enough!");
        }*/
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        List<Product> products = new ArrayList<>();

        int i = 0;
        int age;
        boolean again = true;
        double money;
   
   //     products.add(new Product("hocolate", 1.80, 50, 0.1));
        products.add(new Product("Sweets", 1.6, 100, 0.2));
        products.add(new Product("Bread", 1, 26, 0.75));
        products.add(new Product("Alcohol", 30, 50, 1.25));
        products.add(new Product("Chocolate", 1.9, 80, 0.12));
        products.add(new Product("Fruits", 1.2, 40, 1));
        products.add(new Product("Vegetable", 3.6, 40, 1));

        while (again) {

            System.out.println("Hello! What do you want to buy?");
            for (Product p : products) {
                System.out.println(p.getProductName());
            }

            String myProduct = in.nextLine().toLowerCase();

            switch (myProduct) {
                /*case "chocolate":
                     System.out.println("How much?");
                     double newQuantity = in.nextDouble();
                     products.get(0).sellChocolate( newQuantity);
                     double calcQuantity = products.get(0).getQuantity() - newQuantity;
                     
                     products.get(0).setQuantity( calcQuantity );*/
                  
                case "sweets":
                   //products.get(0).quantityMinus(products.get(0).getQuantity(), products.get(0).getQuantityCheck());
                    products.get(0).returnMoney(products.get(0).getPrice());

                    System.out.println();
                    System.out.println();
                    in.nextLine();
                    break;

                case "bread":

                    products.get(1).returnMoney(products.get(1).getPrice());
                    System.out.println();
                    System.out.println();
                    in.nextLine();
                    break;

                case "alcohol":

                    System.out.println("How old are you?");
                    age = in.nextInt();
                    try {
                        checkAge(age);
                        products.get(2).returnMoney(products.get(2).getPrice());
                    } catch (ArithmeticException e) {
                        System.out.println("You must be at least 18 years old.");
                    }

                    in.nextLine();
                    System.out.println();
                    System.out.println();
                    in.nextLine();

                    break;

                case "chocolate":

                    products.get(3).returnMoney(products.get(3).getPrice());
                    System.out.println();
                    System.out.println();
                    in.nextLine();
                    break;

                case "fruits":

                    products.get(4).returnMoney(products.get(4).getPrice());
                    System.out.println();
                    System.out.println();
                    in.nextLine();
                    break;

                case "vegetable":

                    products.get(5).returnMoney(products.get(5).getPrice());
                    System.out.println();
                    System.out.println();
                    in.nextLine();
                    break;

                default:
                    System.out.println("Error!!!");
                    System.out.println("Do you want to continue? (0-Yes/ 1-No) ");
                    i = in.nextInt();
                    if (i == 1) {
                        again = false;
                    } else {
                        System.out.println("Shopping continue :)");
                    }
                    System.out.println();
                    System.out.println();
                    in.nextLine();
                    in.nextLine();
                    break;
            }
        }
    }
}

// product da e abstracten class i da go nasledqvat vsichki produkti(sweets, chocolate i tn.)
// da se razshirqt samite produkti - primer za chocolate(vid-bql,cheren,mlechen; kolko %; kolichestvo; proizvoditel)
// da se opravqt exception-ite (da ne sa aritmetic,a da se pishat v otdelni clasove)
// da se napravi taka, che da imame slujiteli i da gi naemame po tqhnoto CV i pokrivane na kriterii(po znaichitelnite da davat po 2tochki, a po-neznachitelnite po 1)
// da izkarvame balansa na denq, da zarejdame magazina
// da napravim API(ne znam kakvo e) za dostavchicite - da ima admin, user, password