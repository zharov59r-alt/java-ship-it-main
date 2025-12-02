package ru.yandex.practicum.delivery;

//скоропортящаяся
public class PerishableParcel extends Parcel {

    protected int timeToLive;

    public PerishableParcel(String description,
                            double weight,
                            String deliveryAddress,
                            int sendDay,
                            int timeToLive
    ) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(int currentDay) {
        return sendDay + timeToLive < currentDay;
    }

    @Override
    public double calculateDeliveryCost() {
        return PERISHABLE_PARCEL_PRICE * weight;
    }

}
