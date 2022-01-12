package com.paydala.common.data.auth.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import java.io.Serializable;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Map;

@Table(name = "saved_pymt_source")
@Entity
@TypeDef(
        name = "json",
        typeClass = JsonBinaryType.class
)
public class SavedPymtSource implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "pymt_type")
    private Integer pymtType;

    @Lob
    @Column(name = "card_num", nullable = false)
    private String cardNum;

    @Column(name = "exp_date")
    private LocalDate expDate;

    @Column(name = "cvv")
    private Integer cvv;

    @Column(name = "zip_code", length = 10)
    private String zipCode;

    @Column(name = "preferred")
    private Integer preferred;

    @Type(type = "json")
    @Column(name = "metadata", columnDefinition = "json")
    private String metadata;

    public Integer getPreferred() {
        return preferred;
    }

    public void setPreferred(Integer preferred) {
        this.preferred = preferred;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public Integer getPymtType() {
        return pymtType;
    }

    public void setPymtType(Integer pymtType) {
        this.pymtType = pymtType;
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

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }
}