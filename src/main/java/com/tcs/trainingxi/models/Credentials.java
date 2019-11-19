package com.tcs.trainingxi.models;

public class Credentials {
    private String usserName;
    private String password;

    public Credentials(String usserName, String password) {
        this.usserName = usserName;
        this.password = password;
    }

    public String getUsserName() {
        return usserName;
    }

    public void setUsserName(String usserName) {
        this.usserName = usserName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "usserName='" + usserName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
