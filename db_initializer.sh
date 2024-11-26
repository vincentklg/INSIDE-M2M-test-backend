#!/bin/bash

docker exec -i mysql-m2m mysql -u root --password=secret device_db < src/main/resources/sql/01-schema.sql
docker exec -i mysql-m2m mysql -u root --password=secret device_db < src/main/resources/sql/02-data.sql