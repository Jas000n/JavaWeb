package entity;


import java.util.Date;

public class Rent {
    private int RID;
    private String fname;
    private int EID;
    private Date expiretime;

    public Rent(int RID, String fname, int EID, Date expiretime) {
        this.RID = RID;
        this.fname = fname;
        this.EID = EID;
        this.expiretime = expiretime;
    }

    public int getRID() {
        return RID;
    }

    public void setRID(int RID) {
        this.RID = RID;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public int getEID() {
        return EID;
    }

    public void setEID(int EID) {
        this.EID = EID;
    }

    public Date getExpiretime() {
        return expiretime;
    }

    public void setExpiretime(Date expiretime) {
        this.expiretime = expiretime;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "RID=" + RID +
                ", fname='" + fname + '\'' +
                ", EID=" + EID +
                ", expiretime=" + expiretime +
                '}';
    }
}
