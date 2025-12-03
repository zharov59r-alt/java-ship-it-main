package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.Parcel;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.StandardParcel;

import static org.junit.jupiter.api.Assertions.*;

class ParcelBoxTest {

    @Test
    void addParcel() {
        ParcelBox<Parcel> standardParcelBox = new ParcelBox(100);
        standardParcelBox.addParcel(new StandardParcel("q", 50, "w", 1));

        assertEquals(1, standardParcelBox.getAllParcels().size());
    }

    @Test
    void addTwoParcel() {
        ParcelBox<Parcel> standardParcelBox = new ParcelBox(100);
        standardParcelBox.addParcel(new StandardParcel("q", 50, "w", 1));
        standardParcelBox.addParcel(new StandardParcel("q", 50, "w", 1));

        assertEquals(2, standardParcelBox.getAllParcels().size());
    }

    @Test
    void addParcelOverweight() {
        ParcelBox<Parcel> standardParcelBox = new ParcelBox(100);
        standardParcelBox.addParcel(new StandardParcel("q", 500, "w", 1));

        assertEquals(0, standardParcelBox.getAllParcels().size());
    }

}