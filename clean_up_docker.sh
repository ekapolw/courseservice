#!/bin/sh

docker rm $(docker stop $(docker ps -a -q --filter ancestor=ekapol/course-service --format="{{.ID}}"))
docker rmi $(docker images |grep 'ekapol/course-service')
docker build . -t ekapol/course-service