package ru.yandex.practicum.delivery;

//хрупкая
public class FragileParcel extends Parcel implements Trackable {

    protected String location;

    public FragileParcel(String description,
                         double weight,
                         String deliveryAddress,
                         int sendDay
    ) {
        super(description, weight, deliveryAddress, sendDay);
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка <<" + description + ">> обёрнута в защитную плёнку");
        super.packageItem();
    }

    @Override
    public double calculateDeliveryCost() {
        return FRAGILE_PARCEL_PRICE * weight;
    }

    public void reportStatus(String newLocation) {
        setLocation(newLocation);
        System.out.println("Хрупкая посылка <<" + description + ">> изменила местоположение на " + newLocation);
    };

}
