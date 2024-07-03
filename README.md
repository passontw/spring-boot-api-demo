# Springboot api demo

## Build Docker image

```
$ docker build -t springboot-restful-webservices .
```

## Run Mysql Database

```
$ docker pull mysql
$ docker network create springboot-mysql-net
$ docker run --name mysqldb --network springboot-mysql-net -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=userDb -d mysql
```

## Run springboot web service with docker 

```
$ docker run --network springboot-mysql-net --name springboot-mysql-container -p 8100:8100 springboot-restful-webservices
```

## 補充資料

執行Docker 實確定  `application.properties` 的設定為 **spring.profiles.active=docker**

[Kafka docker cluster](https://medium.com/@erkndmrl/kafka-cluster-with-docker-compose-5864d50f677e)
