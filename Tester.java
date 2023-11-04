//CIS 230, Dr. Peng, Spring 2023. Capstone project by Ryan Thornton main method.

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Tester {
    public static void main(String[] args){
        //Decimal format to keep print outs nice!
        DecimalFormat rounder = new DecimalFormat("##.##");
        int counter = 0;
        int remover = 0;
        String name = "";
        double price = 0;
        int units = 0;
        Scanner input = new Scanner(System.in);
        shoppingCart cart = new shoppingCart();

        //Just some variables to help with our while loops
        int check;
        boolean tOf = false;
        System.out.println("Welcome to your shopping cart! Please add items to the cart!");
        do{
            System.out.println("Please enter the product name: ");
            name = input.next();

            //Try catch statements to ensure the user follows the rules! (Enters right data type)
            System.out.println("Please enter the product description: ");
            input.nextLine();
            String description = input.nextLine();
            while(tOf == false){
                try{
                    System.out.println("Please enter the product price: ");
                    price = input.nextDouble();
                    tOf = true;
                }
                catch(InputMismatchException e){
                    System.out.println("Pleas enter a type of double!");
                    input.nextLine();
                }
            }
            while(tOf == true){
                try{
                    System.out.println("Please enter the number of units: ");
                    units = input.nextInt();
                    tOf = false;
                }
                catch(InputMismatchException e){
                    System.out.println("Please enter an int!");
                    input.nextLine();
                }
            }
            //Add the item to our cart!
            cart.addItem(name, description, price, units);
            check = 0;
            tOf = true;
            while(tOf == true){
                try{
                    System.out.println("You have entered " + cart.getNumItems() + " item(s)! would you like to add more? (1 for yes and any other integer for no)");
                    check = input.nextInt();
                    tOf = false;
                }
                catch(InputMismatchException e){
                    System.out.println("Please enter an Int!");
                    input.nextLine();
                }
            }
        }while((check == 1));

        //This summary helps remind the user what items were entered in what order so they can enter the index needed to remove the item
        System.out.println("Here is a quick summary of your cart!");
        for(String item : cart.getProductList()){
            System.out.println(counter + ": " + item);
            counter++;
        }

        //While loop to remove items and reduce price
        boolean anotherCheck = true;
        do{
            while(anotherCheck == true){
                try{
                    System.out.println("Would you like to remove any items from your cart? (1 for yes any other int for no)");
                    remover = input.nextInt();
                    anotherCheck = false;
                }
                catch(InputMismatchException e){
                    System.out.println("Pleas enter an int!");
                    input.nextLine();
                }
            }

            if(remover == 1){
                while(anotherCheck == false){
                    try{
                        System.out.println("Please enter the index of the item you would like to remove (hint:the index is the # before the item in your cart summary!)");
                    int removeMe = input.nextInt();
                    cart.removeItem(cart.getM_rgItems(), removeMe);
                    cart.reduceToatl(cart.getPrices(), removeMe);
                    anotherCheck = true;
                    }
                    catch(InputMismatchException e){
                        System.out.println("pleas enter an int!");
                        input.nextLine();
                    }
                }
            }
        }while(remover == 1);
        counter = 0;

        //Another summary, just to add some pinache!
        System.out.println("Here is a quick summary of your new cart!");
        for(String item : cart.getProductList()){
            System.out.println(item);
            counter++;
        }


        //The final print out with all info and the info
        for(shoppingCart.Item item : cart.getM_rgItems() ){
                System.out.println(item.toString());
        }
        System.out.println("Your total comes to: $" + Double.parseDouble(rounder.format(cart.getTotal())));


    }
    
}
