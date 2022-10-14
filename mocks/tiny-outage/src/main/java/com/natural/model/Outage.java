package com.natural.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.natural.client.OutageAlarm;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.beans.Transient;
import java.io.Serializable;
import java.util.ArrayList;

@Data
public class Outage implements Serializable {


	@JsonProperty("RAT")
	public String rAT;
	@JsonProperty("QueryType")
	public String queryType;
	@JsonProperty("SiteCode")
	public String siteCode;
	@JsonProperty("SiteName")
	public String siteName;
	@JsonProperty("CellName")
	public ArrayList<String> cellName;

	@JsonProperty("StartTime")
	public long startTime;
	public long endTime;


	//private Alarm alarm;

//	private AffectedUser affectedUser;

}
