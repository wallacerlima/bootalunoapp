FROM openjdk:8
ARG JAR_FILE=target/*.war
COPY ${JAR_FILE} app.war
EXPOSE 8181

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar app.war" ]

#ENTRYPOINT ["java","-jar","/app.jar"]
