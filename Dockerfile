FROM dordoka/rpi-tomcat
RUN rm -rf ./webapps/*
COPY target/*.war /usr/local/tomcat/webapps/ROOT.war
