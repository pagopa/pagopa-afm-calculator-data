ARG JAVA_VERSION=11

FROM mcr.microsoft.com/azure-functions/java:4-java$JAVA_VERSION-build AS installer-env

COPY . /build/java-function-app
RUN cd /build/java-function-app && \
    mkdir -p /home/site/wwwroot && \
    mvn clean package -Dmaven.test.skip=true && \
    cd ./target/azure-functions/ && \
    cd $(ls -d */|head -n 1) && \
    cp -a . /home/site/wwwroot

FROM mcr.microsoft.com/azure-functions/java:4-java$JAVA_VERSION

ENV AzureWebJobsScriptRoot=/home/site/wwwroot \
    AzureFunctionsJobHost__Logging__Console__IsEnabled=true

COPY --from=installer-env ["/home/site/wwwroot", "/home/site/wwwroot"]

EXPOSE 8080
