package models;

public class Account {
    String accountName;
    String website;
    String type;
    String phone;
    String description;
    String industry;
    String employees;
    String billingStreet;
    String billingCity;
    String billingState;
    String billingZip;
    String billingCountry;
    String shippingStreet;
    String shippingCity;
    String shippingState;
    String shippingZip;
    String shippingCountry;

    private Account() {
        //private constructor
    }

    public static Builder newBuilder() {
        return new Account().new Builder();
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getEmployees() {
        return employees;
    }

    public void setEmployees(String employees) {
        this.employees = employees;
    }

    public String getBillingStreet() {
        return billingStreet;
    }

    public void setBillingStreet(String billingStreet) {
        this.billingStreet = billingStreet;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    public String getBillingZip() {
        return billingZip;
    }

    public void setBillingZip(String billingZip) {
        this.billingZip = billingZip;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    public String billingAddressConstructor() {
        return getBillingStreet() + "\n" + getBillingCity() + ", " + getBillingState() +
                " " + getBillingZip() + "\n" + getBillingCountry() + "\n";
    }

    public String getShippingStreet() {
        return shippingStreet;
    }

    public void setShippingStreet(String shippingStreet) {
        this.shippingStreet = shippingStreet;
    }

    public String getShippingCity() {
        return shippingCity;
    }

    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
    }

    public String getShippingState() {
        return shippingState;
    }

    public void setShippingState(String shippingState) {
        this.shippingState = shippingState;
    }

    public String getShippingZip() {
        return shippingZip;
    }

    public void setShippingZip(String shippingZip) {
        this.shippingZip = shippingZip;
    }

    public String getShippingCountry() {
        return shippingCountry;
    }

    public void setShippingCountry(String shippingCountry) {
        this.shippingCountry = shippingCountry;
    }

    public String shippingAddressConstructor() {
        return getShippingStreet() + "\n" + getShippingCity() + ", " + getShippingState() +
                " " + getShippingZip() + "\n" + getShippingCountry() + "\n";
    }

    public class Builder {

        private Builder() {
            // private constructor
        }

        public Builder setShippingStreet(String shippingStreet) {
            Account.this.shippingStreet = shippingStreet;
            return this;
        }

        public Builder setIndustry(String industry) {
            Account.this.industry = industry;
            return this;
        }

        public Builder setShippingCountry(String shippingCountry) {
            Account.this.shippingCountry = shippingCountry;
            return this;
        }

        public Builder setShippingZip(String shippingZip) {
            Account.this.shippingZip = shippingZip;
            return this;
        }

        public Builder setShippingState(String shippingState) {
            Account.this.shippingState = shippingState;
            return this;
        }

        public Builder setShippingCity(String shippingCity) {
            Account.this.shippingCity = shippingCity;
            return this;
        }

        public Builder setBillingCountry(String billingCountry) {
            Account.this.billingCountry = billingCountry;
            return this;
        }

        public Builder setBillingZip(String billingZip) {
            Account.this.billingZip = billingZip;
            return this;
        }

        public Builder setBillingState(String billingState) {
            Account.this.billingState = billingState;
            return this;
        }

        public Builder setBillingCity(String billingCity) {
            Account.this.billingCity = billingCity;
            return this;
        }

        public Builder setEmployees(String employees) {
            Account.this.employees = employees;
            return this;
        }

        public Builder setPhone(String phone) {
            Account.this.phone = phone;
            return this;
        }

        public Builder setAccountName(String accountName) {
            Account.this.accountName = accountName;
            return this;
        }

        public Builder setWebsite(String website) {
            Account.this.website = website;
            return this;
        }

        public Builder setType(String type) {
            Account.this.type = type;
            return this;
        }

        public Builder setDescription(String description) {
            Account.this.description = description;
            return this;
        }

        public Builder setBillingStreet(String billingStreet) {
            Account.this.billingStreet = billingStreet;
            return this;
        }

        public Account build() {
            return Account.this;
        }
    }
}