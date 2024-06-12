FROM openjdk:17
LABEL maintainer="com.csi"
ADD target/dockerappexample-0.0.1-SNAPSHOT.jar dockerappexample.jar
ENTRYPOINT ["java", "-jar", "dockerappexample.jar"]