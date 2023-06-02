FROM findepi/graalvm:java17-native

MAINTAINER Lion Li

RUN mkdir -p /bit/resource/logs \
    /bit/resource/temp \
    /bit/skywalking/agent

WORKDIR /bit/resource

ENV SERVER_PORT=9204

EXPOSE ${SERVER_PORT}

ADD ./target/bit-resource.jar ./app.jar

ENTRYPOINT ["java", \
            "-Djava.security.egd=file:/dev/./urandom", \
            "-Dserver.port=${SERVER_PORT}", \
#            "-Dskywalking.agent.service_name=bit-resource", \
#            "-javaagent:/bit/skywalking/agent/skywalking-agent.jar", \
            "-jar", "app.jar"]
