package com.tcs.trainingxi.models.enums;

public enum ManagementCSV {
    FILTRO("id");
    private String managementTypeData;

    private ManagementCSV(String managementTypeData) {
        this.setManagementTypeData(managementTypeData);
    }

    public String getManagementTypeData() {
        return managementTypeData;
    }

    private void setManagementTypeData(String managementTypeData) {
        this.managementTypeData = managementTypeData;
    }
}