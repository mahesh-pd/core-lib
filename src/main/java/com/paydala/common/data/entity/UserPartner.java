package com.paydala.common.data.entity;

import javax.persistence.*;

@Table(name = "user_partner")
@Entity
public class UserPartner {

    @EmbeddedId
    private UserPartnerId userPartnerId;

    public UserPartnerId getUserPartnerId() {
        return userPartnerId;
    }

    public void setUserPartnerId(UserPartnerId userPartnerId) {
        this.userPartnerId = userPartnerId;
    }

}