FROM openjdk:8

WORKDIR /

COPY target/github-repos-1.0.0.jar /github-repos.jar

ENTRYPOINT ["java", "-jar", "github-repos.jar"]