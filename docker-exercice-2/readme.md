
cd docker-exercice-2


[zzadmin@vdluuxtst05 docker]$ docker load -i '/formation/tp-rul-mysql.tar.gz'
2f71b45e4e25: Loading layer [==================================================>]   131 MB/131 MB
b9251eda2725: Loading layer [==================================================>] 344.6 kB/344.6 kB
2830e43bb292: Loading layer [==================================================>] 4.322 MB/4.322 MB
e11922f9eb52: Loading layer [==================================================>] 1.536 kB/1.536 kB
81b027c57df4: Loading layer [==================================================>] 33.83 MB/33.83 MB
454bc9d5e761: Loading layer [==================================================>] 25.09 kB/25.09 kB
2a38a8bfc4ea: Loading layer [==================================================>] 3.584 kB/3.584 kB
8b556b9fcced: Loading layer [==================================================>] 222.3 MB/222.3 MB
e6814f2c816d: Loading layer [==================================================>] 4.096 kB/4.096 kB
4070d7e42759: Loading layer [==================================================>] 6.656 kB/6.656 kB
8cbbd930eccd: Loading layer [==================================================>] 1.536 kB/1.536 kB
Loaded image: mysql:latest
4fe15f8d0ae6: Loading layer [==================================================>] 5.046 MB/5.046 MB
880da5e0fb56: Loading layer [==================================================>] 19.52 MB/19.52 MB
afe07151202d: Loading layer [==================================================>] 24.58 kB/24.58 kB
278d3855ff30: Loading layer [==================================================>] 36.79 MB/36.79 MB
770d30a4404b: Loading layer [==================================================>] 4.096 kB/4.096 kB
03f525e0ee30: Loading layer [==================================================>]  2.56 kB/2.56 kB
Loaded image: phpmyadmin/phpmyadmin:latest



# Start a mysql server instance; create DB  (-d detached)
$ docker run --name gc-mysql -d -e MYSQL_ROOT_PASSWORD=my-secret-pw -e MYSQL_DATABASE=gestionclient mysql:latest

# on voit le port 3306
$ docker ps
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS               NAMES
71e7f6d96ed0        mysql:latest        "docker-entrypoint..."   10 seconds ago      Up 9 seconds        3306/tcp            gc-mysql

# check that the DB is started: run command line : "mysql -pmy-secret-pw"
$ docker exec -it gc-mysql mysql -pmy-secret-pw
mysql: [Warning] Using a password on the command line interface can be insecure.
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 2
Server version: 5.7.14 MySQL Community Server (GPL)

Copyright (c) 2000, 2016, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| gestionclient      |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
5 rows in set (0.00 sec)

mysql> exit
Bye



-------------------------- visualisation docker-engine: portainer

[zzadmin@vdluuxtst05 docker]$ docker load -i '/formation/portainer.tar.gz'
dd4969f97241: Loading layer [==================================================>]   278 kB/278 kB
6f02e36bdb71: Loading layer [==================================================>]    72 MB/72 MB
Loaded image: portainer/portainer:latest

# allow read file: /var/run/docker.sock
$ sudo chmod o+r /var/run/docker.sock
$ ls -la /var/run/docker.sock
srw-rw-r--. 1 root dockerroot 0 Jan 24 16:56 /var/run/docker.sock

# run with mapping: volume and port
$ docker run -d -p 9000:9000 -v /var/run/docker.sock:/var/run/docker.sock portainer/portainer [--no-auth]

# open browser UI > Local > ignore docker.sock message > click on Connect
http://localhost:9000

