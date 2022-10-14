package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Drive");
    }

    @Override
    public void people(int passenger) {
        System.out.println(passenger);
    }

    @Override
    public int priceGas(int gas) {
        return gas * 53;
    }
}
