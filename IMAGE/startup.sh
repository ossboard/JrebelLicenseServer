#!/bin/bash

export userid=$(whoami)
if [ ${userid} = 'root' ]
then
  echo "root 권한으로 실행할 수 없습니다"
  exit 0
fi

export T_USAGE="Usage: $0 {start | stop | restart | status | log | up | down | shell }"
export T_HOME=${PWD}
export C_NAME=5901-jrebel-lic

cd ${T_HOME}

fn_start() {
  docker-compose start
}

fn_stop() {
  docker-compose stop
}

fn_status() {
  docker-compose ps
}

fn_log() {
  docker-compose logs -f
}

fn_up() {
  docker-compose up -d
}

fn_down() {
  docker-compose down
}

fn_shell() {
  docker exec -it ${C_NAME} /bin/sh
}


case $1 in
  start) fn_start ;;
  stop) fn_stop ;;
  restart)
      fn_stop
      sleep 3
      fn_start ;;
  status) fn_status ;;
  log) fn_log ;;
  up) fn_up ;;
  down) fn_down ;;
  shell) fn_shell ;;
  *) echo ${T_USAGE} ;;
esac
exit 0
