docker run --name some-mongo -p 27017:27017 -d mongo:5.0.3

curl http://192.168.1.22:8080/day/

curl -i -X POST -H "accept: text/plain" -H "Content-Type: application/json" -d "{\"date\":\"2021-11-18\",\"startAm\":\"09:00\",\"startPm\":\"17:00\",\"notes\":\"asfdasfd\"}" http://192.168.1.22:8080/day/