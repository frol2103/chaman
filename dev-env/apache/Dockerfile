FROM httpd:2.4

RUN mkdir -p /usr/local/apache2/conf/sites/ /usr/local/apache2/htdocs/login
RUN echo 'IncludeOptional /conf/sites/*.conf' | tee -a /usr/local/apache2/conf/httpd.conf

COPY resources/chaman.conf /conf/sites/chaman.conf




