package practice;

public class Name implements Cloneable {
    private String fName;
    private String lName;

    public Name() {
    }

    public Name(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Name clone() throws CloneNotSupportedException {
        return new Name(this.fName, this.lName);

    }
}
