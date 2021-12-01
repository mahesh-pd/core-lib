package com.paydala.common.auth.pojos;

public class TokenDetails {

    private String sid;
    private String email;
    private String name;
    private String preferredUsername;

    public TokenDetails(String sid, String email, String name, String preferredUsername) {
        this.sid = sid;
        this.email = email;
        this.name = name;
        this.preferredUsername = preferredUsername;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreferredUsername() {
        return preferredUsername;
    }

    public void setPreferredUsername(String preferedUsername) {
        this.preferredUsername = preferedUsername;
    }
}
