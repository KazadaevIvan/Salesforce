package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Contact {
    String salutation;
    String firstName;
    String middleName;
    String lastName;
    String suffix;
    String accountName;
    String title;
    String department;
    String email;
    String fax;
    String phone;
    String mobile;
    String mailingStreet;
    String mailingCity;
    String mailingState;
    String mailingZip;
    String mailingCountry;

    public String fullNameConstructor() {
        return getSalutation() + " " + getFirstName() + " " + getMiddleName() + " " + getLastName() + " " + getSuffix();
    }

    public String addressConstructor() {
        return getMailingStreet() + "\n" + getMailingCity() + ", " + getMailingState() +
                " " + getMailingZip() + "\n" + getMailingCountry() + "\n";
    }
}