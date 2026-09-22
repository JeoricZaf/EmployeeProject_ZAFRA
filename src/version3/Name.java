package version3;

public class Name {
    private String firstName;
    private String middleName;
    private String lastName;

    public Name() {
        this.firstName = "N/A";
        this.middleName = "N/A";
        this.lastName = "N/A";
    }

    public Name(String firstName) {
        this.firstName = firstName;
        this.middleName = "";
        this.lastName = "";
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.middleName = "";
        this.lastName = lastName;
    }


    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setFullName(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public void display() {

        if (this.middleName == "") {
            System.out.println(this.lastName + ", " + this.firstName);
        } 
        else {
            System.out.println( this.lastName + ", " + this.firstName + " " + this.middleName.charAt(0) + ".");
        }
    }


    @Override
    public String toString() {
        return String.format("%s %s %s", this.firstName, this.middleName, this.lastName);
    }
}
