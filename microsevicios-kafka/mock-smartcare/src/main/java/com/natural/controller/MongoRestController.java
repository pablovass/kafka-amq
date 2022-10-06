package com.natural.controller;

import com.natural.pojo.Alarm;
import com.natural.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v2")
public class MongoRestController {
    Alarm alarm;
    List<Alarm> alarms = new ArrayList<>();
    @Autowired
    private AlarmService alarmService;


    @GetMapping("/alarm")
    public ResponseEntity<List<Alarm>> listAlarm(@RequestParam(name = "returnCode", required = false) String returnCode) {

        if (!returnCode.equals(null)) {
            alarms = alarmService.listAllAlarm();
        }
        if (alarms.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            alarms = alarmService.getReturnCode(returnCode);

        }


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

    @GetMapping("/alarm/{retcode}/{siteName}")
    public ResponseEntity<List<Alarm>> getByRetCodeAndSiteName(@PathVariable(value = "retCode") String retCode,
                                                               @PathVariable(value = "siteName") String deparment) {
        alarms = alarmService.getByRetCodeAndSiteName(retCode, deparment);
        return ResponseEntity.ok(alarms);
    }

    @GetMapping("/alarm/{mSISDN}")
    public ResponseEntity<List<Alarm>> getByMSISDNIs(@PathVariable(value = "mSISDN") String mSISDN) {
        alarms = alarmService.getByMSISDNIs(mSISDN);
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



