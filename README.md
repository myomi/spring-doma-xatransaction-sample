## start db
```
docker-compose up -d --build
```

## start ap
```
gradlew bootRun
```

## stop db
```
docker-compose donw -v
```

## show db log
```
docker logs -f testdb
```

## terminal 
```
docker exec -it testdb bash
```