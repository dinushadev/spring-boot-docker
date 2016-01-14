# spring-boot-docker
Docker example for spring boot rest application with connection mysql DB. Please flow the flowing steps.

#Create a templet spring-boot project 
https://start.spring.io/

FROM java:8

RUN mkdir /opt/spring-boot-docker

ADD ./target/Spring-Boot-Docker-0.0.1-SNAPSHOT.jar  /opt/

EXPOSE 8080

CMD java -jar /opt/Spring-Boot-Docker-0.0.1-SNAPSHOT.jar 




 docker  build -t dinusha/spring-boot-docker .

docker run --name springdockerdb -e MYSQL_RANDOM_ROOT_PASSWORD=123 -d mysql


 docker ps

CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS               NAMES
5c3c91946db9        mysql               "/entrypoint.sh mysql"   37 seconds ago      Up 37 seconds       3306/tcp            springdockerdb


 docker run --name springdockerapp --link springdockerdb:mysqldb -p 8080:8080 -d dinusha/spring-boot-docker
 
 Make sure MySql connection host set as alias(mysqldb) of linked connection.  
in application.properties

 spring.datasource.url=jdbc:mysql://mysqldb/dockerdb

CONTAINER ID        IMAGE                        COMMAND                  CREATED             STATUS              PORTS                    NAMES
61391f19fa0b        dinusha/spring-boot-docker   "/bin/sh -c 'java -ja"   5 seconds ago       Up 4 seconds        0.0.0.0:8080->8080/tcp   springdockerapp
3f1e98958e07        mysql                        "/entrypoint.sh mysql"   About an hour ago   Up About an hour    3306/tcp                 springdockerdb


docker logs (-f) springdockerdb


login to contaner 
docker exec -it <contaner name> bash

