package com.training.inno.ms.msorderreactive.integration;


public class CustomerRest {
    private String name;
    private String surname;
    private String username;
    private String password;
    private Integer height;
    private Integer weight;

    public String getName() {
        return name;
    }

    public void setName(String nameParam) {
        name = nameParam;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surnameParam) {
        surname = surnameParam;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String usernameParam) {
        username = usernameParam;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passwordParam) {
        password = passwordParam;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer heightParam) {
        height = heightParam;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weightParam) {
        weight = weightParam;
    }
}
