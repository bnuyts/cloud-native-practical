docker build -t shopping-list:0.0.1-SNAPSHOT .
docker run -p 8081:8080 shopping-list:0.0.1-SNAPSHOT

docker run -e POSTGRES_PASSWORD=mysecretpassword -p 5432:5432 -d postgres