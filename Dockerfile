#for other
# FROM tomcat:8
#RUN rm -rf ./webapps/*
#COPY target/*.war /usr/local/tomcat/webapps/ROOT.war

#for rpi 
FROM  dordoka/rpi-tomcat
RUN rm -rf /opt/tomcat/webapps/*
copy target/*.war /opt/tomcat/webapps/ROOT.war
