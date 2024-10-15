FROM glassfish:4.1-jdk8

COPY /BrRobotics/dist/BrRobotics.war $GLASSFISH_HOME/glassfish/domains/domain1/autodeploy/

CMD ["asadmin", "start-domain", "-v"]
