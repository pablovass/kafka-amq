package com.natural.service;

import com.natural.pojo.Alarm;
import org.springframework.stereotype.Service;

import java.util.List;
;

@Service
public interface AlarmService {
    public List<Alarm> listAllAlarm();


    public Alarm createAlarm(Alarm alarm);


    Alarm getAlarm(String id);

    Alarm getAlarmBySiteName(String name);

    public List<Alarm> getReturnCode(String siteName);

    List<Alarm> getByRetCode(String retCode);

    List<Alarm> getByRetCodeAndSiteName(String retCode ,String siteName);
    List<Alarm>getByMSISDNIs(String mSISDN);
}

