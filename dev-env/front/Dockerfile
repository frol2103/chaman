FROM node:15.0-alpine

RUN apk update \
  && apk add --update alpine-sdk \
  && npm install -g @angular/cli@9.1.0 \
  && apk del alpine-sdk \
  && rm -rf /tmp/* /var/cache/apk/* *.tar.gz ~/.npm \
  && sed -i -e "s/bin\/ash/bin\/sh/" /etc/passwd
  

RUN mkdir -p /.npm && chmod -R a+rwx /.npm

expose 4200

workdir /src

