package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.StandardParcel;

import static org.junit.jupiter.api.Assertions.*;

class StandardParcelTest {

    @Test
    void calculateDeliveryCost() {
        StandardParcel parcel = new StandardParcel("q", 2, "w", 1);
        assertEquals(4, parcel.calculateDeliveryCost());
    }
}