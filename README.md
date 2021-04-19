to build image:
```
docker build -t citrine_challenge .
```
to run image (please make sure port 8080 is available):
```
docker run -p 8080:8080 citrine_challenge
```
You should see a prompt:
```
Server will listen on /0.0.0.0:8080
```
when image is running, go to the following link in the browser 
```
http://localhost:8080/units/si?units=<UNIT STRING>
```
where `<UNIT STRING>` is a properly formatted unit string as defined in prompt.pdf.

For example:
```
http://localhost:8080/units/si?units=(degree/minute)
```
You should see the following output in the browser:
```
{"unit_name":"(rad/s)","multiplication_factor":0.00029088820866572}
```