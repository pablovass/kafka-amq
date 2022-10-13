package com.natural.service;

import com.natural.model.Alarm;
import com.natural.repository.AlarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AlarmServiceImpl implements AlarmService {
    @Autowired
    private AlarmRepository alarmRepository;


    @Override
    public List<Alarm> listAllAlarm() {
        return alarmRepository.findAll();
    }


    @Override
    public Alarm createAlarm(Alarm alarm) {
        return alarmRepository.save(alarm);
    }

    @Override
    public Alarm getAlarm(String id) {

        return alarmRepository.findById(id).orElse(null);
    }

    @Override
    public Alarm getAlarmBySiteName(String siteName) {
         return alarmRepository.findBySiteName(siteName);
    }

    @Override
    public List<Alarm> getReturnCode(String siteName) {
        return null;
    }

    @Override
    public List<Alarm> getByRetCode(String retCode) {
        return null;
    }

    @Override
    public List<Alarm> getByRetCodeAndSiteName(String retCode, String siteName) {
        return null;
    }

    @Override
    public List<Alarm> getByMSISDNIs(String mSISDN) {
        return alarmRepository.findByMSISDNIs(mSISDN);
    }


}
