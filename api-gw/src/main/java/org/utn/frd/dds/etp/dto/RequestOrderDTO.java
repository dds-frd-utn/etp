package org.utn.frd.dds.etp.dto;

public class RequestOrderDTO {

    private String userUUID;

    public String getUserUUID() {
        return userUUID;
    }

    public void setUserUUID(String userUUID) {
        this.userUUID = userUUID;
    }

    @Override
    public String toString() {
        return "RequestOrderDTO{" +
                "userUUID='" + userUUID + '\'' +
                '}';
    }
}
