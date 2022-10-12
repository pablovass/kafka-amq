package com.natural.service;

import com.natural.model.Outage;
import org.springframework.stereotype.Service;

@Service
public interface OutageService {
    public Outage createOutage(Outage outage);
}