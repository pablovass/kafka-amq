package com.natural.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.UUID;
@Data @Builder @AllArgsConstructor
@Document(collection = "contract-outage")
public class ContractOutage {
    @Id
    private UUID id;
    @JsonProperty("SiteName")
    public String siteName;
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
