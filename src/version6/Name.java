package version6;

import java.util.Objects;

public final class Name implements Cloneable {
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    public Name() {
        this.firstName = "N/A";
        this.middleName = "N/A";
        this.lastName = "N/A";
        this.suffix = "N/A";

    }

    public Name(String firstName, String lastName) {
        validateRequired(firstName, lastName);
        this.firstName = firstName;
        this.middleName = "";
        this.lastName = lastName;
        this.suffix = "N/A";
    }

    public Name(String firstName, String middleName, String lastName, String suffix) {
        validateRequired(firstName, lastName);
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
    }

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {validateRequired(firstName, lastName); this.firstName = firstName;}

    public String getMiddleName() {return middleName;}
    public void setMiddleName(String middleName) {this.middleName = middleName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {validateRequired(firstName, lastName); this.lastName = lastName;}

    public String getSuffix() {return suffix;}
    public void setSuffix(String suffix) {this.suffix = suffix;}

    public String getFullName() {return String.format("%s %s %s %s", firstName, middleName, lastName, suffix );}
    public void setFullName(String firstName, String middleName, String lastname, String suffix) {
            validateRequired(firstName, lastname);
         this.firstName = firstName;
         this.middleName = middleName;
         this.lastName = lastname;
         this.suffix = suffix;
    }

    public void displayName() {
        System.out.println(this);
    }

    private boolean theres_no(String private_var) {return private_var == null || private_var.isEmpty();}

    private void validateRequired(String firstName, String lastName) {
        if (firstName == null || lastName == null || firstName.trim().isEmpty() || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Name fields cannot be empty");
        }
    }

@Override
    public String toString() {
        String middleInitial = theres_no(middleName) ? "" : " " + middleName.charAt(0) + ".";
        String nameSuffix = theres_no(suffix) || "N/A".equals(suffix) ? "" : " " + suffix;
        return String.format("%s, %s%s%s", lastName, firstName, middleInitial, nameSuffix);
    }

    @Override
    public boolean equals(Object preTest) {
        if (this == preTest) return true;

        // Null & Type check: Guard against null and ensure exact class match
        else if (preTest == null || getClass() != preTest.getClass()) {
            return false;
        }

        // 4. Typecast the object after successful type check
        Name other = (Name) preTest;

        // 5. Compare other fields
           if  ( Objects.equals(this.firstName, other.firstName) &&
               Objects.equals(this.middleName, other.middleName) &&
               Objects.equals(this.lastName, other.lastName) &&
               Objects.equals(this.suffix, other.suffix)
                    //can implement full comparison later
            )
            {return true;}

        else return false;
    }

   @Override
   public int hashCode() {return Objects.hash(firstName, middleName, lastName, suffix);}

   @Override
   public Name clone() {
       try {
            return (Name) super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
   }

}
