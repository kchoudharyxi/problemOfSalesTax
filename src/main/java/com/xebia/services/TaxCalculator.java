package com.xebia.services;

import com.xebia.models.Items;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaxCalculator {

    List<Items> list = new ArrayList<Items>();
    String name;
    Items items;
    int quantity = 0;
    double price = 0.0;
    int typesOfItems = 0;
    int checkImported = 0;
    double totalTax = 0.0;
    String message = "";

    public boolean readInput() {

        boolean inputStopFlag = true;

        while (inputStopFlag) {

            System.out.println("Please enter an item name:");
            Scanner scan = new Scanner(System.in);
            try {
                name = scan.next();
            } catch (Exception e) {
               e.printStackTrace();
            }

            System.out.println("Please enter the item quantity:");
            Scanner itemsQuantity = new Scanner(System.in);
            try {
                quantity = itemsQuantity.nextInt();
            } catch (Exception e) {
                System.out.println("Please enter a positive integer!");
                break;
            }

            System.out.println("Please enter the item price:");
            Scanner itemPrice = new Scanner(System.in);
            try {
                price = itemPrice.nextDouble();
            } catch (Exception e) {
                System.out.println(" Please enter the number!");
                break;
            }

            System.out.println("Please enter the types of items:- 1: book, 2: food, 3: Medical supplies, 4: other");
            Scanner types = new Scanner(System.in);
            try {
                typesOfItems = types.nextInt();
                if (typesOfItems > 4 || typesOfItems <1) {
                    System.out.println("Please enter the valid option");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter the number");
                break;
            }

            System.out.println("The item is imported or not:- 1: imported, 0: not imported");
            Scanner check = new Scanner(System.in);
            try {
                checkImported = check.nextInt();

                if (checkImported > 1 || checkImported <0) {
                    System.out.println("Please enter the valid option");
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            totalTax = this.computeTax();
            price = price * quantity;
            items = new Items(quantity, name, price);
            list.add(items);

            System.out.println("whether to continue to add more items:- 1: Yes, 2: No ");
            Scanner exit = new Scanner(System.in);
            int arg = exit.nextInt();
            if (arg > 2 || arg <1) {
                System.out.println("Please enter the valid option");
                break;
            }
            if (arg == 1)
                inputStopFlag = true;
            else
                break;
        }

     return true;
    }

    public double computeTax() {
        double taxForOtherItems = 0.0;
        double taxForImported  = 0.0 ;

        if (typesOfItems == 4) {
            double basicTax = 0.10;
            taxForOtherItems = this.price * basicTax * this.quantity;
        }

        if (checkImported == 1) {
            double importTax = 0.05;
            taxForImported = this.price * importTax * this.quantity;

        }
        return taxForOtherItems + taxForImported ;
    }


    public double computePrice() {
        double totalPrice = 0.0;
        for (Items aList : list) {
            Items items = (Items) aList;
            totalPrice = totalPrice + items.getPrice();

        }
        return totalPrice;
    }

    public String view() {
        for (Items aList : list) {
            Items items = (Items) aList;
            message = items.getQuantity() + " " + items.getName() + " : " + items.getPrice();
            System.out.println(message + "\n");
        }
        System.out.println("Sales Taxes: " + totalTax);
        System.out.println("Total: " + (computePrice()+totalTax));
    return message;
    }
}