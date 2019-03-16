#!/bin/bash

tmp=/tmp/sql
PGPASSWORD=postgres

psql -d postgres -U postgres -f $tmp/01.create_user.sql
psql -d postgres -U postgres -f $tmp/02.create_database.sql
psql -d parent -U db_user -f $tmp/03.create_table_parent.sql
psql -d child1 -U db_user -f $tmp/04.create_table_children.sql
psql -d child2 -U db_user -f $tmp/04.create_table_children.sql
psql -d parent -U db_user -f $tmp/05.insert_data_common.sql
psql -d child1 -U db_user -f $tmp/05.insert_data_common.sql
psql -d child2 -U db_user -f $tmp/05.insert_data_common.sql
psql -d parent -U db_user -f $tmp/06.insert_data_parent.sql