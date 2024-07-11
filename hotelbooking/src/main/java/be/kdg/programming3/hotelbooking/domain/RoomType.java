package be.kdg.programming3.hotelbooking.domain;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public enum RoomType {
    @Enumerated(EnumType.STRING)
    SINGLE,DOUBLE,DELUXE,STUDIO //static final
}
