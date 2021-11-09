package org.utn.frd.dds.etp.dto;

public enum ResponseMessage {

    ENTITY_EXITS("1", "Entidad existente"),
    ENTITY_NOT_EXISTS("2", "Entidad no existente"),
    ENTITY_DELETE("3", "Entidad eliminada");

    private String code;

    private String description;

    ResponseMessage(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
