package ru.yandex.practicum.delivery;

public abstract class Parcel {

    protected static final int STANDARD_PARCEL_PRICE = 2;
    protected static final int PERISHABLE_PARCEL_PRICE = 3;
    protected static final int FRAGILE_PARCEL_PRICE = 4;

    protected String  description;
    protected double  weight;
    protected String  deliveryAddress;
    protected int     sendDay;

    Parcel (String description,
            double weight,
            String deliveryAddress,
            int sendDay
            ) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;

    }

    public double getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }

    public void packageItem() {
        System.out.println("Посылка <<" + this.description + ">> упакована");
    }

    public void deliver() {
        System.out.println("Посылка <<" + this.description + ">> доставлена по адресу " + this.deliveryAddress);

    }

    public abstract double calculateDeliveryCost();

}
