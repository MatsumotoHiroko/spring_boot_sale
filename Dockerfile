FROM openjdk:8-alpine

# Required for starting application up.
RUN apk update && apk add bash

RUN mkdir -p /opt/app
ENV PROJECT_HOME /opt/app

COPY build/libs/salesapp.jar $PROJECT_HOME/salesapp.jar

WORKDIR $PROJECT_HOME

CMD ["java", "-Dspring.data.mongodb.uri=mongodb://springboot-mongo:27017/salesapp","-Djava.security.egd=file:/dev/./urandom","-jar","./salesapp.jar"]
