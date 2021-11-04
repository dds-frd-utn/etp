package org.utn.frd.dds.etp.dto;

import org.utn.frd.dds.etp.entity.Local;
import org.utn.frd.dds.etp.entity.User;

import java.time.LocalDateTime;

public class ResponseOrderDTO {

    private String uuid;

    private LocalDateTime localDateTime;

    private Local local;

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

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
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
                ", local=" + local +
                ", user=" + user +
                '}';
    }
}
