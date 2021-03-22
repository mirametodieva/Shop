package Exception;

import java.util.Locale;
import java.util.Scanner;

public class Product {

    private String productName;
    private double price;
    private double quantity;
    private double weight;

 

    public Product(String productName, double price, double quantity, double weight) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.weight = weight;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    Scanner in = new Scanner(System.in).useLocale(Locale.ENGLISH);

    public void returnMoney(double price) {
        
        System.out.println("The price is: " + price);
        System.out.println("Your Money: ");

        double yourMoney = in.nextDouble();
        try {
            if (yourMoney <= 0) {
                throw new ArithmeticException();
            }
            double returnMoney = yourMoney - price;
            if (yourMoney > price) {

                System.out.printf("Your inreturn is : %.2f \n", returnMoney);
                System.out.println();
            } else {
                System.out.println("Not enough money!");
                System.out.printf("Please more money: %.2f \n", returnMoney * (-1));
                moreMoney(price, returnMoney);

            }
        } catch (ArithmeticException e) {
            System.out.println();
        }

    }

    public void moreMoney(double price, double returnMoney) {

        double InsMoney = in.nextDouble();
        try {
            if (InsMoney <= 0) {
                throw new ArithmeticException();
            }

            double MoneyMore = InsMoney - returnMoney * -1;

            if (InsMoney >= returnMoney * -1) {
                System.out.printf("Your inreturn is : %.2f  \n", MoneyMore);
                System.out.println();

            } else if (InsMoney < returnMoney * -1) {
                System.out.println("Not enough money! ");
                in.nextLine();
                System.out.printf("Please  more : %.2f  \n", MoneyMore * -1);
                moreMoney(returnMoney * -1, MoneyMore);
                if (InsMoney >= returnMoney * -1) {
                    System.out.printf("Your inreturn is : %.2f  \n", MoneyMore);
                    System.out.println();

                }

            }

        } catch (ArithmeticException e) {
            System.out.println("You can`t give this money!");
        }

    }
    
       public void quantityCheck(double quantity, double newQuantity){
           try{
               double check = quantity - newQuantity;
               if(check<0){
                   throw new QuantityyException();
               }
               else{
                   quantity = quantity - newQuantity;
               }
           }catch (QuantityyException e) {
            System.out.println(e.getMessage());

        }
       }
       
       public void sellChocolate( double newQuantity ){
        
        quantityCheck( this.getQuantity(), newQuantity);
        
        double newPrice = newQuantity *this.getPrice();
        returnMoney(newPrice);
        
        //quantity = newQuantity - quantity;
        
    }
       
}


    /* public void checkQuan(double quantity, boolean quantityCheck) {
        if (quantity < 0) {
            quantityCheck = false;
        }
    }

    public void quantityMinus(double quantity, boolean quantityCheck) {
        System.out.println("How much?");
        checkQuan(quantity, quantityCheck);
        if (quantityCheck == true) {

            double newQuantity = in.nextDouble();
            if (quantity >= newQuantity) {
                quantity = quantity - newQuantity;
            } else {
                System.out.println("Sorry, this product isn't available!");
            }
        } else {
            System.out.println("Sorry");
        }
    }*/

