#!/bin/bash

set -ue
set -o pipefail

DIR=$(cd $(dirname $0) && pwd)

INFO_COLOR='\033[0;33m'
ERROR_COLOR='\033[0;3om'
NC='\033[0m' # No Color

info(){
  echo -e ${INFO_COLOR}$@${NC}
}

error(){
  >&2 echo -e ${ERROR_COLOR}$@${NC}
}

IMAGE_PREFIX=$1
IMAGE_TAG=$2

info build with image prefix $IMAGE_PREFIX and tag $IMAGE_PREFIX


info build back
docker-compose -f $DIR/../dev-env/docker-compose.yml run --rm back "clean; dist"

rm -rf $DIR/tmp || echo ""
mkdir -p $DIR/tmp
unzip $DIR/../back/target/universal/back-*.zip -d $DIR/tmp
mv $DIR/tmp/back-* $DIR/tmp/back
cp $DIR/Dockerfile.back $DIR/tmp/Dockerfile
docker build -t $IMAGE_PREFIX/back$IMAGE_TAG $DIR/tmp



info build front

docker-compose -f $DIR/../dev-env/docker-compose.yml run --rm front ng build --prod
rm -rf $DIR/tmp || echo ""
mv $DIR/../front/dist $DIR/tmp/
cp $DIR/Dockerfile.front $DIR/tmp/Dockerfile
docker build -t $IMAGE_PREFIX/front$IMAGE_TAG $DIR/tmp
