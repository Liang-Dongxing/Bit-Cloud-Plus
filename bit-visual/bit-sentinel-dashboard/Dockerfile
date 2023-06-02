FROM findepi/graalvm:java17-native

MAINTAINER Lion Li

RUN mkdir -p /bit/sentinel-dashboard/logs \
    /bit/skywalking/agent

WORKDIR /bit/sentinel-dashboard

EXPOSE 8718

ADD ./target/bit-sentinel-dashboard.jar ./app.jar

ENTRYPOINT ["java", \
            "-Djava.security.egd=file:/dev/./urandom", \
#            "-Dskywalking.agent.service_name=bit-sentinel-dashboard", \
#            "-javaagent:/bit/skywalking/agent/skywalking-agent.jar", \
            "-jar", "app.jar"]
