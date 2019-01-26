
====================
====================
==================== Lancer un 'Cloud Native Edge Router' en docker: traefik
====================
====================

========================= traefik
https://traefik.io/
The Cloud Native Edge Router

A reverse proxy / load balancer that's easy, dynamic, automatic, fast,
full-featured, open source, production proven, provides metrics
and integrates with every major cluster technology...
No wonder it's so popular!


$ docker load -i '/formation/traefik.tar.gz'
4b0a2b20e92d: Loading layer [==================================================>]   278 kB/278 kB
ea514f8f0312: Loading layer [==================================================>] 52.08 MB/52.08 MB
Loaded image: traefik:latest




$ docker run -d -p 9080:8080 -p 80:80 -v /var/run/docker.sock:/var/run/docker.sock --name traefik  traefik --api --docker

Tester le fonctionnement de Traefik avec l’url

UI ADMIN:
http://localhost:9080
http://localhost:9080/dashboard/

Load balancer via point d'entrée qui est sur le port 80:
http://localhost:80/*
http://localhost/*

===== relancer le module WEB en passant par 'traefik'

avant:
======
$ docker run -d --name gc-web -p 8081:8080  \
  -e ENV_SPRING_PROFILE=prod   \
  --link gc-registry:ENVEUREKASERVER \
  web

  UI: http://localhost:8081/

apres:
======
$ docker run -it --name gc-web2 \
  -e ENV_SPRING_PROFILE=prod   \
  --link gc-registry:ENVEUREKASERVER \
  -l traefik.frontend.rule=PathPrefix:/ \
  web

 UI via 'traefik'
 UI: http://localhost/


