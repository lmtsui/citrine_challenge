to build:
```
docker build -t citrine_challenge .
```
to run:
```
docker run -p 8080:8080 citrine_challenge
```
example:
```
http://localhost:8080/units/si?units=(degree)
```
output:
```
{"unit_name":"(rad)","multiplication_factor":0.017453292519943}
```