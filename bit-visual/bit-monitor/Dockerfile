FROM findepi/graalvm:java17-native

MAINTAINER Lion Li

RUN mkdir -p /bit/monitor/logs

WORKDIR /bit/monitor

EXPOSE 9100

ADD ./target/bit-monitor.jar ./app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]
