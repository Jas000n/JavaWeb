package entity;

import java.util.Date;

public class Order {
    private int OID;
    private String status;
    private Date duetime;
    private int quantity;
    private int UID;
    private int PID;

    public Order(int OID, String status, Date duetime, int quantity, int UID, int PID) {
        this.OID = OID;
        this.status = status;
        this.duetime = duetime;
        this.quantity = quantity;
        this.UID = UID;
        this.PID = PID;
    }

    public int getOID() {
        return OID;
    }

    public void setOID(int OID) {
        this.OID = OID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDuetime() {
        return duetime;
    }

    public void setDuetime(Date duetime) {
        this.duetime = duetime;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }
}
