package com.alfianyusufabdullah.preferencessingleton.Model;

/**
 * Created by jonesrandom on 1/23/18.
 *
 * @site www.androidexample.web.id
 * @github @alfianyusufabdullah
 */

public class User {

    private String name;
    private String email;
    private String address;
    private String phone;

    private User(Builder builder) {
        name = builder.name;
        email = builder.email;
        address = builder.address;
        phone = builder.phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public static class Builder {

        private String name;
        private String email;
        private String address;
        private String phone;

        public Builder() {
        }

        public Builder setName(String Name) {
            name = Name;
            return this;
        }

        public Builder setEmail(String Email) {
            email = Email;
            return this;
        }

        public Builder setAddress(String Address) {
            address = Address;
            return this;
        }

        public Builder setPhone(String Phone) {
            phone = Phone;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

}
