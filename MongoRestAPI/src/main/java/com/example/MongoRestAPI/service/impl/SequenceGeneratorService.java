package com.example.MongoRestAPI.service.impl;

import com.example.MongoRestAPI.models.EmployeeSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class SequenceGeneratorService {
//    private MongoOperations mongoOperations;

    @Autowired
     MongoOperations mongoOperations;
//    public SequenceGeneratorService(MongoOperations mongoOperations){
//        this.mongoOperations = mongoOperations;
//    }

    public int generateSequence(String seqName){
        EmployeeSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                EmployeeSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() :1;
    }
}
