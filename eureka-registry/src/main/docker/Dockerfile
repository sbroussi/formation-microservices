# Download base image
FROM openjdk:8-jre-alpine

# copy the only *jar file (fails in more than 1 source file)
COPY *.jar /build/app.jar

WORKDIR /build

EXPOSE 8761

# Set default script
ENTRYPOINT ["java", "-jar", "app.jar", "-Xmx", "200m"]

# Run default 'entrypoint'
CMD ["default"]
