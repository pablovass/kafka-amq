package com.natural.repository;

import com.natural.model.Outage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OutageRepository  extends MongoRepository< Outage,String> {
}
