# 基础镜像
FROM openjdk:8-jre-slim


# 配置
ENV PARAMS=""


# 添加应用
ADD target/group-buy-market-app.jar /group-buy-market-app.jar

ENTRYPOINT ["sh","-c","java -jar $JAVA_OPTS /group-buy-market-app.jar $PARAMS"]