package com.vibhor.mongosparkproject.config;


import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {


    @Bean
    public SparkSession getSession() {
        return SparkSession.builder()
                .master("local[2]")
                .appName("MongoSparkConnectorIntro")
                .config("spark.mongodb.input.uri", "mongodb://127.0.0.1/test.zips")
                .config("spark.mongodb.output.uri", "mongodb://127.0.0.1/test.zips")
                .getOrCreate();

    }

    @Bean
    public JavaSparkContext getSparkContext() {
        return new JavaSparkContext(getSession().sparkContext());
    }


}
