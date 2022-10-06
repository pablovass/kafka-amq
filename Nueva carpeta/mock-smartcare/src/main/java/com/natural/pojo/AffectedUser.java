package com.natural.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AffectedUser {
    @JsonProperty("MSISDN")
    public String mSISDN;

    public AffectedUser(AffectedUser affectedUser) {
    }
    public AffectedUser() {
    }
    public AffectedUser(String mSISDN) {
        this.mSISDN = mSISDN;
    }

    public String getmSISDN() {
        return mSISDN;
    }

    public void setmSISDN(String mSISDN) {
        this.mSISDN = mSISDN;
    }

    @Override
    public String toString() {
        return "AffectedUser{" +
                "mSISDN='" + mSISDN + '\'' +
                '}';
    }
}
