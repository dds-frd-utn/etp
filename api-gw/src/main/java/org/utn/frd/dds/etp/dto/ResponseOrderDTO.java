package org.utn.frd.dds.etp.dto;

import org.utn.frd.dds.etp.entity.User;

import java.time.LocalDateTime;

public class ResponseOrderDTO {

    private String uuid;

    private LocalDateTime localDateTime;

    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ResponseOrderDTO{" +
                "uuid='" + uuid + '\'' +
                ", localDateTime=" + localDateTime +
                ", user=" + user +
                '}';
    }
}
