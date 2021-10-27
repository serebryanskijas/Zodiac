package com.company;

import java.util.ArrayList;
import java.util.List;

public class Products {
    public static void main(String[] args) {
       /* Product product = new House();
        product = new Refrigerator();*/
        List<Product> products = new ArrayList<>();
        products.add(new House("BigHouse"));
        products.add(new Refrigerator("LG"));

        for (Product product : products)
            product.sell();
        for (Product product : products)
            try {
                System.out.println("Вес "+product.getName()+" составляет "+((Transportable) product).getWeight());
            }
        catch (Exception e){
            System.out.println("In list have not transportable product");
        }
    }

}

abstract class Product {
    protected String name;

    abstract public void sell();

    public String getName() {
        return name;
    }
}

interface Transportable {
    public int getWeight();
}

interface Sellable {
    public double getPrice();
}

class House extends Product implements Sellable {
    private double price = 100;

    public House(String name) {
        this.name = name;
    }

    @Override
    public void sell() {
        System.out.println("The house is sold for a price " + price);
    }

    @Override
    public double getPrice() {
        return price;
    }
}

class Refrigerator extends Product implements Transportable, Sellable {

    private double price = 10;
    private int weight = 20;

    public Refrigerator(String name) {
        this.name = name;
    }
        @Override
        public void sell () {
            System.out.println("The refrigerator is sold for a price " + price);
        }

        @Override
        public int getWeight () {
            return weight;
        }

        @Override
        public double getPrice () {
            return price;
        }
    }
