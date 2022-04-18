package entity;

public class Equi {
    private int EID;
    private int runstatus;
    private int rentstatus;
    private String type;

    public Equi(int EID, int runstatus, int rentstatus, String type) {
        this.EID = EID;
        this.runstatus = runstatus;
        this.rentstatus = rentstatus;
        this.type = type;
    }

    public int getEID() {
        return EID;
    }

    public void setEID(int EID) {
        this.EID = EID;
    }

    public int getRunstatus() {
        return runstatus;
    }

    public void setRunstatus(int runstatus) {
        this.runstatus = runstatus;
    }

    public int getRentstatus() {
        return rentstatus;
    }

    public void setRentstatus(int rentstatus) {
        this.rentstatus = rentstatus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
