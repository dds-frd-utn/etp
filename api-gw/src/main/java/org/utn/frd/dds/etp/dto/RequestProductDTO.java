package org.utn.frd.dds.etp.dto;

public class RequestProductDTO {

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "RequestProductDTO{" +
                "code='" + code + '\'' +
                '}';
    }
}
