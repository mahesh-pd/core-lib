package com.paydala.common.data.auth.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserPartnerId implements Serializable {
    @Column(name = "user_id")
    private String userId;

    @Column(name = "partner_id")
    private String partnerId;

    // default constructor

    public UserPartnerId(String userId, String partnerId) {
        this.userId = userId;
        this.partnerId = partnerId;
    }
}
