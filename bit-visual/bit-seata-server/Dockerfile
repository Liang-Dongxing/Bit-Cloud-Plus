FROM findepi/graalvm:java17-native

MAINTAINER Lion Li

RUN mkdir -p /bit/seata-server/logs \
    /bit/skywalking/agent

WORKDIR /bit/seata-server

ENV TZ=PRC
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

EXPOSE 7091
EXPOSE 8091

ADD ./target/bit-seata-server.jar ./app.jar

ENTRYPOINT ["java", \
            "-Djava.security.egd=file:/dev/./urandom", \
#            "-Dskywalking.agent.service_name=bit-seata-server", \
#            "-Dskywalking.plugin.seata.server=true", \
#            "-javaagent:/bit/skywalking/agent/skywalking-agent.jar", \
            "-jar", "app.jar"]
