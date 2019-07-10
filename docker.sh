#!/usr/bin/env bash

if [ "$1" = "start:test" ] ; then
    echo "开始打包......"
    ./mvnw clean package -U -DskipTests
    echo "打包完成"
    docker-compose build
    echo "镜像编译完成"
    echo "starting......"
    docker-compose up
elif [ "$1" = "start" ] ; then
    docker-compose up -d --build
elif [ "$1" = "build" ] ; then
    echo "开始打包......"
    ./mvnw clean package -U -DskipTests
    echo "打包完成"
    docker-compose build
elif [ "$1" = "stop" ] ; then
    echo "开始关闭服务服务......"
    docker-compose down
    echo "服务关闭成功"
elif [ "$1" = "clean" ] ; then
    echo "开始关闭服务服务......"
    docker-compose down
    echo "服务关闭成功"

elif [ "$1" = "restart" ] ; then
    echo "开始关闭服务服务......"
    docker-compose restart
    echo "服务重启成功"
else
  echo "仅支持 build/start/stop/restart/clean ，例如 sh docker.sh start"
fi
