package be.kdg.programming5.HotelManagement.domain;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public enum Gender {
    @Enumerated(EnumType.STRING)
    MALE,FEMALE,AGENDER
}
