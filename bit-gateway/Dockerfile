FROM findepi/graalvm:java17-native

MAINTAINER Lion Li

RUN mkdir -p /bit/gateway/logs  \
    /bit/gateway/temp  \
    /bit/skywalking/agent

WORKDIR /bit/gateway

ENV SERVER_PORT=8080

EXPOSE ${SERVER_PORT}

ADD ./target/bit-gateway.jar ./app.jar

ENTRYPOINT ["java", \
            "-Djava.security.egd=file:/dev/./urandom", \
            "-Dserver.port=${SERVER_PORT}", \
#            "-Dskywalking.agent.service_name=bit-gateway", \
#            "-javaagent:/bit/skywalking/agent/skywalking-agent.jar", \
            "-jar", "app.jar"]
