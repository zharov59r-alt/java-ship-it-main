package ru.yandex.practicum.delivery;

//стандартная
public class StandardParcel extends Parcel {

    protected static final int STANDARD_PARCEL_PRICE = 2;

    public StandardParcel(String description,
                          int    weight,
                          String deliveryAddress,
                          int sendDay
    ) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    protected int getBaseCost() {
        return STANDARD_PARCEL_PRICE;
    }

}
