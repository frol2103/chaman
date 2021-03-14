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

info generage backend
rm -rf $DIR/../back/modules/generated
docker run --rm -u $(id -u) -w /local -v "$DIR/../:/local" openapitools/openapi-generator-cli generate \
    -i api.yaml \
    -g scala-play-server \
    -o back/modules/generated \
    -c openapi/back/config.yaml


info generage front
rm -rf $DIR/../front/modules/generated/api
docker run --rm -u $(id -u) -w /local -v "$DIR/../:/local" openapitools/openapi-generator-cli generate \
    -i api.yaml \
    -g typescript-angular \
    -o front/src/generated/api \
    -c openapi/front/config.yaml

sed -i 's/value?: object;/value?: any;/g' $DIR/../front/src/generated/api/model/field.ts

