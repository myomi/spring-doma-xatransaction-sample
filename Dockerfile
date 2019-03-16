FROM postgres:9.6
RUN localedef -i ja_JP -c -f UTF-8 -A /usr/share/locale/locale.alias ja_JP.UTF-8
ENV LANG ja_JP.UTF-8
COPY ./sql/*.sql /tmp/sql/
COPY ./create-db.sh /docker-entrypoint-initdb.d/
