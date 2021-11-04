package org.utn.frd.dds.etp.dto;

import org.utn.frd.dds.etp.entity.Local;
import org.utn.frd.dds.etp.entity.User;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

public class RequestOrderDTO {

    private LocalDateTime localDateTime;

    private Local local;

    private User user;

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
        return "RequestOrderDTO{" +
                "localDateTime=" + localDateTime +
                ", local=" + local +
                ", user=" + user +
                '}';
    }
}
