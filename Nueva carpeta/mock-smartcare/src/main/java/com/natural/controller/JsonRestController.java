package com.natural.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.natural.pojo.ContractOutage;
import com.natural.pojo.Alarm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class JsonRestController {
    Path pathOK = Paths.get("../mock-smartcare/src/main/resources/response-ok.json");
    Path pathError = Paths.get("../mock-smartcare/src/main/resources/response-error.json");
    Alarm alarm = new Alarm();

    public Alarm getResponse(Path path) {

        try {
            ObjectMapper cm = new ObjectMapper();
            alarm = cm.readValue(new File(path.toUri()), Alarm.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return alarm;
    }



    @GetMapping("/alarm")
    public ResponseEntity<Alarm> getResponse() {
        Alarm alarmJson = getResponse(pathOK);
        return ResponseEntity.ok(alarmJson);
    }

    @RequestMapping("/alarm")
    ResponseEntity<Alarm> getRequest(@RequestBody ContractOutage contractOutage) {
        String bodySiteName = contractOutage.siteName;

       if (bodySiteName.equals("A39-A550"))
       {
           Alarm alarmJson = getResponse(pathError);
           return ResponseEntity.ok(alarmJson);
       }else {
           Alarm alarmJson = getResponse(pathOK);
           return ResponseEntity.ok(alarmJson);
       }

    }


}
