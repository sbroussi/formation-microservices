
============================== REGISTRY
# build image from Maven
cd eureka-registry
mvn clean install

# This will create this image:

$ docker images
REPOSITORY              TAG                 IMAGE ID            CREATED             SIZE
eureka-registry         latest              45c2a37d81b7        14 seconds ago      122 MB

# run
$ docker run --name gc-registry -p 8761:8761 -d eureka-registry
a0fb9daae1c5cf210e2c86747a0eec120f26cb1ea9c56a66a138465e6ef3ef01


$ docker logs -f a0fb9daae1c5cf
2019-01-25 13:27:01.879  INFO 1 --- [      Thread-11] c.n.e.r.PeerAwareInstanceRegistryImpl    : Changing status to UP
2019-01-25 13:27:01.906  INFO 1 --- [      Thread-11] e.s.EurekaServerInitializerConfiguration : Started Eureka Server
2019-01-25 13:27:01.932  INFO 1 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8761 (http)
2019-01-25 13:27:01.932  INFO 1 --- [           main] .s.c.n.e.s.EurekaAutoServiceRegistration : Updating port to 8761
2019-01-25 13:27:01.961  INFO 1 --- [           main] l.i.e.EurekaServerApplication            : Started EurekaServerApplication in 9.21 seconds (JVM running for 9.911)


# open browser UI
http://localhost:8761

============================== API

# build image from Maven
cd api
mvn clean install

# This will create this image:

$ docker images
REPOSITORY              TAG                 IMAGE ID            CREATED             SIZE
api                     1.0-SNAPSHOT        adb944472bf9        5 minutes ago       142 MB
api                     latest              adb944472bf9        5 minutes ago       142 MB

# run: 'link gc' va mapper des noms de hosts
# les noms sont dans la colonne de droite NAMES:
# - gc-registry
# - gc-mysql
$ docker ps
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS                    NAMES
a3a1a070d57d        eureka-registry     "java -jar app.jar..."   3 seconds ago       Up 2 seconds        0.0.0.0:8761->8761/tcp   gc-registry
2b50ca1b86a8        mysql:latest        "docker-entrypoint..."   About an hour ago   Up About an hour    3306/tcp                 gc-mysql

$ docker run -d --name gc-api -p 8080:8080  \
  -e ENV_SPRING_PROFILE=prod   \
  -e SPRING_DATASOURCE_PASSWORD=my-secret-pw   \
  -v /home/zzadmin/IdeaProjects/stef/pictures:/ENV_PICTURES_FOLDER   \
  --link gc-mysql:ENV_MYSQL_SERVER   \
  --link gc-registry:ENVEUREKASERVER \
  api

$ docker logs -f a0fb9daae1c5cf

# open browser UI
http://localhost:8080/api/clients
http://localhost:8080/swagger-ui.html

============================== WEB

# build image from Maven
cd web
mvn clean install

# This will create this image:

$ docker images
REPOSITORY              TAG                 IMAGE ID            CREATED             SIZE
web                     1.0-SNAPSHOT        25fad4e28049        10 seconds ago      127 MB
web                     latest              25fad4e28049        10 seconds ago      127 MB

# run: 'link gc' va mapper des noms de hosts
# les noms sont dans la colonne de droite NAMES:
# - gc-registry
$ docker ps
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS                    NAMES
a3a1a070d57d        eureka-registry     "java -jar app.jar..."   3 seconds ago       Up 2 seconds        0.0.0.0:8761->8761/tcp   gc-registry

$ docker run -d --name gc-web -p 8081:8080  \
  -e ENV_SPRING_PROFILE=prod   \
  --link gc-registry:ENVEUREKASERVER \
  web

$ docker logs -f a0fb9daae1c5cf

# open browser UI
http://localhost:8081/

