FROM tomcat:8
RUN rm -rf ./webapps/*
COPY target/*.war /usr/local/tomcat/webapps/ROOT.war
