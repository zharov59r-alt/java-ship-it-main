package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {

    public List<T> parcels = new ArrayList<>();
    protected double  weight;

    public ParcelBox(double weight) {
        this.weight = weight;
    }

    private double getCurrentWeight() {
        double sum = 0;
        for (Parcel parcel: parcels) {
            sum += parcel.calculateDeliveryCost();
        }
        return sum;
    }

    public void addParcel(T parcel) {
        if (getCurrentWeight() + parcel.getWeight() <= weight) {
            parcels.add(parcel);
        } else {
            System.out.println("Превышен допустимый вес коробки");
        }
    }

    public void getAllParcels() {
        for (Parcel parcel: parcels) {
            System.out.println(parcel.getDescription());
        }

    }

}
