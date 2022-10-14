package com.natural.controller;

import com.natural.client.OutageAlarm;
import com.natural.model.Alarm;
import com.natural.model.Outage;
import com.natural.service.KafkaProducerService;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Data
@RestController
@RequestMapping("api/v1")

public class OutageController {

    @Autowired
    private KafkaProducerService kafkaProducerService;
    private final OutageAlarm outageAlarm;
    List<Alarm> alarms = new ArrayList<>();
    Alarm alarm;

    @PostMapping("/alarm")
    ResponseEntity<Alarm> order(@RequestBody Outage outage) {
        kafkaProducerService.send(outage);
        alarm=outageAlarm.giveAlarm(outage);
        return ResponseEntity.ok(alarm);
    }

    @GetMapping("/alarm")
    public ResponseEntity<List<Alarm>> listAlarm() {
         alarms =  outageAlarm.listAlarm();
        return ResponseEntity.ok(alarms);
    }

}
