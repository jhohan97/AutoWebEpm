package com.tcs.trainingxi.models;

import com.tcs.trainingxi.models.builders.UserDataBuilder;

public class UserData {
    private String names;
    private String lastNames;
    private String adress;
    private String telephone;
    private String celNumber;

    public UserData(UserDataBuilder userDataBuilder) {

        this.lastNames = userDataBuilder.getUserDataBuilder().get(0).getLastNames();
        this.names = userDataBuilder.getUserDataBuilder().get(0).getNames();
        this.celNumber = userDataBuilder.getUserDataBuilder().get(0).getCelNumber();
        this.adress = userDataBuilder.getUserDataBuilder().get(0).getAdress();
        this.telephone = userDataBuilder.getUserDataBuilder().get(0).getTelephone();

    }

    public String getCelNumber() {
        return celNumber;
    }

    public String getLastNames() {
        return lastNames;
    }

    public String getNames() {
        return names;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAdress() {
        return adress;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "names='" + names + '\'' +
                ", lastNames='" + lastNames + '\'' +
                ", adress='" + adress + '\'' +
                ", telephone='" + telephone + '\'' +
                ", celNumber='" + celNumber + '\'' +
                '}';
    }
}