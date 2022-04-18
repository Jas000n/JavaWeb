package entity;

public class Prod {
    private int PID;
    private String type;

    public Prod(int PID, String type) {
        this.PID = PID;
        this.type = type;
    }

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
