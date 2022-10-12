package com.natural.controller;

import com.natural.model.Alarm;
import com.natural.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class AlarmController {
    Alarm alarm;
    List<Alarm> alarms = new ArrayList<>();
    @Autowired
    private AlarmService alarmService;


    @GetMapping("/alarm")
    public ResponseEntity<List<Alarm>> listAlarm() {

        alarms = alarmService.listAllAlarm();

        return ResponseEntity.ok(alarms);
    }

    @GetMapping("/alarm/retCode")
    public ResponseEntity<List<Alarm>> getAlarmByRetCode(@RequestParam(name = "retCode", required = false) String retCode) {

        if (!retCode.equals(null)) {
            alarms = alarmService.listAllAlarm();
        }
        if (alarms.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            alarms = alarmService.getByRetCode(retCode);

        }
        return ResponseEntity.ok(alarms);
    }


    @RequestMapping("/alarm")
    ResponseEntity<Alarm> giveAlarm(@RequestBody Alarm alarm) {
        String bodySiteName = alarm.siteName;
        alarm = alarmService.getAlarmBySiteName(bodySiteName);
        if (null == alarm) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(alarm);
    }

    @PostMapping("/save")
    public ResponseEntity<Alarm> createAlarm(@Validated @RequestBody Alarm alarm) {
        Alarm AlarmCreated = alarmService.createAlarm(alarm);
        return ResponseEntity.status(HttpStatus.CREATED).body(AlarmCreated);
    }


}


