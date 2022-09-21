FROM adoptopenjdk/openjdk11:latest
VOLUME /tmp
COPY target/startpoint-*.jar app.jar
ENTRYPOINT ["java","-agentlib:jdwp=transport=dt_socket,address=*:5005,server=y,suspend=n","-Djava.security.egd=file:/dev/./urandom","-jar","/api.jar"]