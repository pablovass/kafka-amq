package com.natural.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
@Data

@Document(collection = "Outage")
public class Outage {
    @JsonProperty("RAT")
    public String rAT;
    @JsonProperty("QueryType")
    public String queryType;
    @JsonProperty("SiteCode")
    public String siteCode;
    @JsonProperty("CellName")
    public ArrayList<String> cellName;

    @JsonProperty("StartTime")
    public long startTime;
    public long endTime;
}
