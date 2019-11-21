package com.tcs.trainingxi.models;

import com.tcs.trainingxi.models.builders.CredentialsBuilder;

public class Credentials {
    private String usserName;
    private String password;

    public Credentials(CredentialsBuilder credentialsBuilder) {
        this.usserName = credentialsBuilder.getCredentialsBuilders().get(0).getEmail();
        this.password = credentialsBuilder.getCredentialsBuilders().get(0).getPassword();
    }

    public String getUsserName() {
        return usserName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "usserName='" + usserName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
