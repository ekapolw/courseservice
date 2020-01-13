#!/bin/sh

docker rmi $(docker images |grep 'ekapol/course-service')
docker rm $(docker stop $(docker ps -a -q --filter ancestor=ekapol/course-service --format="{{.ID}}"))
docker build . -t ekapol/course-service