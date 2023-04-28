FROM quay.io/kiegroup/business-central-workbench:latest

USER jboss

COPY --chown=jboss etc/jbpm-custom.cli $JBOSS_HOME/bin/
COPY --chown=jboss etc/kie-fs-realm-users $JBOSS_HOME/standalone/configuration/kie-fs-realm-users

RUN $JBOSS_HOME/bin/jboss-cli.sh --file=$JBOSS_HOME/bin/jbpm-custom.cli && \
    rm -rf $JBOSS_HOME/standalone/configuration/standalone_xml_history/current

WORKDIR $JBOSS_HOME/bin/
CMD ["./start_business-central-wb.sh"]