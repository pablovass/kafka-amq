package com.sacavix.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
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
