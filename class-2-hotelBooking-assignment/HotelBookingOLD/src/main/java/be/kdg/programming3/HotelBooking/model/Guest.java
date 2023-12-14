package be.kdg.programming3.HotelBooking.model;

import java.util.List;

public class Guest {

    private Integer guestId;
    private String guestFirstName;
    private String guestSecondName;//filter on this
    private String guestEmail;
    private String guestContactNumber;
    private Gender GuestGender;


    public Guest(Integer guestId, String guestFirstName, String guestSecondName, String guestEmail, String guestContactNumber, Gender guestGender) {
        this.guestId = guestId;
        this.guestFirstName = guestFirstName;
        this.guestSecondName = guestSecondName;
        this.guestEmail = guestEmail;
        this.guestContactNumber = guestContactNumber;
        GuestGender = guestGender;
    }

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }

    public String getGuestFirstName() {
        return guestFirstName;
    }

    public void setGuestFirstName(String guestFirstName) {
        this.guestFirstName = guestFirstName;
    }

    public String getGuestSecondName() {
        return guestSecondName;
    }

    public void setGuestSecondName(String guestSecondName) {
        this.guestSecondName = guestSecondName;
    }

    public String getGuestEmail() {
        return guestEmail;
    }

    public void setGuestEmail(String guestEmail) {
        this.guestEmail = guestEmail;
    }

    public String getGuestContactNumber() {
        return guestContactNumber;
    }

    public void setGuestContactNumber(String guestContactNumber) {
        this.guestContactNumber = guestContactNumber;
    }

    public void setGuestGender(Gender guestGender) {
        GuestGender = guestGender;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "guestId=" + guestId +
                ", guestFirstName='" + guestFirstName + '\'' +
                ", guestSecondName='" + guestSecondName + '\'' +
                ", guestEmail='" + guestEmail + '\'' +
                ", guestContactNumber='" + guestContactNumber + '\'' +
                ", GuestGender=" + GuestGender +
                '}';
    }
}
