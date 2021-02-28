FROM adoptopenjdk/openjdk14:jre-14.0.2_12-alpine

# copy the packaged jar file into our docker image
COPY target/performance-0.0.*-SNAPSHOT.jar /performance.jar

# set the startup command to execute the jar
CMD ["java", "-jar", "/performance.jar"]
