%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository="%cd%/../lib" -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 -cp .;../lib/routines.jar;../lib/log4j-jcl-2.17.1.jar;../lib/log4j-slf4j-impl-2.17.1.jar;../lib/log4j-api-2.17.1.jar;../lib/log4j-core-2.17.1.jar;../lib/log4j-1.2-api-2.17.1.jar;../lib/parquet-format-2.4.0.jar;../lib/components-api-0.37.22.jar;../lib/netty-tcnative-boringssl-static-2.0.56.Final-osx-aarch_64.jar;../lib/maven-resolver-spi-1.8.2.jar;../lib/components-common-0.37.22.jar;../lib/commons-logging-1.2.jar;../lib/stream-api-1.46.0.jar;../lib/azure-storage-file-datalake-12.10.0.jar;../lib/maven-resolver-api-1.8.2.jar;../lib/parquet-jackson-1.10.1.jar;../lib/stax2-api-4.2.1.jar;../lib/checker-qual-3.5.0.jar;../lib/hadoop-yarn-client-3.2.4.jar;../lib/wildfly-openssl-2.2.5.Final.jar;../lib/hadoop-mapreduce-client-jobclient-3.2.4.jar;../lib/netty-codec-http-4.1.86.Final.jar;../lib/reactor-netty-core-1.0.25.jar;../lib/netty-common-4.1.86.Final.jar;../lib/json4s-core_2.12-3.5.3.jar;../lib/netty-transport-4.1.86.Final.jar;../lib/netty-codec-http2-4.1.86.Final.jar;../lib/reactor-netty-http-1.0.25.jar;../lib/hadoop-mapreduce-client-core-3.2.4.jar;../lib/netty-resolver-4.1.86.Final.jar;../lib/scala-library-2.12.12.jar;../lib/hadoop-hdfs-client-3.2.4.jar;../lib/audit-common-1.16.1.jar;../lib/oauth2-oidc-sdk-9.32.jar;../lib/netty-transport-native-kqueue-4.1.86.Final-osx-x86_64.jar;../lib/daikon-7.0.5.jar;../lib/jakarta.activation-api-1.2.1.jar;../lib/okio-1.6.0.jar;../lib/org.talend.dataquality.parser.jar;../lib/j2objc-annotations-1.3.jar;../lib/macro-compat_2.12-1.1.1.jar;../lib/commons-pool-1.6.jar;../lib/component-runtime-impl-1.57.1.jar;../lib/azure-dls-gen2-1.46.0.jar;../lib/xbean-asm9-shaded-4.20.jar;../lib/accessors-smart-2.4.9.jar;../lib/commons-configuration2-2.8.0.jar;../lib/reactor-core-3.4.17.jar;../lib/geronimo-json_1.1_spec-1.3.jar;../lib/xz-1.5.jar;../lib/logging-event-layout-1.16.1.jar;../lib/joda-time-2.8.2.jar;../lib/protobuf-java-3.19.6.jar;../lib/woodstox-core-6.5.0.jar;../lib/lang-tag-1.6.jar;../lib/hadoop-azure-datalake-3.2.4.jar;../lib/jackson-databind-2.13.4.2.jar;../lib/component-runtime-design-extension-1.57.1.jar;../lib/netty-buffer-4.1.86.Final.jar;../lib/hadoop-client-3.2.4.jar;../lib/netty-transport-native-epoll-4.1.86.Final-linux-x86_64.jar;../lib/javax.annotation-api-1.3.jar;../lib/rhino-1.7.14.jar;../lib/daikon-exception-7.0.5.jar;../lib/azure-keyvault-core-1.2.4.jar;../lib/hadoop-azure-tlnd-3.2.2.1.jar;../lib/jsp-api-2.1.jar;../lib/common-io-1.46.0.jar;../lib/json4s-jackson_2.12-3.5.3.jar;../lib/jackson-annotations-2.13.4.jar;../lib/netty-codec-dns-4.1.86.Final.jar;../lib/azurecommon-1.46.0.jar;../lib/azure-data-lake-store-sdk-2.2.9.jar;../lib/geronimo-annotation_1.3_spec-1.2.jar;../lib/maven-resolver-util-1.8.2.jar;../lib/reactive-streams-1.0.3.jar;../lib/jersey-core-1.19.jar;../lib/commons-lang3-3.10.jar;../lib/delta-standalone_2.12-0.2.0.1-talend.jar;../lib/json-io-4.13.1-TALEND.jar;../lib/netty-codec-4.1.86.Final.jar;../lib/component-runtime-manager-1.57.1.jar;../lib/error_prone_annotations-2.3.4.jar;../lib/parquet-hadoop-1.10.1.jar;../lib/scala-xml_2.12-1.0.6.jar;../lib/netty-transport-classes-kqueue-4.1.86.Final.jar;../lib/dom4j-2.1.3.jar;../lib/aopalliance-1.0.jar;../lib/jackson-jaxrs-1.9.2.jar;../lib/azure-core-http-netty-1.12.0.jar;../lib/component-spi-1.57.1.jar;../lib/xbean-finder-shaded-4.20.jar;../lib/jaxb-impl-2.2.3-1.jar;../lib/netty-handler-4.1.86.Final.jar;../lib/jna-5.6.0.jar;../lib/commons-text-1.10.0.jar;../lib/jsoup-1.15.3.jar;../lib/commons-collections-3.2.2.jar;../lib/netty-tcnative-boringssl-static-2.0.56.Final-osx-x86_64.jar;../lib/listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar;../lib/hadoop-mapreduce-client-common-3.2.4.jar;../lib/azure-storage-8.6.6.jar;../lib/asm-9.5.jar;../lib/jaxb-api-2.2.11.jar;../lib/parquet-encoding-1.10.1.jar;../lib/stream-json-1.46.0.jar;../lib/commons-net-3.9.0.jar;../lib/netty-resolver-dns-native-macos-4.1.86.Final-osx-x86_64.jar;../lib/jackson-dataformat-xml-2.13.4.jar;../lib/json4s-scalap_2.12-3.5.3.jar;../lib/netty-transport-classes-epoll-4.1.86.Final.jar;../lib/pax-url-aether-2.6.12.jar;../lib/msal4j-1.12.0.jar;../lib/common-1.46.0.jar;../lib/paranamer-2.8.jar;../lib/pax-url-aether-support-2.6.12.jar;../lib/hadoop-yarn-api-3.2.4.jar;../lib/job-audit-1.5.jar;../lib/commons-cli-1.2.jar;../lib/jackson-mapper-asl-1.9.16-TALEND.jar;../lib/talend_file_enhanced-1.3.jar;../lib/json4s-ast_2.12-3.5.3.jar;../lib/netty-tcnative-boringssl-static-2.0.56.Final-windows-x86_64.jar;../lib/shapeless_2.12-2.3.3.jar;../lib/azure-identity-1.5.1.jar;../lib/commons-compress-1.21.jar;../lib/daikon-url-validation-6.4.2.jar;../lib/component-runtime-di-1.57.1.jar;../lib/jakarta.xml.bind-api-2.3.3.jar;../lib/azure-storage-blob-12.17.0.jar;../lib/netty-resolver-dns-4.1.86.Final.jar;../lib/lombok-1.18.24.jar;../lib/azure-utils-1.0.5.jar;../lib/msal4j-persistence-extension-1.1.0.jar;../lib/javax.activation-api-1.2.0.jar;../lib/commons-io-2.8.0.jar;../lib/jackson-core-asl-1.9.16-TALEND.jar;../lib/hadoop-yarn-common-3.2.4.jar;../lib/jersey-client-1.19.jar;../lib/parquet-column-1.10.1.jar;../lib/slf4j-api-1.7.34.jar;../lib/jna-platform-5.6.0.jar;../lib/jackson-xc-1.9.2.jar;../lib/johnzon-mapper-1.2.19.jar;../lib/commons-codec-1.14.jar;../lib/content-type-2.2.jar;../lib/jcip-annotations-1.0-1.jar;../lib/hadoop-annotations-3.2.4.jar;../lib/jersey-servlet-1.19.jar;../lib/container-core-1.57.1.jar;../lib/azure-core-1.28.0.jar;../lib/crypto-utils-7.0.5.jar;../lib/netty-transport-native-unix-common-4.1.86.Final.jar;../lib/htrace-core4-4.1.0-incubating.jar;../lib/guava-30.0-jre.jar;../lib/netty-3.10.6.Final.jar;../lib/talendcsv-1.1.0.jar;../lib/jersey-guice-1.19.jar;../lib/jersey-json-1.19.jar;../lib/javax.servlet-api-3.1.0.jar;../lib/stream-avro-1.46.0.jar;../lib/johnzon-core-1.2.19.jar;../lib/netty-codec-socks-4.1.86.Final.jar;../lib/hadoop-common-3.2.4.jar;../lib/jackson-module-scala_2.12-2.13.4.jar;../lib/avro-1.8.2.jar;../lib/okhttp-2.7.5.jar;../lib/geronimo-jsonb_1.0_spec-1.2.jar;../lib/netty-tcnative-classes-2.0.56.Final.jar;../lib/jettison-1.5.4.jar;../lib/json-smart-2.4.9.jar;../lib/scala-collection-compat_2.12-2.1.6.jar;../lib/httpclient-4.5.13.jar;../lib/javax.inject-1.jar;../lib/component-api-1.57.1.jar;../lib/components-azurestorage-0.37.22.jar;../lib/guice-4.0.jar;../lib/azure-storage-common-12.16.0.jar;../lib/talend-codegen-utils.jar;../lib/netty-handler-proxy-4.1.86.Final.jar;../lib/parquet-common-1.10.1.jar;../lib/failureaccess-1.0.1.jar;../lib/maven-resolver-impl-1.8.2.jar;../lib/parquet-avro-1.10.1.jar;../lib/commons-csv-1.10.0.jar;../lib/commons-beanutils-1.9.4.jar;../lib/jetty-util-9.4.48.v20220622.jar;../lib/commons-math3-3.1.1.jar;../lib/netty-resolver-dns-classes-macos-4.1.86.Final.jar;../lib/hadoop-auth-3.2.4.jar;../lib/maven-resolver-named-locks-1.8.2.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/netty-tcnative-boringssl-static-2.0.56.Final.jar;../lib/xbean-reflect-4.20.jar;../lib/azure-storage-internal-avro-12.3.0.jar;../lib/jackson-datatype-jsr310-2.13.4.jar;../lib/netty-tcnative-boringssl-static-2.0.56.Final-linux-x86_64.jar;../lib/org.osgi.service.component.annotations-1.3.0.jar;../lib/jackson-core-2.13.4.jar;../lib/johnzon-jsonb-1.2.19.jar;../lib/jetty-util-ajax-9.4.48.v20220622.jar;../lib/snappy-java-1.1.2.6.jar;../lib/antlr-runtime-3.5.2.jar;../lib/audit-log4j2-1.16.1.jar;../lib/jersey-server-1.19.jar;../lib/parquet4s-core_2.12-1.2.1.jar;../lib/httpcore-4.4.13.jar;../lib/jackson-jaxrs-json-provider-2.13.4.jar;../lib/netty-tcnative-boringssl-static-2.0.56.Final-linux-aarch_64.jar;../lib/jackson-module-jaxb-annotations-2.13.4.jar;../lib/jackson-jaxrs-base-2.13.4.jar;../lib/nimbus-jose-jwt-9.22.jar;j1_0_1.jar; mdf_ft.j1_0_1.j1 %*
