package com.vibhor.mongosparkproject;

import com.vibhor.mongosparkproject.service.SparkConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/mongo-spark")
public class MongoController {

    @Autowired
    SparkConnector sparkConnector;


    @GetMapping("/count")
    public ResponseEntity<Long> getCollectionCount() {
        return ResponseEntity.ok(sparkConnector.getCount());
    }

    @GetMapping("/save")
    public boolean writeCsv() {
        return sparkConnector.executeSql();
    }

}
