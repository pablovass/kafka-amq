package com.natural.repository;

import com.natural.pojo.Alarm;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlarmRepository extends MongoRepository<Alarm, String> {

    Alarm findBySiteName(String siteName);

    List<Alarm> findByReturnCode(String returnCode);

    List<Alarm> findByRetCode(String retCode);

    List<Alarm> findByRetCodeAndSiteName(String retCode ,String siteName);

    //MSISDN
    List<Alarm>findByMSISDNIs(String mSISDN);
}