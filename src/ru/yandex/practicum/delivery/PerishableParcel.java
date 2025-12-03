package ru.yandex.practicum.delivery;

//скоропортящаяся
public class PerishableParcel extends Parcel {

    protected static final int PERISHABLE_PARCEL_PRICE = 3;

    protected int timeToLive;

    public PerishableParcel(String  description,
                            int     weight,
                            String  deliveryAddress,
                            int     sendDay,
                            int     timeToLive
    ) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(int currentDay) {
        return sendDay + timeToLive < currentDay;
    }

    @Override
    protected int getBaseCost() {
        return PERISHABLE_PARCEL_PRICE;
    }

}
