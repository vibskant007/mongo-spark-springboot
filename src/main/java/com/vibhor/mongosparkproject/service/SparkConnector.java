package com.vibhor.mongosparkproject.service;

import com.mongodb.spark.MongoSpark;
import com.mongodb.spark.rdd.api.java.JavaMongoRDD;
import com.vibhor.mongosparkproject.config.Zip;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.spark.sql.Dataset;


import javax.annotation.PostConstruct;

@Service
public class SparkConnector {

    @Autowired
    JavaSparkContext javaSparkContext;

    @Autowired
    SparkSession sparkSession;

    private JavaMongoRDD<Document> documentJavaRDD;

    private Dataset<Zip> dataSet;

    @PostConstruct
    public void loadMongoCollection(){
        documentJavaRDD = MongoSpark.load(javaSparkContext);
        dataSet = documentJavaRDD.toDS(Zip.class);
        dataSet.createOrReplaceTempView("zipview");
    }

    public boolean executeSql() {
        Dataset<Row> sqlData = sparkSession.sql("select * from zipview where state='MA'");
        sqlData.show();
        MongoSpark.write(sqlData).option("collection", "MA").mode("overwrite").save();
        return true;
    }


    public long getCount(){
        return documentJavaRDD.count();
    }

}
