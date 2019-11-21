package com.tcs.trainingxi.models.builders;

import com.tcs.trainingxi.models.UserData;
import javafx.util.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDataBuilder  implements Builder<UserData> {

    private String names;
    private String lastNames;
    private String adress;
    private String telephone;
    private String celNumber;
    protected static UserData objUserDataBuilder;
    private List<UserDataBuilder> userDataBuilders = new ArrayList<>();


    public UserDataBuilder(Map<String,String> data) {
        this.names = data.get("names");
        this.lastNames = data.get("lastNames");
        this.adress = data.get("adress");
        this.telephone = data.get("telephone");
        this.celNumber = data.get("celNumber");
    }

    public static UserDataBuilder userDataInformation (List<Map<String, String>> userData){
        return new UserDataBuilder(userData);
    }

    public UserDataBuilder (List<Map<String, String>> data){
        createConstructor(data);
    }

    public String getNames() {
        return names;
    }

    public String getLastNames() {
        return lastNames;
    }

    public String getAdress() {
        return adress;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getCelNumber() {
        return celNumber;
    }

    private void createConstructor(List<Map<String, String>> data){
        for (Map<String,String> map:data) {
            userDataBuilders.add(new UserDataBuilder(map));
        }
    }

    public static void setUserData(UserData usersData){
        UserDataBuilder.objUserDataBuilder = usersData;
    }

    @Override
    public UserData build() {
        UserData usersData = new UserData(this);
        UserDataBuilder.setUserData(usersData);
        return usersData;
    }

    public List<UserDataBuilder> getUserDataBuilder(){
        return userDataBuilders;
    }
}
