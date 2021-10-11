# mongo-spark-springboot
Example Project which uses spark mongo connector !

- Connects to Mongo DB
- Maps to JavaRDD/DataSet with Schema
- Execute Spark Sql
- Writes back to Mongo DB
- Uses Java 8 with Spring boot


- Build Project with 
``` mvn clean install ```

- Start spring boot application 
``` java -jar mongo-spark-project-0.0.1-SNAPSHOT.jar```



- ``` GET CALL -> localhost:8080/v1/mongo-spark/count : Count of collection count entries ```
- ``` GET CALL -> localhost:8080/v1/mongo-spark/save  : executes sql and write dataset to new collection ```


