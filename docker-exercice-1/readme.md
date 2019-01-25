
cd docker-exercice-1

# Dans le répertoire où se trouvent les fichiers, executer la commande suivante pour créer l’image

$ docker build -t heartbeat .

# Il est maintenant possible de créer un conteneur

$ docker run heartbeat

# Dans une autre console, exécuter la commande

$ docker ps
docker ps
CONTAINER ID        IMAGE               COMMAND             CREATED             STATUS              PORTS               NAMES
8dacf0302b8c        heartbeat           "./heartbeat.sh"    30 seconds ago      Up 29 seconds                           frosty_engelbart

$ docker stop 8dacf0302b8c


# Copier le CONTAINER ID du conteneur et exécuter la commande suivante

$ docker exec -it <CONTAINER ID> bash

