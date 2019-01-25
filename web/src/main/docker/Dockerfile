# Download base image
FROM openjdk:8-jre-alpine

# copy the only *jar file (fails in more than 1 source file)
COPY *.jar /build/app.jar

WORKDIR /build

# Define the ENV variable
ENV ENV_SPRING_PROFILE prod

EXPOSE 8080

# Set default script
ENTRYPOINT ["java", "-Xmx200m", "-Dspring.profiles.active=${ENV_SPRING_PROFILE}", "-jar", "app.jar"]

# Run default 'entrypoint'
CMD ["default"]
