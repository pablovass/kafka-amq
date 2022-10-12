package com.natural.client;

import com.natural.model.Alarm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="alarm-service", url="")
@RequestMapping("/api/v1")
public interface OutageAlarm {
    @RequestMapping("/alarm")
    ResponseEntity<Alarm> giveAlarm(@RequestBody Alarm alarm);
}
