package com.tcs.trainingxi.models.builders;

import com.tcs.trainingxi.models.Credentials;
import javafx.util.Builder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CredentialsBuilder implements Builder<Credentials> {

    private String email;
    private String password;
    protected static Credentials objCredentials;
    private List<CredentialsBuilder> credentialsBuilders = new ArrayList<>();

    public CredentialsBuilder(Map<String,String> data) {
        this.email = data.get("email");
        this.password = data.get("password");
    }

    public static CredentialsBuilder credentialInformation (List<Map<String, String>> credentialsData){
        return new CredentialsBuilder(credentialsData);
    }

    public CredentialsBuilder (List<Map<String, String>> data){
        createConstructor(data);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    private void createConstructor(List<Map<String, String>> data){
        for (Map<String,String> map:data) {
            credentialsBuilders.add(new CredentialsBuilder(map));
        }
    }

    public static void setCredentials(Credentials credentials){
        CredentialsBuilder.objCredentials= credentials;
    }

    @Override
    public Credentials build() {
        Credentials credentials = new Credentials(this);
        CredentialsBuilder.setCredentials(credentials);
        return credentials;
    }

    public List<CredentialsBuilder> getCredentialsBuilders(){
        return credentialsBuilders;
    }
}