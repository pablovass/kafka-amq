package com.natural.repository;

import com.natural.model.Alarm;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AlarmRepository extends MongoRepository<Alarm, String> {
    Alarm findBySiteName(String siteName);

    List<Alarm> findByReturnCode(String returnCode);

    List<Alarm> findByRetCode(String retCode);

    List<Alarm> findByRetCodeAndSiteName(String retCode ,String siteName);

    //MSISDN
    List<Alarm>findByMSISDNIs(String mSISDN);
}
