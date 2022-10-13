package com.natural.client;

import com.natural.model.Alarm;
import com.natural.model.Outage;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@FeignClient(value = "alarm-service", url="http://localhost:9080/api/v1")
public interface OutageAlarm {

  @RequestMapping(value = "/alarms",method = RequestMethod.GET )
  public List<Alarm> listAlarm();

  @RequestMapping(value = "/alarm", method = RequestMethod.POST)
  public Alarm giveAlarm(@RequestBody Outage outage);
}
