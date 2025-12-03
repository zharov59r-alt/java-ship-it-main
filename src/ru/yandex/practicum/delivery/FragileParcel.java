package ru.yandex.practicum.delivery;

//хрупкая
public class FragileParcel extends Parcel implements Trackable {

    protected static final int FRAGILE_PARCEL_PRICE = 4;

    public FragileParcel(String description,
                         int weight,
                         String deliveryAddress,
                         int sendDay
    ) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка <<" + description + ">> обёрнута в защитную плёнку");
        super.packageItem();
    }

    @Override
    protected int getBaseCost() {
        return FRAGILE_PARCEL_PRICE;
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка <<" + description + ">> изменила местоположение на " + newLocation);
    };

}
