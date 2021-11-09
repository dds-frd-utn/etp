package org.utn.frd.dds.etp.dto;

import com.fasterxml.jackson.annotation.*;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({ "uuid", "localDateTime" })
public class ResponseNewOrderDTO {

    private String uuid;

    private LocalDateTime localDateTime;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "ResponseNewOrderDTO{" +
                "uuid='" + uuid + '\'' +
                ", localDateTime=" + localDateTime +
                '}';
    }
}

