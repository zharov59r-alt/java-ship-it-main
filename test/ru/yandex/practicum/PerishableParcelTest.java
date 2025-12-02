package ru.yandex.practicum;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.PerishableParcel;

import static org.junit.jupiter.api.Assertions.*;

class PerishableParcelTest {

    @Test
    void calculateDeliveryCost() {
        PerishableParcel parcel = new PerishableParcel("q", 2, "w", 1, 1);
        assertEquals(6, parcel.calculateDeliveryCost());
    }

    @Test
    void calculateDeliveryCostIsExpired() {
        PerishableParcel parcel = new PerishableParcel("q", 2, "w", 1, 5);
        assertTrue(parcel.isExpired(10));
    }

    @Test
    void calculateDeliveryCostIsNotExpired() {
        PerishableParcel parcel = new PerishableParcel("q", 2, "w", 1, 5);
        assertFalse(parcel.isExpired(3));
    }



}