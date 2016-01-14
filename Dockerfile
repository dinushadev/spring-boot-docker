FROM java:8

RUN mkdir /opt/spring-boot-docker

ADD ./target/Spring-Boot-Docker-0.0.1-SNAPSHOT.jar /opt/spring-boot-docker/ 

EXPOSE 8080

CMD java -jar /opt/spring-boot-docker/Spring-Boot-Docker-0.0.1-SNAPSHOT.jar 


