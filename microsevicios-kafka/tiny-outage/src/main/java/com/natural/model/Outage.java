package com.natural.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;

@Data @ToString
public class Outage {

	private String id;
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
