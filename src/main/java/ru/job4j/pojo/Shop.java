package ru.job4j.pojo;

public class Shop {
    public static int indexOfNull(Product[] products) {
        int count = -1;
        for (int i = 0; i < products.length; i++) {
            count++;
            if (products[i] == null) {
                return count;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Eggs", 19);

        for (Product prod : products) {
            if (prod != null) {
                System.out.println(prod.getName() + " " + prod.getCount());
            }
        }
    }
}