package be.kdg.programming3.hotelbooking.dto;

import be.kdg.programming3.hotelbooking.domain.Guest;

public record GuestDto(
        int guestId,
        String guestLastName
) {
    //converting a domain entity to web DTO

    public static GuestDto fromDomain(Guest guest)
    {
        return new GuestDto(
                guest.getGuestId(),
                guest.getGuestLastName()
        );
    }
}
