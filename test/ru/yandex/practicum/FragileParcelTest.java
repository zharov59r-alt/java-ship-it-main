package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;

import static org.junit.jupiter.api.Assertions.*;

class FragileParcelTest {

    @Test
    void calculateDeliveryCost() {
        FragileParcel parcel = new FragileParcel("q", 2, "w", 1);
        assertEquals(8, parcel.calculateDeliveryCost());
    }
}