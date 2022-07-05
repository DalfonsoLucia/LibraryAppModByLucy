FROM maven:latest

EXPOSE 8080


RUN apt-get update
RUN apt-get install -y git ssh

ARG ssh_prv_key
ARG ssh_pub_key
RUN mkdir /root/.ssh/
RUN echo "${ssh_prv_key}" > /root/.ssh/id_ed25519
RUN echo "${ssh_pub_key}" > /root/.ssh/id_ed25519.pub
RUN chmod 600 /root/.ssh/id_ed25519
RUN chmod 600 /root/.ssh/id_ed25519.pub

RUN touch /root/.ssh/known_hosts
RUN ssh-keyscan github.com  >> /root/.ssh/known_hosts


RUN git clone git@github.com:DalfonsoLucia/LibraryAppModByLucy.git


WORKDIR LibraryAppModByLucy/

RUN mvn clean package 
COPY target/LibraryApp-0.0.1-SNAPSHOT.jar LibraryApp-0.0.1-SNAPSHOT.jar
RUN ["chmod", "+x", "LibraryApp-0.0.1-SNAPSHOT.jar"]


ADD LibraryAppModByLucy/target/LibraryApp-0.0.1-SNAPSHOT.jar Demo.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","Demo.jar"]
CMD ["-start"]