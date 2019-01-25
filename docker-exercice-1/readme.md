
cd docker-exercice-1

# Dans le répertoire où se trouvent les fichiers, executer la commande suivante pour créer l’image

$ docker build -t heartbeat .

# Il est maintenant possible de créer un conteneur

# par dêfaut, variable env. toutes les 5 secondes
$ docker run heartbeat
- 8dacf0302b8c - (09:44:20)
- 8dacf0302b8c - (09:44:25)
- 8dacf0302b8c - (09:44:30)
- 8dacf0302b8c - (09:44:35)

# on peut changer la variable env.
$ docker run -e HEARTBEATSTEP='2' heartbeat
- 099ea28563a5 - (09:51:10)
- 099ea28563a5 - (09:51:12)
- 099ea28563a5 - (09:51:14)

# Dans une autre console, exécuter la commande
$ docker ps -a
CONTAINER ID        IMAGE               COMMAND             CREATED              STATUS              PORTS               NAMES
099ea28563a5        heartbeat           "./heartbeat.sh"    About a minute ago   Up About a minute                       stoic_volhard

# Copier le CONTAINER ID du conteneur et exécuter la commande suivante

$ docker exec -it <CONTAINER ID> bash
$ docker exec -it 099ea28563a5 bash
root@099ea28563a5:/# ps -ef
UID         PID   PPID  C STIME TTY          TIME CMD
root          1      0  0 09:52 ?        00:00:00 /bin/bash ./heartbeat.sh
root         36      0  0 09:52 ?        00:00:00 bash
root         50      1  0 09:52 ?        00:00:00 sleep 2
root         51     36  0 09:52 ?        00:00:00 ps -ef

# to stop process
$ docker stop <CONTAINER ID>
$ docker stop 099ea28563a5

# delete all running containers (and wait 2 seconds)
docker stop --time 2 $(docker ps -q)

# delete all containers
docker rm -f $(docker ps -a -q)

# Size on disk after 20 runs...
$ du -hs /var/lib/docker/*
512K	/var/lib/docker/containers
472K	/var/lib/docker/image
44K	/var/lib/docker/network
90M	/var/lib/docker/overlay2
0	/var/lib/docker/plugins
0	/var/lib/docker/swarm
0	/var/lib/docker/tmp
0	/var/lib/docker/trust
24K	/var/lib/docker/volumes


# lauunch a 'detached' container
$ docker run -dt -e HEARTBEATSTEP='2' heartbeat
f15214aea533ee5dc2bb59d3069db530455df0df878eb00b1a1b799c17b9fd54
$ docker ps
CONTAINER ID        IMAGE               COMMAND                  CREATED              STATUS              PORTS               NAMES
f15214aea533        heartbeat           "./heartbeat.sh de..."   About a minute ago   Up About a minute                       elated_goodall
# tail -f du log console d'un process detached
$ docker logs -f f15214aea533
 default - f15214aea533 - (10:41:28)
 default - f15214aea533 - (10:41:30)
 default - f15214aea533 - (10:41:32)
