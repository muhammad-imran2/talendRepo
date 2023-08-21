#!/bin/sh
cd `dirname $0`
ROOT_PATH=`pwd`
java -Dtalend.component.manager.m2.repository=$ROOT_PATH/../lib -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 -cp .:$ROOT_PATH:$ROOT_PATH/../lib/routines.jar:$ROOT_PATH/../lib/log4j-jcl-2.17.1.jar:$ROOT_PATH/../lib/log4j-slf4j-impl-2.17.1.jar:$ROOT_PATH/../lib/log4j-api-2.17.1.jar:$ROOT_PATH/../lib/log4j-core-2.17.1.jar:$ROOT_PATH/../lib/log4j-1.2-api-2.17.1.jar:$ROOT_PATH/../lib/parquet-format-2.4.0.jar:$ROOT_PATH/../lib/components-api-0.37.22.jar:$ROOT_PATH/../lib/netty-tcnative-boringssl-static-2.0.56.Final-osx-aarch_64.jar:$ROOT_PATH/../lib/maven-resolver-spi-1.8.2.jar:$ROOT_PATH/../lib/components-common-0.37.22.jar:$ROOT_PATH/../lib/commons-logging-1.2.jar:$ROOT_PATH/../lib/stream-api-1.46.0.jar:$ROOT_PATH/../lib/azure-storage-file-datalake-12.10.0.jar:$ROOT_PATH/../lib/maven-resolver-api-1.8.2.jar:$ROOT_PATH/../lib/parquet-jackson-1.10.1.jar:$ROOT_PATH/../lib/stax2-api-4.2.1.jar:$ROOT_PATH/../lib/checker-qual-3.5.0.jar:$ROOT_PATH/../lib/hadoop-yarn-client-3.2.4.jar:$ROOT_PATH/../lib/wildfly-openssl-2.2.5.Final.jar:$ROOT_PATH/../lib/hadoop-mapreduce-client-jobclient-3.2.4.jar:$ROOT_PATH/../lib/netty-codec-http-4.1.86.Final.jar:$ROOT_PATH/../lib/reactor-netty-core-1.0.25.jar:$ROOT_PATH/../lib/netty-common-4.1.86.Final.jar:$ROOT_PATH/../lib/json4s-core_2.12-3.5.3.jar:$ROOT_PATH/../lib/netty-transport-4.1.86.Final.jar:$ROOT_PATH/../lib/netty-codec-http2-4.1.86.Final.jar:$ROOT_PATH/../lib/reactor-netty-http-1.0.25.jar:$ROOT_PATH/../lib/hadoop-mapreduce-client-core-3.2.4.jar:$ROOT_PATH/../lib/netty-resolver-4.1.86.Final.jar:$ROOT_PATH/../lib/scala-library-2.12.12.jar:$ROOT_PATH/../lib/hadoop-hdfs-client-3.2.4.jar:$ROOT_PATH/../lib/audit-common-1.16.1.jar:$ROOT_PATH/../lib/oauth2-oidc-sdk-9.32.jar:$ROOT_PATH/../lib/netty-transport-native-kqueue-4.1.86.Final-osx-x86_64.jar:$ROOT_PATH/../lib/daikon-7.0.5.jar:$ROOT_PATH/../lib/jakarta.activation-api-1.2.1.jar:$ROOT_PATH/../lib/okio-1.6.0.jar:$ROOT_PATH/../lib/org.talend.dataquality.parser.jar:$ROOT_PATH/../lib/j2objc-annotations-1.3.jar:$ROOT_PATH/../lib/macro-compat_2.12-1.1.1.jar:$ROOT_PATH/../lib/commons-pool-1.6.jar:$ROOT_PATH/../lib/component-runtime-impl-1.57.1.jar:$ROOT_PATH/../lib/azure-dls-gen2-1.46.0.jar:$ROOT_PATH/../lib/xbean-asm9-shaded-4.20.jar:$ROOT_PATH/../lib/accessors-smart-2.4.9.jar:$ROOT_PATH/../lib/commons-configuration2-2.8.0.jar:$ROOT_PATH/../lib/reactor-core-3.4.17.jar:$ROOT_PATH/../lib/geronimo-json_1.1_spec-1.3.jar:$ROOT_PATH/../lib/xz-1.5.jar:$ROOT_PATH/../lib/logging-event-layout-1.16.1.jar:$ROOT_PATH/../lib/joda-time-2.8.2.jar:$ROOT_PATH/../lib/protobuf-java-3.19.6.jar:$ROOT_PATH/../lib/woodstox-core-6.5.0.jar:$ROOT_PATH/../lib/lang-tag-1.6.jar:$ROOT_PATH/../lib/hadoop-azure-datalake-3.2.4.jar:$ROOT_PATH/../lib/jackson-databind-2.13.4.2.jar:$ROOT_PATH/../lib/component-runtime-design-extension-1.57.1.jar:$ROOT_PATH/../lib/netty-buffer-4.1.86.Final.jar:$ROOT_PATH/../lib/hadoop-client-3.2.4.jar:$ROOT_PATH/../lib/netty-transport-native-epoll-4.1.86.Final-linux-x86_64.jar:$ROOT_PATH/../lib/javax.annotation-api-1.3.jar:$ROOT_PATH/../lib/rhino-1.7.14.jar:$ROOT_PATH/../lib/daikon-exception-7.0.5.jar:$ROOT_PATH/../lib/azure-keyvault-core-1.2.4.jar:$ROOT_PATH/../lib/hadoop-azure-tlnd-3.2.2.1.jar:$ROOT_PATH/../lib/jsp-api-2.1.jar:$ROOT_PATH/../lib/common-io-1.46.0.jar:$ROOT_PATH/../lib/json4s-jackson_2.12-3.5.3.jar:$ROOT_PATH/../lib/jackson-annotations-2.13.4.jar:$ROOT_PATH/../lib/netty-codec-dns-4.1.86.Final.jar:$ROOT_PATH/../lib/azurecommon-1.46.0.jar:$ROOT_PATH/../lib/azure-data-lake-store-sdk-2.2.9.jar:$ROOT_PATH/../lib/geronimo-annotation_1.3_spec-1.2.jar:$ROOT_PATH/../lib/maven-resolver-util-1.8.2.jar:$ROOT_PATH/../lib/reactive-streams-1.0.3.jar:$ROOT_PATH/../lib/jersey-core-1.19.jar:$ROOT_PATH/../lib/commons-lang3-3.10.jar:$ROOT_PATH/../lib/delta-standalone_2.12-0.2.0.1-talend.jar:$ROOT_PATH/../lib/json-io-4.13.1-TALEND.jar:$ROOT_PATH/../lib/netty-codec-4.1.86.Final.jar:$ROOT_PATH/../lib/component-runtime-manager-1.57.1.jar:$ROOT_PATH/../lib/error_prone_annotations-2.3.4.jar:$ROOT_PATH/../lib/parquet-hadoop-1.10.1.jar:$ROOT_PATH/../lib/scala-xml_2.12-1.0.6.jar:$ROOT_PATH/../lib/netty-transport-classes-kqueue-4.1.86.Final.jar:$ROOT_PATH/../lib/dom4j-2.1.3.jar:$ROOT_PATH/../lib/aopalliance-1.0.jar:$ROOT_PATH/../lib/jackson-jaxrs-1.9.2.jar:$ROOT_PATH/../lib/azure-core-http-netty-1.12.0.jar:$ROOT_PATH/../lib/component-spi-1.57.1.jar:$ROOT_PATH/../lib/xbean-finder-shaded-4.20.jar:$ROOT_PATH/../lib/jaxb-impl-2.2.3-1.jar:$ROOT_PATH/../lib/netty-handler-4.1.86.Final.jar:$ROOT_PATH/../lib/jna-5.6.0.jar:$ROOT_PATH/../lib/commons-text-1.10.0.jar:$ROOT_PATH/../lib/jsoup-1.15.3.jar:$ROOT_PATH/../lib/commons-collections-3.2.2.jar:$ROOT_PATH/../lib/netty-tcnative-boringssl-static-2.0.56.Final-osx-x86_64.jar:$ROOT_PATH/../lib/listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar:$ROOT_PATH/../lib/hadoop-mapreduce-client-common-3.2.4.jar:$ROOT_PATH/../lib/azure-storage-8.6.6.jar:$ROOT_PATH/../lib/asm-9.5.jar:$ROOT_PATH/../lib/jaxb-api-2.2.11.jar:$ROOT_PATH/../lib/parquet-encoding-1.10.1.jar:$ROOT_PATH/../lib/stream-json-1.46.0.jar:$ROOT_PATH/../lib/commons-net-3.9.0.jar:$ROOT_PATH/../lib/netty-resolver-dns-native-macos-4.1.86.Final-osx-x86_64.jar:$ROOT_PATH/../lib/jackson-dataformat-xml-2.13.4.jar:$ROOT_PATH/../lib/json4s-scalap_2.12-3.5.3.jar:$ROOT_PATH/../lib/netty-transport-classes-epoll-4.1.86.Final.jar:$ROOT_PATH/../lib/pax-url-aether-2.6.12.jar:$ROOT_PATH/../lib/msal4j-1.12.0.jar:$ROOT_PATH/../lib/common-1.46.0.jar:$ROOT_PATH/../lib/paranamer-2.8.jar:$ROOT_PATH/../lib/pax-url-aether-support-2.6.12.jar:$ROOT_PATH/../lib/hadoop-yarn-api-3.2.4.jar:$ROOT_PATH/../lib/job-audit-1.5.jar:$ROOT_PATH/../lib/commons-cli-1.2.jar:$ROOT_PATH/../lib/jackson-mapper-asl-1.9.16-TALEND.jar:$ROOT_PATH/../lib/talend_file_enhanced-1.3.jar:$ROOT_PATH/../lib/json4s-ast_2.12-3.5.3.jar:$ROOT_PATH/../lib/netty-tcnative-boringssl-static-2.0.56.Final-windows-x86_64.jar:$ROOT_PATH/../lib/shapeless_2.12-2.3.3.jar:$ROOT_PATH/../lib/azure-identity-1.5.1.jar:$ROOT_PATH/../lib/commons-compress-1.21.jar:$ROOT_PATH/../lib/daikon-url-validation-6.4.2.jar:$ROOT_PATH/../lib/component-runtime-di-1.57.1.jar:$ROOT_PATH/../lib/jakarta.xml.bind-api-2.3.3.jar:$ROOT_PATH/../lib/azure-storage-blob-12.17.0.jar:$ROOT_PATH/../lib/netty-resolver-dns-4.1.86.Final.jar:$ROOT_PATH/../lib/lombok-1.18.24.jar:$ROOT_PATH/../lib/azure-utils-1.0.5.jar:$ROOT_PATH/../lib/msal4j-persistence-extension-1.1.0.jar:$ROOT_PATH/../lib/javax.activation-api-1.2.0.jar:$ROOT_PATH/../lib/commons-io-2.8.0.jar:$ROOT_PATH/../lib/jackson-core-asl-1.9.16-TALEND.jar:$ROOT_PATH/../lib/hadoop-yarn-common-3.2.4.jar:$ROOT_PATH/../lib/jersey-client-1.19.jar:$ROOT_PATH/../lib/parquet-column-1.10.1.jar:$ROOT_PATH/../lib/slf4j-api-1.7.34.jar:$ROOT_PATH/../lib/jna-platform-5.6.0.jar:$ROOT_PATH/../lib/jackson-xc-1.9.2.jar:$ROOT_PATH/../lib/johnzon-mapper-1.2.19.jar:$ROOT_PATH/../lib/commons-codec-1.14.jar:$ROOT_PATH/../lib/content-type-2.2.jar:$ROOT_PATH/../lib/jcip-annotations-1.0-1.jar:$ROOT_PATH/../lib/hadoop-annotations-3.2.4.jar:$ROOT_PATH/../lib/jersey-servlet-1.19.jar:$ROOT_PATH/../lib/container-core-1.57.1.jar:$ROOT_PATH/../lib/azure-core-1.28.0.jar:$ROOT_PATH/../lib/crypto-utils-7.0.5.jar:$ROOT_PATH/../lib/netty-transport-native-unix-common-4.1.86.Final.jar:$ROOT_PATH/../lib/htrace-core4-4.1.0-incubating.jar:$ROOT_PATH/../lib/guava-30.0-jre.jar:$ROOT_PATH/../lib/netty-3.10.6.Final.jar:$ROOT_PATH/../lib/talendcsv-1.1.0.jar:$ROOT_PATH/../lib/jersey-guice-1.19.jar:$ROOT_PATH/../lib/jersey-json-1.19.jar:$ROOT_PATH/../lib/javax.servlet-api-3.1.0.jar:$ROOT_PATH/../lib/stream-avro-1.46.0.jar:$ROOT_PATH/../lib/johnzon-core-1.2.19.jar:$ROOT_PATH/../lib/netty-codec-socks-4.1.86.Final.jar:$ROOT_PATH/../lib/hadoop-common-3.2.4.jar:$ROOT_PATH/../lib/jackson-module-scala_2.12-2.13.4.jar:$ROOT_PATH/../lib/avro-1.8.2.jar:$ROOT_PATH/../lib/okhttp-2.7.5.jar:$ROOT_PATH/../lib/geronimo-jsonb_1.0_spec-1.2.jar:$ROOT_PATH/../lib/netty-tcnative-classes-2.0.56.Final.jar:$ROOT_PATH/../lib/jettison-1.5.4.jar:$ROOT_PATH/../lib/json-smart-2.4.9.jar:$ROOT_PATH/../lib/scala-collection-compat_2.12-2.1.6.jar:$ROOT_PATH/../lib/httpclient-4.5.13.jar:$ROOT_PATH/../lib/javax.inject-1.jar:$ROOT_PATH/../lib/component-api-1.57.1.jar:$ROOT_PATH/../lib/components-azurestorage-0.37.22.jar:$ROOT_PATH/../lib/guice-4.0.jar:$ROOT_PATH/../lib/azure-storage-common-12.16.0.jar:$ROOT_PATH/../lib/talend-codegen-utils.jar:$ROOT_PATH/../lib/netty-handler-proxy-4.1.86.Final.jar:$ROOT_PATH/../lib/parquet-common-1.10.1.jar:$ROOT_PATH/../lib/failureaccess-1.0.1.jar:$ROOT_PATH/../lib/maven-resolver-impl-1.8.2.jar:$ROOT_PATH/../lib/parquet-avro-1.10.1.jar:$ROOT_PATH/../lib/commons-csv-1.10.0.jar:$ROOT_PATH/../lib/commons-beanutils-1.9.4.jar:$ROOT_PATH/../lib/jetty-util-9.4.48.v20220622.jar:$ROOT_PATH/../lib/commons-math3-3.1.1.jar:$ROOT_PATH/../lib/netty-resolver-dns-classes-macos-4.1.86.Final.jar:$ROOT_PATH/../lib/hadoop-auth-3.2.4.jar:$ROOT_PATH/../lib/maven-resolver-named-locks-1.8.2.jar:$ROOT_PATH/../lib/jboss-marshalling-2.0.12.Final.jar:$ROOT_PATH/../lib/netty-tcnative-boringssl-static-2.0.56.Final.jar:$ROOT_PATH/../lib/xbean-reflect-4.20.jar:$ROOT_PATH/../lib/azure-storage-internal-avro-12.3.0.jar:$ROOT_PATH/../lib/jackson-datatype-jsr310-2.13.4.jar:$ROOT_PATH/../lib/netty-tcnative-boringssl-static-2.0.56.Final-linux-x86_64.jar:$ROOT_PATH/../lib/org.osgi.service.component.annotations-1.3.0.jar:$ROOT_PATH/../lib/jackson-core-2.13.4.jar:$ROOT_PATH/../lib/johnzon-jsonb-1.2.19.jar:$ROOT_PATH/../lib/jetty-util-ajax-9.4.48.v20220622.jar:$ROOT_PATH/../lib/snappy-java-1.1.2.6.jar:$ROOT_PATH/../lib/antlr-runtime-3.5.2.jar:$ROOT_PATH/../lib/audit-log4j2-1.16.1.jar:$ROOT_PATH/../lib/jersey-server-1.19.jar:$ROOT_PATH/../lib/parquet4s-core_2.12-1.2.1.jar:$ROOT_PATH/../lib/httpcore-4.4.13.jar:$ROOT_PATH/../lib/jackson-jaxrs-json-provider-2.13.4.jar:$ROOT_PATH/../lib/netty-tcnative-boringssl-static-2.0.56.Final-linux-aarch_64.jar:$ROOT_PATH/../lib/jackson-module-jaxb-annotations-2.13.4.jar:$ROOT_PATH/../lib/jackson-jaxrs-base-2.13.4.jar:$ROOT_PATH/../lib/nimbus-jose-jwt-9.22.jar:$ROOT_PATH/j1_0_1.jar: mdf_ft.j1_0_1.j1 "$@"
