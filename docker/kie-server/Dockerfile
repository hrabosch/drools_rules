FROM jboss/kie-server:latest

####### ENVIRONMENT ############
# ENV KIE_SERVER_ID kie-server
ENV KIE_SERVER_LOCATION http://kie-server:8080/kie-server/services/rest/server
ENV KIE_SERVER_USER kieserver
ENV KIE_SERVER_PWD kieserver1!
ENV KIE_SERVER_CONTROLLER_USER admin
ENV KIE_SERVER_CONTROLLER_PWD admin
ENV KIE_MAVEN_REPO http://localhost:8080/kie-wb/maven2
ENV KIE_MAVEN_REPO_USER admin
ENV KIE_MAVEN_REPO_PASSWORD admin
ENV JAVA_OPTS -Xms256m -Xmx1024m -Djava.net.preferIPv4Stack=true -Dfile.encoding=UTF-8

####### Drools KIE Server CUSTOM CONFIGURATION ############
RUN mkdir -p $HOME/.m2
COPY --chown=jboss etc/standalone-full-kie-server.xml $JBOSS_HOME/standalone/configuration/standalone-full-kie-server.xml
COPY --chown=jboss etc/kie-server-users.properties $JBOSS_HOME/standalone/configuration/kie-server-users.properties
COPY --chown=jboss etc/kie-server-roles.properties $JBOSS_HOME/standalone/configuration/kie-server-roles.properties
COPY --chown=jboss etc/start_kie-server.sh $JBOSS_HOME/bin/start_kie-server.sh
COPY --chown=jboss etc/settings.xml $JBOSS_HOME/../.m2/settings.xml

RUN chmod +x $JBOSS_HOME/bin/start_kie-server.sh

####### RUNNING KIE-SERVER ############
WORKDIR $JBOSS_HOME/bin/
CMD ["./start_kie-server.sh"]