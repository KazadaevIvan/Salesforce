package models;

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

    private Contact() {
    }

    public static Contact.Builder newBuilder() {
        return new Contact().new Builder();
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
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

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMailingStreet() {
        return mailingStreet;
    }

    public void setMailingStreet(String mailingStreet) {
        this.mailingStreet = mailingStreet;
    }

    public String getMailingCity() {
        return mailingCity;
    }

    public void setMailingCity(String mailingCity) {
        this.mailingCity = mailingCity;
    }

    public String getMailingState() {
        return mailingState;
    }

    public void setMailingState(String mailingState) {
        this.mailingState = mailingState;
    }

    public String getMailingZip() {
        return mailingZip;
    }

    public void setMailingZip(String mailingZip) {
        this.mailingZip = mailingZip;
    }

    public String getMailingCountry() {
        return mailingCountry;
    }

    public void setMailingCountry(String mailingCountry) {
        this.mailingCountry = mailingCountry;
    }

    public class Builder {

        private Builder() {
            // private constructor
        }

        public Contact.Builder setMailingCountry(String mailingCountry) {
            Contact.this.mailingCountry = mailingCountry;
            return this;
        }

        public Contact.Builder setMailingZip(String mailingZip) {
            Contact.this.mailingZip = mailingZip;
            return this;
        }

        public Contact.Builder setMailingState(String mailingState) {
            Contact.this.mailingState = mailingState;
            return this;
        }

        public Contact.Builder setMailingCity(String mailingCity) {
            Contact.this.mailingCity = mailingCity;
            return this;
        }

        public Contact.Builder setFax(String fax) {
            Contact.this.fax = fax;
            return this;
        }

        public Contact.Builder setDepartment(String department) {
            Contact.this.department = department;
            return this;
        }

        public Contact.Builder setMobile(String mobile) {
            Contact.this.mobile = mobile;
            return this;
        }

        public Contact.Builder setPhone(String phone) {
            Contact.this.phone = phone;
            return this;
        }

        public Contact.Builder setEmail(String email) {
            Contact.this.email = email;
            return this;
        }

        public Contact.Builder setTitle(String title) {
            Contact.this.title = title;
            return this;
        }

        public Contact.Builder setAccountName(String accountName) {
            Contact.this.accountName = accountName;
            return this;
        }

        public Contact.Builder setSuffix(String suffix) {
            Contact.this.suffix = suffix;
            return this;
        }

        public Contact.Builder setLastName(String lastName) {
            Contact.this.lastName = lastName;
            return this;
        }

        public Contact.Builder setMiddleName(String middleName) {
            Contact.this.middleName = middleName;
            return this;
        }

        public Contact.Builder setFirstName(String firstName) {
            Contact.this.firstName = firstName;
            return this;
        }

        public Contact.Builder setMailingStreet(String mailingStreet) {
            Contact.this.mailingStreet = mailingStreet;
            return this;
        }

        public Contact.Builder setSalutation(String salutation) {
            Contact.this.salutation = salutation;
            return this;
        }

        public Contact build() {
            return Contact.this;
        }
    }
}