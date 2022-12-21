#!/bin/bash

service=$1
port=$2
./gradlew $service:quarkusBuild
sudo docker build -t $service -f modules/$service/Dockerfile .
sudo docker run -it -p $port:8080 $service

