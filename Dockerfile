FROM amazoncorretto:8
MAINTAINER saiifly
COPY target/saiifly-0.0.1-SNAPSHOT.jar saiifly-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/saiifly-0.0.1-SNAPSHOT.jar"]