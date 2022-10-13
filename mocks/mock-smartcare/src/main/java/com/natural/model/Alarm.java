package com.natural.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
@Data
@AllArgsConstructor
@Builder
@Document(collection = "Alarm")
public class Alarm implements Serializable {
    @JsonProperty("SiteName")
    public String siteName;
    @JsonProperty("ReturnCode")
    public String returnCode;
    @JsonProperty("ErrorMsg")
    public String errorMsg;
    public String retCode;
    public String retMsg;
    public String retData;
    @JsonProperty("Affected User")
    public ArrayList<AffectedUser> affectedUser;
    @JsonProperty("MSISDN")
    public String mSISDN;

    public Alarm(Alarm alarm) {
    }

    public Alarm() {
    }




    public Alarm createResponse(Alarm alarm) {
        Alarm alarmDB = new Alarm(alarm);
        return alarmDB;
    }
}
