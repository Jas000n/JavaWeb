package entity;

import dao.FactDao;

public class User {
    private int UID;
    private String password;
    private String address;
    private String phonenumber;
    private String actor;

    public User(int UID, String password, String address, String phonenumber, String actor) {
        this.UID = UID;
        this.password = password;
        this.address = address;
        this.phonenumber = phonenumber;
        this.actor = actor;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

}
