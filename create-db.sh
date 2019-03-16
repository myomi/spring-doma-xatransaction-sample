#!/bin/bash

userName=postgres
databaseName=qms_common
tmp=/tmp/sql
PGPASSWORD=postgres

psql -d postgres -U postgres -f $tmp/1_create-db.sql
psql -d $databaseName -U $userName -f $address/2_create-table.sql
psql -d $databaseName -U $userName -f $address/3_insert-data.sql
psql -d $databaseName -U $userName -f $address/4_create-user.sql