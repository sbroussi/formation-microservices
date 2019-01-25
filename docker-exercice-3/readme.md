
# build image from Maven
cd eureka-registry
mvn clean install

# This will create this image:

$ docker images
REPOSITORY              TAG                 IMAGE ID            CREATED             SIZE
eureka-registry         latest              45c2a37d81b7        14 seconds ago      122 MB

# run
$ docker run -p 8761:8761 -d eureka-registry
a0fb9daae1c5cf210e2c86747a0eec120f26cb1ea9c56a66a138465e6ef3ef01


$ docker logs -f a0fb9daae1c5cf
2019-01-25 13:27:01.879  INFO 1 --- [      Thread-11] c.n.e.r.PeerAwareInstanceRegistryImpl    : Changing status to UP
2019-01-25 13:27:01.906  INFO 1 --- [      Thread-11] e.s.EurekaServerInitializerConfiguration : Started Eureka Server
2019-01-25 13:27:01.932  INFO 1 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8761 (http)
2019-01-25 13:27:01.932  INFO 1 --- [           main] .s.c.n.e.s.EurekaAutoServiceRegistration : Updating port to 8761
2019-01-25 13:27:01.961  INFO 1 --- [           main] l.i.e.EurekaServerApplication            : Started EurekaServerApplication in 9.21 seconds (JVM running for 9.911)



