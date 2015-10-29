#!/bin/bash
# modify configure for preonline platform
# script will be execute only when the JENKINS job's name is preonline.xxx.deploy

cd $(dirname $0)
export BIN_DIR=$(pwd)
cd $BIN_DIR
cd ..
DEPLOY_DIR=`pwd`
MODULE_NAME=$(echo $DEPLOY_DIR | awk -F'/' '{print $NF}')
CONF_DIR=$DEPLOY_DIR/conf

sed -i 's/java_max_heap_size=.*/java_max_heap_size=256M/g' $BIN_DIR/java_env.sh
sed -i 's/java_initail_heap_size=.*/java_initail_heap_size=256M/g' $BIN_DIR/java_env.sh
sed -i 's/java_young_heap_size=.*/java_young_heap_size=128M/g' $BIN_DIR/java_env.sh

sed -i 's/<property name="thrift.server.nodename" value="dxs"/<property name="thrift.server.nodename" value="preonline\/dxs"/g' $CONF_DIR/server.cfg.xml
