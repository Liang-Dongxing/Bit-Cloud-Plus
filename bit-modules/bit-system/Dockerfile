FROM findepi/graalvm:java17-native

MAINTAINER Lion Li

RUN mkdir -p /bit/system/logs \
    /bit/system/temp \
    /bit/skywalking/agent

WORKDIR /bit/system

ENV SERVER_PORT=9201

EXPOSE ${SERVER_PORT}

ADD ./target/bit-system.jar ./app.jar

ENTRYPOINT ["java", \
            "-Djava.security.egd=file:/dev/./urandom", \
            "-Dserver.port=${SERVER_PORT}", \
#            "-Dskywalking.agent.service_name=bit-system", \
#            "-javaagent:/bit/skywalking/agent/skywalking-agent.jar", \
            "-jar", "app.jar"]
