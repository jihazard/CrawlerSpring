# FROM tomcat:8
FROM  tomcat
RUN rm -rf ./webapps/*
COPY target/*.war /usr/local/tomcat/webapps/ROOT.war
