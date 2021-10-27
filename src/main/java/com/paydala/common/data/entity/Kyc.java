package com.paydala.common.data.entity;

import javax.persistence.*;

@Table(name = "kyc")
@Entity
public class Kyc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "ssn_last_four")
    private Integer ssnLastFour;

    @Column(name = "qual_id")
    private Integer qualId;

    @Column(name = "qual_no", length = 20)
    private String qualNo;

    @Column(name = "issuing_state", length = 50)
    private String issuingState;

    public String getIssuingState() {
        return issuingState;
    }

    public void setIssuingState(String issuingState) {
        this.issuingState = issuingState;
    }

    public String getQualNo() {
        return qualNo;
    }

    public void setQualNo(String qualNo) {
        this.qualNo = qualNo;
    }

    public Integer getQualId() {
        return qualId;
    }

    public void setQualId(Integer qualId) {
        this.qualId = qualId;
    }

    public Integer getSsnLastFour() {
        return ssnLastFour;
    }

    public void setSsnLastFour(Integer ssnLastFour) {
        this.ssnLastFour = ssnLastFour;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}