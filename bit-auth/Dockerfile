FROM findepi/graalvm:java17-native

MAINTAINER Lion Li

RUN mkdir -p /bit/auth/logs  \
    /bit/auth/temp  \
    /bit/skywalking/agent

WORKDIR /bit/auth

ENV SERVER_PORT=9210

EXPOSE ${SERVER_PORT}

ADD ./target/bit-auth.jar ./app.jar

ENTRYPOINT ["java", \
            "-Djava.security.egd=file:/dev/./urandom", \
            "-Dserver.port=${SERVER_PORT}", \
#            "-Dskywalking.agent.service_name=bit-auth", \
#            "-javaagent:/bit/skywalking/agent/skywalking-agent.jar", \
            "-jar", "app.jar"]
