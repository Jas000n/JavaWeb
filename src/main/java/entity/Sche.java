package entity;

public class Sche {
    private int SID;
    private int OID;
    private int EID;
    private int efficiency;

    public Sche(int SID, int OID, int EID, int efficiency) {
        this.SID = SID;
        this.OID = OID;
        this.EID = EID;
        this.efficiency = efficiency;
    }

    public int getSID() {
        return SID;
    }

    public void setSID(int SID) {
        this.SID = SID;
    }

    public int getOID() {
        return OID;
    }

    public void setOID(int OID) {
        this.OID = OID;
    }

    public int getEID() {
        return EID;
    }

    public void setEID(int EID) {
        this.EID = EID;
    }

    public int getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(int efficiency) {
        this.efficiency = efficiency;
    }
}
