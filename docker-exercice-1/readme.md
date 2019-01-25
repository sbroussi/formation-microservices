
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
$ docker ps
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
