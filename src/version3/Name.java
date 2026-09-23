package version3;

import java.util.Objects;

//for version 3 override equals, hashCode, and clone.

public class Name implements Cloneable {
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    public Name() {
        this.firstName = "";
        this.middleName = "";
        this.lastName = "";

    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.middleName = "";
        this.lastName = lastName;
    }


    public Name(String firstName, String middleName, String lastName, String suffix) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
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

    public String getSuffix() {
        return suffix;
    }
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getFullName() {
        return this.firstName + middleName + lastName + suffix ;
    }
    public void setFullName(String firstName, String middleName, String lastname, String suffix) {
         this.firstName = firstName;
         this.middleName = middleName;
         this.lastName = lastname;
         this.suffix = suffix;
    }

    public void displayName() {
        if (this.middleName == "") {
            System.out.println(
                    this.lastName + ", " + this.firstName
            );

        } else {
            System.out.println(
                    this.lastName + ", " + this.firstName + " " + this.middleName.charAt(0) + "."
            );
    }
    }




//for version 3 override equals, hashCode, and clone.

@Override
    public String toString() {
        return String.format("%s %s %s %s", firstName, middleName, lastName, suffix);
                
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
        if  ( this.firstName == other.firstName &&
             this.middleName == other.middleName &&
             this.lastName == other.lastName &&
             this.suffix == other.suffix 
                    //can implement full comparison later
            ) 
            {return true;}

        else return false;
    }

   @Override
   public int hashCode() {
       return Objects.hash(firstName, middleName, lastName, suffix);
   }

   
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