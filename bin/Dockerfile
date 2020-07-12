FROM ubuntu-jdk

MAINTAINER Carlos Villamar "github.com/carlosvillamar"

ENV version=docker
ENV jdburl
ENV dbuser
ENV dbpw
WORKDIR /usr/local/bin

ADD target/springPMA.jar .

#CMD ["/bin/bash"]

ENTRYPOINT ["java","-jar","springPMA.jar"]

