package com.testng.asm.entities;

public class ProductOrder {
    private String name;
    private String size;
    private String color;
    private int quantity;
    private String firstName;
    private String lastName;
    private String email;
    private String telephone;
    private String address1;
    private String city;
    private String postCode;
    private String region;

    public ProductOrder(String name, String size, String color, int quantity, String firstName, String lastName,
                        String email, String telephone, String address1, String city, String postCode, String region) {
        this.name = name;
        this.size = size;
        this.color = color;
        this.quantity = quantity;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
        this.address1 = address1;
        this.city = city;
        this.postCode = postCode;
        this.region = region;
    }

    public ProductOrder() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getVariableValueByIndex(int indexOfVariable) {
        switch (indexOfVariable) {
            case 0:
                return name;
            case 1:
                return size;
            case 2:
                return color;
            case 3:
                return Integer.toString(quantity);
            case 4:
                return firstName;
            case 5:
                return lastName;
            case 6:
                return email;
            case 7:
                return telephone;
            case 8:
                return address1;
            case 9:
                return city;
            case 10:
                return postCode;
            case 11:
                return region;
            default:
                return "";
        }
    }

    public static int getNumberOfVariables() {
        return 12;
    }
}
