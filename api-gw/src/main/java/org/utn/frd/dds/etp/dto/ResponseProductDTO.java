package org.utn.frd.dds.etp.dto;

public class ResponseProductDTO {

    private String uuid;

    private String code;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ResponseProductDTO{" +
                "uuid='" + uuid + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
