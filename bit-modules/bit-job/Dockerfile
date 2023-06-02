FROM findepi/graalvm:java17-native

MAINTAINER Lion Li

RUN mkdir -p /bit/job/logs \
    /bit/job/temp \
    /bit/skywalking/agent

WORKDIR /bit/job

ENV SERVER_PORT=9203

EXPOSE ${SERVER_PORT}

ADD ./target/bit-job.jar ./app.jar

ENTRYPOINT ["java", \
            "-Djava.security.egd=file:/dev/./urandom", \
            "-Dserver.port=${SERVER_PORT}", \
#            "-Dskywalking.agent.service_name=bit-job", \
#            "-javaagent:/bit/skywalking/agent/skywalking-agent.jar", \
            "-jar", "app.jar"]
