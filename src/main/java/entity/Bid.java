package entity;

public class Bid {
    private int BID;
    private String fname;
    private int OID;
    private int status;
    private int price;
    
    public Bid(int BID, String fname, int OID, int status, int price) {
        this.BID = BID;
        this.fname = fname;
        this.OID = OID;
        this.status = status;
        this.price = price;
    }

    public int getBID() {
        return BID;
    }

    public void setBID(int BID) {
        this.BID = BID;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public int getOID() {
        return OID;
    }

    public void setOID(int OID) {
        this.OID = OID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
