package be.kdg.programming3.hotelbooking.domain;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public enum Gender {
    @Enumerated(EnumType.STRING)
    MALE,FEMALE,AGENDER
}
