# Jrebel & Jet Brains License Server for Java

A license server for Jrebel & JetBrains products, it also support JRebel for Android and XRebel.

***

NOTE: This is provided for educational purposes only. Please support genuine.
***
## Setup

Packing a runnable jar:
```
./gradlew shadowJar
```
then
```
java -jar JrebelBrainsLicenseServerforJava-1.0-SNAPSHOT-all.jar -p 8080
```
default port is 8081.

Or use gradle
```
./gradlew shadowJar
java -jar JrebelBrainsLicenseServerforJava-1.0-SNAPSHOT-all.jar -p 8080
```

## Docker
Build image
```
./gradlew shadowJar 
docker build -t jrebel-lic:1.0 .

```

start container
```
cd IMAGE
sh startup.sh up
또는
docker run -d --name 5901-jrebel-lic --restart always -e PORT=5901 -p 5901:8080 jrebel-lic:1.0
삭제
docker stop 5901-jrebel-lic && docker rm  5901-jrebel-lic
```
default port is 8080,you can modify it
## Support

Jrebel
JRebel for Android
XRebel
JetBrains Products
