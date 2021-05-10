FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD zk-admin-api-0.0.1-SNAPSHOT.war zkweb.war
RUN apk add --update ttf-dejavu fontconfig
ENTRYPOINT ["java","-jar","/zkweb.war"]
ENV LANG C.UTF-8
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
EXPOSE 8089
