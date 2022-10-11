package com.natural.service;

import com.natural.model.Outage;
import com.natural.repository.OutageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class  OutageServiceImpl implements OutageService {

    @Autowired
    OutageRepository outageRepository;

    @Override
    public Outage createOutage(Outage outage) {
        return outageRepository.save(outage);
    }
}
