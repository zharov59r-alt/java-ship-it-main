package ru.yandex.practicum.delivery;

//стандартная
public class StandardParcel extends Parcel {

    public StandardParcel(String description,
                          double weight,
                          String deliveryAddress,
                          int sendDay
    ) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public double calculateDeliveryCost() {
        return STANDARD_PARCEL_PRICE * weight;
    }

}
