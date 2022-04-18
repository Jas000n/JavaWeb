package entity;

public class Fact {
    private String fname;
    private int UID;
    private int status;

    public Fact(String fname, int UID, int status) {
        this.fname = fname;
        this.UID = UID;
        this.status = status;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
