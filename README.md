to build image:
```
docker build -t citrine_challenge .
```
to run image (please make sure port 8080 is available):
```
docker run -p 8080:8080 citrine_challenge
```
example: go to the following link in the browser when image is running
```
http://localhost:8080/units/si?units=(degree/minute)
```
output:
```
{"unit_name":"(rad/s)","multiplication_factor":0.00029088820866572}
```