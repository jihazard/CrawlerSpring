# FROM tomcat:8
#RUN rm -rf ./webapps/*
#COPY target/*.war /usr/local/tomcat/webapps/ROOT.war

FROM  dordoka/rpi-tomcat
copy target/*.war /opt/tomcat/webapps/ROOT.war
