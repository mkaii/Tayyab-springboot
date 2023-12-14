package be.kdg.programming3.hotelbooking.domain;

public class Guest {

    private Integer guestId;
    private String guestFirstName;
    private String guestLastName;//filter on this
    private String guestEmail;
    private String guestContactNumber;
    private Gender GuestGender;


    public Guest(Integer guestId, String guestFirstName, String guestLastName, String guestEmail, String guestContactNumber, Gender guestGender) {
        this.guestId = guestId;
        this.guestFirstName = guestFirstName;
        this.guestLastName = guestLastName;
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

    public Gender getGuestGender() {
        return GuestGender;
    }

    public void setGuestFirstName(String guestFirstName) {
        this.guestFirstName = guestFirstName;
    }

    public String getGuestLastName() {
        return guestLastName;
    }

    public void setguestLastName(String guestLastName) {
        this.guestLastName = guestLastName;
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
        return guestFirstName+ " "+ guestLastName+ " - Email: "+guestEmail+" can be reached on: "+guestContactNumber;
    }
}
