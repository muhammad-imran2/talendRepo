
package mdf_ft.j1_0_1;

import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.DataQuality;
import routines.Relational;
import routines.DataQualityDependencies;
import routines.Mathematical;
import routines.SQLike;
import routines.Numeric;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.DQTechnical;
import routines.StringHandling;
import routines.DataMasking;
import routines.TalendDate;
import routines.DqStringHandling;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;

//the import part of tJava_1
//import java.util.List;

@SuppressWarnings("unused")

/**
 * Job: j1 Purpose: <br>
 * Description: <br>
 * 
 * @author imran, muhammad
 * @version 8.0.1.20230612_1054-patch
 * @status
 */
public class j1 implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "j1.log");
	}

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(j1.class);

	protected static void logIgnoredError(String message, Throwable cause) {
		log.error(message, cause);

	}

	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}

	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
		}

		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}

	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

		}

		// if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if (NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "j1";
	private final String projectName = "MDF_FT";
	public Integer errorCode = null;
	private String currentComponent = "";

	private String cLabel = null;

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	private final JobStructureCatcherUtils talendJobLog = new JobStructureCatcherUtils(jobName,
			"__1f-8Dc3Ee6XMMEitA0DZA", "0.1");
	private org.talend.job.audit.JobAuditLogger auditLogger_talendJobLog = null;

	private RunStat runStat = new RunStat(talendJobLog, System.getProperty("audit.interval"));

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	public void setDataSourceReferences(List serviceReferences) throws Exception {

		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();

		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils
				.getServices(serviceReferences, javax.sql.DataSource.class).entrySet()) {
			dataSources.put(entry.getKey(), entry.getValue());
			talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

	public String getExceptionStackTrace() {
		if ("failure".equals(this.getStatus())) {
			errorMessagePS.flush();
			return baos.toString();
		}
		return null;
	}

	private Exception exception;

	public Exception getException() {
		if ("failure".equals(this.getStatus())) {
			return this.exception;
		}
		return null;
	}

	private class TalendException extends Exception {

		private static final long serialVersionUID = 1L;

		private java.util.Map<String, Object> globalMap = null;
		private Exception e = null;

		private String currentComponent = null;
		private String cLabel = null;

		private String virtualComponentName = null;

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		private TalendException(Exception e, String errorComponent, String errorComponentLabel,
				final java.util.Map<String, Object> globalMap) {
			this(e, errorComponent, globalMap);
			this.cLabel = errorComponentLabel;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
			Throwable cause = e;
			String message = null;
			int i = 10;
			while (null != cause && 0 < i--) {
				message = cause.getMessage();
				if (null == message) {
					cause = cause.getCause();
				} else {
					break;
				}
			}
			if (null == message) {
				message = e.getClass().getName();
			}
			return message;
		}

		@Override
		public void printStackTrace() {
			if (!(e instanceof TalendException || e instanceof TDieException)) {
				if (virtualComponentName != null && currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					j1.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(j1.this, new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
						if (enableLogStash) {
							talendJobLog.addJobExceptionMessage(currentComponent, cLabel, null, e);
							talendJobLogProcess(globalMap);
						}
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tAzureAdlsGen2Get_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tAzureAdlsGen2Get_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAzureStorageList_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tAzureStorageList_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tJava_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tAzureStorageList_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void talendJobLog_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		talendJobLog_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAzureAdlsGen2Get_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tAzureStorageList_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void talendJobLog_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tAzureAdlsGen2Get_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tAzureAdlsGen2Get_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tAzureAdlsGen2Get_1");
		org.slf4j.MDC.put("_subJobPid", "wuhldG_" + subJobPidCounter.getAndIncrement());

		String iterateId = "";

		String currentComponent = "";
		String cLabel = null;
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tAzureAdlsGen2Get_1 begin ] start
				 */

				ok_Hash.put("tAzureAdlsGen2Get_1", false);
				start_Hash.put("tAzureAdlsGen2Get_1", System.currentTimeMillis());

				currentComponent = "tAzureAdlsGen2Get_1";

				int tos_count_tAzureAdlsGen2Get_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tAzureAdlsGen2Get_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tAzureAdlsGen2Get_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tAzureAdlsGen2Get_1 = new StringBuilder();
							log4jParamters_tAzureAdlsGen2Get_1.append("Parameters:");
							log4jParamters_tAzureAdlsGen2Get_1
									.append("configuration.connection.authMethod" + " = " + "SharedKey");
							log4jParamters_tAzureAdlsGen2Get_1.append(" | ");
							log4jParamters_tAzureAdlsGen2Get_1
									.append("configuration.connection.accountName" + " = " + "imsa03");
							log4jParamters_tAzureAdlsGen2Get_1.append(" | ");
							log4jParamters_tAzureAdlsGen2Get_1
									.append("configuration.connection.endpointSuffix" + " = " + "dfs.core.windows.net");
							log4jParamters_tAzureAdlsGen2Get_1.append(" | ");
							log4jParamters_tAzureAdlsGen2Get_1.append("configuration.connection.sharedKey" + " = "
									+ String.valueOf(
											"enc:routine.encryption.key.v1:R9wQy7IUPY8v/fS8wVE1AQwa0KuK/8bJmTBrDHZFSP0z2WwgPY+c6fUsNqs20pUJ0PEQCeBfRZ40Lg2DG5aIgb9JCdExgoxr8bjTXz6DQMwKNPkgiDxnKQZi+OcQM6QpC5kO6YOZlx/2QqqZzAMqXEFhElM=")
											.substring(0, 4)
									+ "...");
							log4jParamters_tAzureAdlsGen2Get_1.append(" | ");
							log4jParamters_tAzureAdlsGen2Get_1
									.append("configuration.filesystem" + " = " + "commonfiles");
							log4jParamters_tAzureAdlsGen2Get_1.append(" | ");
							log4jParamters_tAzureAdlsGen2Get_1.append("configuration.blobPath" + " = " + "/sub1");
							log4jParamters_tAzureAdlsGen2Get_1.append(" | ");
							log4jParamters_tAzureAdlsGen2Get_1
									.append("configuration.localFolder" + " = " + "C:\\bakwas");
							log4jParamters_tAzureAdlsGen2Get_1.append(" | ");
							log4jParamters_tAzureAdlsGen2Get_1
									.append("configuration.includeSubDirectory" + " = " + "true");
							log4jParamters_tAzureAdlsGen2Get_1.append(" | ");
							log4jParamters_tAzureAdlsGen2Get_1
									.append("configuration.keepRemoteDirStructure" + " = " + "false");
							log4jParamters_tAzureAdlsGen2Get_1.append(" | ");
							log4jParamters_tAzureAdlsGen2Get_1.append("configuration.dieOnError" + " = " + "false");
							log4jParamters_tAzureAdlsGen2Get_1.append(" | ");
							log4jParamters_tAzureAdlsGen2Get_1
									.append("configuration.connection.timeout" + " = " + "600");
							log4jParamters_tAzureAdlsGen2Get_1.append(" | ");
							log4jParamters_tAzureAdlsGen2Get_1.append("USE_EXISTING_CONNECTION" + " = " + "false");
							log4jParamters_tAzureAdlsGen2Get_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tAzureAdlsGen2Get_1 - " + (log4jParamters_tAzureAdlsGen2Get_1));
						}
					}
					new BytesLimit65535_tAzureAdlsGen2Get_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tAzureAdlsGen2Get_1", "tAzureAdlsGen2Get_1", "AzureAdlsGen2Get");
					talendJobLogProcess(globalMap);
				}

				final org.talend.sdk.component.runtime.manager.ComponentManager mgr_tAzureAdlsGen2Get_1 = org.talend.sdk.component.runtime.manager.ComponentManager
						.instance();
				if (mgr_tAzureAdlsGen2Get_1.getContainer().findAll().isEmpty()) {
					mgr_tAzureAdlsGen2Get_1.autoDiscoverPlugins(false, true);
				}

				final java.util.Map<String, String> configuration_tAzureAdlsGen2Get_1 = new java.util.HashMap<>();
				final java.util.Map<String, String> registry_metadata_tAzureAdlsGen2Get_1 = new java.util.HashMap<>();
				configuration_tAzureAdlsGen2Get_1.put("configuration.connection.authMethod", "SharedKey");
				configuration_tAzureAdlsGen2Get_1.put("configuration.connection.accountName", "imsa03");
				configuration_tAzureAdlsGen2Get_1.put("configuration.connection.endpointSuffix",
						"dfs.core.windows.net");
				configuration_tAzureAdlsGen2Get_1.put("configuration.connection.sharedKey",
						routines.system.PasswordEncryptUtil.decryptPassword(
								"enc:routine.encryption.key.v1:dYBbtYPRo9s5L1Ya3vGEplib2xBJoJgMp8PzIhDRNs7CT18oepDB+aPhmYjsChDNa5ZNjj0M+DA3oW6c5hZ60hya+VneLtkST4aU3ubgj7o21tPxMkX1rforWLGj3l8juH9XmrsUKSvn7HDXc++ukVmek0s="));
				// configuration.connection.sas is hidden, skipping.
				// configuration.connection.tenantId is hidden, skipping.
				// configuration.connection.clientId is hidden, skipping.
				// configuration.connection.clientSecret is hidden, skipping.
				configuration_tAzureAdlsGen2Get_1.put("configuration.filesystem", "commonfiles");
				configuration_tAzureAdlsGen2Get_1.put("configuration.blobPath", "/sub1");
				configuration_tAzureAdlsGen2Get_1.put("configuration.localFolder", "C:\\bakwas");
				configuration_tAzureAdlsGen2Get_1.put("configuration.includeSubDirectory", "true");
				configuration_tAzureAdlsGen2Get_1.put("configuration.keepRemoteDirStructure", "false");
				configuration_tAzureAdlsGen2Get_1.put("configuration.dieOnError", "false");
				configuration_tAzureAdlsGen2Get_1.put("configuration.connection.timeout", "600");
				configuration_tAzureAdlsGen2Get_1.put("configuration.connection.__version", "-1");

				final org.talend.sdk.component.runtime.standalone.DriverRunner standalone_tAzureAdlsGen2Get_1 = mgr_tAzureAdlsGen2Get_1
						.findDriverRunner("Azure", "AdlsGen2Get", 1, configuration_tAzureAdlsGen2Get_1)
						.orElseThrow(() -> new IllegalArgumentException("Can't find Azure#AdlsGen2Get"));

				org.talend.sdk.component.runtime.di.studio.RuntimeContextInjector.injectLifecycle(
						standalone_tAzureAdlsGen2Get_1, new org.talend.sdk.component.api.context.RuntimeContextHolder(
								"tAzureAdlsGen2Get_1", globalMap));

				standalone_tAzureAdlsGen2Get_1.start();
				globalMap.put("standalone_tAzureAdlsGen2Get_1", standalone_tAzureAdlsGen2Get_1);

				standalone_tAzureAdlsGen2Get_1.runAtDriver();
//Standalone begin stub

				/**
				 * [tAzureAdlsGen2Get_1 begin ] stop
				 */

				/**
				 * [tAzureAdlsGen2Get_1 main ] start
				 */

				currentComponent = "tAzureAdlsGen2Get_1";

				tos_count_tAzureAdlsGen2Get_1++;

				/**
				 * [tAzureAdlsGen2Get_1 main ] stop
				 */

				/**
				 * [tAzureAdlsGen2Get_1 process_data_begin ] start
				 */

				currentComponent = "tAzureAdlsGen2Get_1";

				/**
				 * [tAzureAdlsGen2Get_1 process_data_begin ] stop
				 */

				/**
				 * [tAzureAdlsGen2Get_1 process_data_end ] start
				 */

				currentComponent = "tAzureAdlsGen2Get_1";

				/**
				 * [tAzureAdlsGen2Get_1 process_data_end ] stop
				 */

				/**
				 * [tAzureAdlsGen2Get_1 end ] start
				 */

				currentComponent = "tAzureAdlsGen2Get_1";

				if (standalone_tAzureAdlsGen2Get_1 != null) {
					standalone_tAzureAdlsGen2Get_1.stop();
				}

				globalMap.remove("standalone_tAzureAdlsGen2Get_1");

				if (log.isDebugEnabled())
					log.debug("tAzureAdlsGen2Get_1 - " + ("Done."));

				ok_Hash.put("tAzureAdlsGen2Get_1", true);
				end_Hash.put("tAzureAdlsGen2Get_1", System.currentTimeMillis());

				/**
				 * [tAzureAdlsGen2Get_1 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tAzureAdlsGen2Get_1 finally ] start
				 */

				currentComponent = "tAzureAdlsGen2Get_1";

				final org.talend.sdk.component.runtime.standalone.DriverRunner standalone_tAzureAdlsGen2Get_1 = org.talend.sdk.component.runtime.standalone.DriverRunner.class
						.cast(globalMap.remove("standalone_tAzureAdlsGen2Get_1"));
				try {
					if (standalone_tAzureAdlsGen2Get_1 != null) {
						standalone_tAzureAdlsGen2Get_1.stop();
					}
				} catch (final RuntimeException re) {
					throw new TalendException(re, currentComponent, cLabel, globalMap);
				}

				/**
				 * [tAzureAdlsGen2Get_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tAzureAdlsGen2Get_1_SUBPROCESS_STATE", 1);
	}

	public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_MDF_FT_j1 = new byte[0];
		static byte[] commonByteArray_MDF_FT_j1 = new byte[0];

		public String BlobName;

		public String getBlobName() {
			return this.BlobName;
		}

		public Boolean BlobNameIsNullable() {
			return false;
		}

		public Boolean BlobNameIsKey() {
			return false;
		}

		public Integer BlobNameLength() {
			return 300;
		}

		public Integer BlobNamePrecision() {
			return null;
		}

		public String BlobNameDefault() {

			return null;

		}

		public String BlobNameComment() {

			return "";

		}

		public String BlobNamePattern() {

			return "";

		}

		public String BlobNameOriginalDbColumnName() {

			return "BlobName";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_MDF_FT_j1.length) {
					if (length < 1024 && commonByteArray_MDF_FT_j1.length == 0) {
						commonByteArray_MDF_FT_j1 = new byte[1024];
					} else {
						commonByteArray_MDF_FT_j1 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_MDF_FT_j1, 0, length);
				strReturn = new String(commonByteArray_MDF_FT_j1, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_MDF_FT_j1.length) {
					if (length < 1024 && commonByteArray_MDF_FT_j1.length == 0) {
						commonByteArray_MDF_FT_j1 = new byte[1024];
					} else {
						commonByteArray_MDF_FT_j1 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_MDF_FT_j1, 0, length);
				strReturn = new String(commonByteArray_MDF_FT_j1, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_MDF_FT_j1) {

				try {

					int length = 0;

					this.BlobName = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_MDF_FT_j1) {

				try {

					int length = 0;

					this.BlobName = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.BlobName, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.BlobName, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("BlobName=" + BlobName);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (BlobName == null) {
				sb.append("<null>");
			} else {
				sb.append(BlobName);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row1Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tAzureStorageList_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tAzureStorageList_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tAzureStorageList_1");
		org.slf4j.MDC.put("_subJobPid", "xygVfR_" + subJobPidCounter.getAndIncrement());

		String iterateId = "";

		String currentComponent = "";
		String cLabel = null;
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row1Struct row1 = new row1Struct();

				/**
				 * [tJava_1 begin ] start
				 */

				ok_Hash.put("tJava_1", false);
				start_Hash.put("tJava_1", System.currentTimeMillis());

				currentComponent = "tJava_1";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row1");

				int tos_count_tJava_1 = 0;

				if (enableLogStash) {
					talendJobLog.addCM("tJava_1", "tJava_1", "tJava");
					talendJobLogProcess(globalMap);
				}

				System.out.println(((Boolean) globalMap.get("tAzureStorageList_1_CURRENT_BLOB")));

				/**
				 * [tJava_1 begin ] stop
				 */

				/**
				 * [tAzureStorageList_1 begin ] start
				 */

				ok_Hash.put("tAzureStorageList_1", false);
				start_Hash.put("tAzureStorageList_1", System.currentTimeMillis());

				currentComponent = "tAzureStorageList_1";

				int tos_count_tAzureStorageList_1 = 0;

				if (enableLogStash) {
					talendJobLog.addCM("tAzureStorageList_1", "tAzureStorageList_1", "tAzureStorageList");
					talendJobLogProcess(globalMap);
				}

				boolean doesNodeBelongToRequest_tAzureStorageList_1 = 0 == 0;
				@SuppressWarnings("unchecked")
				java.util.Map<String, Object> restRequest_tAzureStorageList_1 = (java.util.Map<String, Object>) globalMap
						.get("restRequest");
				String currentTRestRequestOperation_tAzureStorageList_1 = (String) (restRequest_tAzureStorageList_1 != null
						? restRequest_tAzureStorageList_1.get("OPERATION")
						: null);

				org.talend.components.api.component.ComponentDefinition def_tAzureStorageList_1 = new org.talend.components.azurestorage.blob.tazurestoragelist.TAzureStorageListDefinition();

				org.talend.components.api.component.runtime.Writer writer_tAzureStorageList_1 = null;
				org.talend.components.api.component.runtime.Reader reader_tAzureStorageList_1 = null;

				org.talend.components.azurestorage.blob.tazurestoragelist.TAzureStorageListProperties props_tAzureStorageList_1 = (org.talend.components.azurestorage.blob.tazurestoragelist.TAzureStorageListProperties) def_tAzureStorageList_1
						.createRuntimeProperties();
				props_tAzureStorageList_1.setValue("dieOnError", false);

				props_tAzureStorageList_1.setValue("container", "commonfiles");

				java.util.List<Object> tAzureStorageList_1_remoteBlobs_prefix = new java.util.ArrayList<Object>();

				((org.talend.daikon.properties.Properties) props_tAzureStorageList_1.remoteBlobs).setValue("prefix",
						tAzureStorageList_1_remoteBlobs_prefix);

				java.util.List<Object> tAzureStorageList_1_remoteBlobs_include = new java.util.ArrayList<Object>();

				((org.talend.daikon.properties.Properties) props_tAzureStorageList_1.remoteBlobs).setValue("include",
						tAzureStorageList_1_remoteBlobs_include);

				props_tAzureStorageList_1.connection.setValue("accountKey",
						routines.system.PasswordEncryptUtil.decryptPassword(
								"enc:routine.encryption.key.v1:CPidRN10QUd8uz0pjbjWxZAmpgHpctW4tJFMUvHpG9YZ2VhpaDtNiFj6S1CFiQfFkyrRXAfpNqD5ZyrnPfZqpIY0OqDDW3Rxs1u0TSUrBMLXuGT4wrrOx1V5wuVK/5SJHVogRcBPe+6oOFz7bO9dQwFVeyg="));

				props_tAzureStorageList_1.connection.setValue("authenticationType",
						org.talend.components.azurestorage.tazurestorageconnection.AuthType.BASIC);

				props_tAzureStorageList_1.connection.setValue("accountName", "imsa03");

				props_tAzureStorageList_1.connection.setValue("useSharedAccessSignature", false);

				props_tAzureStorageList_1.connection.setValue("protocol",
						org.talend.components.azurestorage.tazurestorageconnection.TAzureStorageConnectionProperties.Protocol.HTTPS);

				props_tAzureStorageList_1.connection.setValue("region",
						org.talend.components.azurestorage.tazurestorageconnection.TAzureStorageConnectionProperties.Region.AZURE_CLOUD);

				props_tAzureStorageList_1.connection.referencedComponent.setValue("referenceDefinitionName",
						"tAzureStorageConnection");

				class SchemaSettingTool_tAzureStorageList_1_1_fisrt {

					String getSchemaValue() {

						StringBuilder s = new StringBuilder();

						a("{\"type\":\"record\",", s);

						a("\"name\":\"Main\",\"fields\":[{", s);

						a("\"name\":\"BlobName\",\"type\":\"string\",\"talend.isLocked\":\"true\",\"talend.field.length\":\"300\"}]}",
								s);

						return s.toString();

					}

					void a(String part, StringBuilder strB) {
						strB.append(part);
					}

				}

				SchemaSettingTool_tAzureStorageList_1_1_fisrt sst_tAzureStorageList_1_1_fisrt = new SchemaSettingTool_tAzureStorageList_1_1_fisrt();

				props_tAzureStorageList_1.schema.setValue("schema",
						new org.apache.avro.Schema.Parser().parse(sst_tAzureStorageList_1_1_fisrt.getSchemaValue()));

				if (org.talend.components.api.properties.ComponentReferenceProperties.ReferenceType.COMPONENT_INSTANCE == props_tAzureStorageList_1.connection.referencedComponent.referenceType
						.getValue()) {
					final String referencedComponentInstanceId_tAzureStorageList_1 = props_tAzureStorageList_1.connection.referencedComponent.componentInstanceId
							.getStringValue();
					if (referencedComponentInstanceId_tAzureStorageList_1 != null) {
						org.talend.daikon.properties.Properties referencedComponentProperties_tAzureStorageList_1 = (org.talend.daikon.properties.Properties) globalMap
								.get(referencedComponentInstanceId_tAzureStorageList_1
										+ "_COMPONENT_RUNTIME_PROPERTIES");
						props_tAzureStorageList_1.connection.referencedComponent
								.setReference(referencedComponentProperties_tAzureStorageList_1);
					}
				}
				globalMap.put("tAzureStorageList_1_COMPONENT_RUNTIME_PROPERTIES", props_tAzureStorageList_1);
				globalMap.putIfAbsent("TALEND_PRODUCT_VERSION", "8.0");
				globalMap.put("TALEND_COMPONENTS_VERSION", "0.37.22");
				java.net.URL mappings_url_tAzureStorageList_1 = this.getClass().getResource("/xmlMappings");
				globalMap.put("tAzureStorageList_1_MAPPINGS_URL", mappings_url_tAzureStorageList_1);

				org.talend.components.api.container.RuntimeContainer container_tAzureStorageList_1 = new org.talend.components.api.container.RuntimeContainer() {
					public Object getComponentData(String componentId, String key) {
						return globalMap.get(componentId + "_" + key);
					}

					public void setComponentData(String componentId, String key, Object data) {
						globalMap.put(componentId + "_" + key, data);
					}

					public String getCurrentComponentId() {
						return "tAzureStorageList_1";
					}

					public Object getGlobalData(String key) {
						return globalMap.get(key);
					}
				};

				int nb_line_tAzureStorageList_1 = 0;

				org.talend.components.api.component.ConnectorTopology topology_tAzureStorageList_1 = null;
				topology_tAzureStorageList_1 = org.talend.components.api.component.ConnectorTopology.OUTGOING;

				org.talend.daikon.runtime.RuntimeInfo runtime_info_tAzureStorageList_1 = def_tAzureStorageList_1
						.getRuntimeInfo(org.talend.components.api.component.runtime.ExecutionEngine.DI,
								props_tAzureStorageList_1, topology_tAzureStorageList_1);
				java.util.Set<org.talend.components.api.component.ConnectorTopology> supported_connector_topologies_tAzureStorageList_1 = def_tAzureStorageList_1
						.getSupportedConnectorTopologies();

				org.talend.components.api.component.runtime.RuntimableRuntime componentRuntime_tAzureStorageList_1 = (org.talend.components.api.component.runtime.RuntimableRuntime) (Class
						.forName(runtime_info_tAzureStorageList_1.getRuntimeClassName()).newInstance());
				org.talend.daikon.properties.ValidationResult initVr_tAzureStorageList_1 = componentRuntime_tAzureStorageList_1
						.initialize(container_tAzureStorageList_1, props_tAzureStorageList_1);

				if (initVr_tAzureStorageList_1
						.getStatus() == org.talend.daikon.properties.ValidationResult.Result.ERROR) {
					throw new RuntimeException(initVr_tAzureStorageList_1.getMessage());
				}

				if (componentRuntime_tAzureStorageList_1 instanceof org.talend.components.api.component.runtime.ComponentDriverInitialization) {
					org.talend.components.api.component.runtime.ComponentDriverInitialization compDriverInitialization_tAzureStorageList_1 = (org.talend.components.api.component.runtime.ComponentDriverInitialization) componentRuntime_tAzureStorageList_1;
					compDriverInitialization_tAzureStorageList_1.runAtDriver(container_tAzureStorageList_1);
				}

				org.talend.components.api.component.runtime.SourceOrSink sourceOrSink_tAzureStorageList_1 = null;
				if (componentRuntime_tAzureStorageList_1 instanceof org.talend.components.api.component.runtime.SourceOrSink) {
					sourceOrSink_tAzureStorageList_1 = (org.talend.components.api.component.runtime.SourceOrSink) componentRuntime_tAzureStorageList_1;
					if (doesNodeBelongToRequest_tAzureStorageList_1) {
						org.talend.daikon.properties.ValidationResult vr_tAzureStorageList_1 = sourceOrSink_tAzureStorageList_1
								.validate(container_tAzureStorageList_1);
						if (vr_tAzureStorageList_1
								.getStatus() == org.talend.daikon.properties.ValidationResult.Result.ERROR) {
							throw new RuntimeException(vr_tAzureStorageList_1.getMessage());
						}
					}
				}

				if (sourceOrSink_tAzureStorageList_1 instanceof org.talend.components.api.component.runtime.Source) {
					org.talend.components.api.component.runtime.Source source_tAzureStorageList_1 = (org.talend.components.api.component.runtime.Source) sourceOrSink_tAzureStorageList_1;
					reader_tAzureStorageList_1 = source_tAzureStorageList_1.createReader(container_tAzureStorageList_1);
					reader_tAzureStorageList_1 = new org.talend.codegen.flowvariables.runtime.FlowVariablesReader(
							reader_tAzureStorageList_1, container_tAzureStorageList_1);

					boolean multi_output_is_allowed_tAzureStorageList_1 = false;
					org.talend.components.api.component.Connector c_tAzureStorageList_1 = null;
					for (org.talend.components.api.component.Connector currentConnector : props_tAzureStorageList_1
							.getAvailableConnectors(null, true)) {
						if (currentConnector.getName().equals("MAIN")) {
							c_tAzureStorageList_1 = currentConnector;
						}

						if (currentConnector.getName().equals("REJECT")) {// it's better to move the code to javajet
							multi_output_is_allowed_tAzureStorageList_1 = true;
						}
					}
					org.apache.avro.Schema schema_tAzureStorageList_1 = props_tAzureStorageList_1
							.getSchema(c_tAzureStorageList_1, true);

					org.talend.codegen.enforcer.OutgoingSchemaEnforcer outgoingEnforcer_tAzureStorageList_1 = org.talend.codegen.enforcer.EnforcerCreator
							.createOutgoingEnforcer(schema_tAzureStorageList_1, false);

					// Create a reusable factory that converts the output of the reader to an
					// IndexedRecord.
					org.talend.daikon.avro.converter.IndexedRecordConverter<Object, ? extends org.apache.avro.generic.IndexedRecord> factory_tAzureStorageList_1 = null;

					// Iterate through the incoming data.
					boolean available_tAzureStorageList_1 = reader_tAzureStorageList_1.start();

					resourceMap.put("reader_tAzureStorageList_1", reader_tAzureStorageList_1);

					for (; available_tAzureStorageList_1; available_tAzureStorageList_1 = reader_tAzureStorageList_1
							.advance()) {
						nb_line_tAzureStorageList_1++;

						if (multi_output_is_allowed_tAzureStorageList_1) {

							row1 = null;

						}

						try {
							Object data_tAzureStorageList_1 = reader_tAzureStorageList_1.getCurrent();

							if (multi_output_is_allowed_tAzureStorageList_1) {
								row1 = new row1Struct();
							}

							// Construct the factory once when the first data arrives.
							if (factory_tAzureStorageList_1 == null) {
								factory_tAzureStorageList_1 = (org.talend.daikon.avro.converter.IndexedRecordConverter<Object, ? extends org.apache.avro.generic.IndexedRecord>) new org.talend.daikon.avro.AvroRegistry()
										.createIndexedRecordConverter(data_tAzureStorageList_1.getClass());
							}

							// Enforce the outgoing schema on the input.
							outgoingEnforcer_tAzureStorageList_1
									.setWrapped(factory_tAzureStorageList_1.convertToAvro(data_tAzureStorageList_1));
							Object columnValue_0_tAzureStorageList_1 = outgoingEnforcer_tAzureStorageList_1.get(0);
							row1.BlobName = (String) (columnValue_0_tAzureStorageList_1);
						} catch (org.talend.components.api.exception.DataRejectException e_tAzureStorageList_1) {
							java.util.Map<String, Object> info_tAzureStorageList_1 = e_tAzureStorageList_1
									.getRejectInfo();

							// TODO use a method instead of getting method by the special key
							// "error/errorMessage"
							Object errorMessage_tAzureStorageList_1 = null;
							if (info_tAzureStorageList_1.containsKey("error")) {
								errorMessage_tAzureStorageList_1 = info_tAzureStorageList_1.get("error");
							} else if (info_tAzureStorageList_1.containsKey("errorMessage")) {
								errorMessage_tAzureStorageList_1 = info_tAzureStorageList_1.get("errorMessage");
							} else {
								errorMessage_tAzureStorageList_1 = "Rejected but error message missing";
							}
							errorMessage_tAzureStorageList_1 = "Row " + nb_line_tAzureStorageList_1 + ": "
									+ errorMessage_tAzureStorageList_1;
							System.err.println(errorMessage_tAzureStorageList_1);

							// If the record is reject, the main line record should put NULL
							row1 = null;

						} // end of catch

						java.lang.Iterable<?> outgoingMainRecordsList_tAzureStorageList_1 = new java.util.ArrayList<Object>();
						java.util.Iterator outgoingMainRecordsIt_tAzureStorageList_1 = null;

						/**
						 * [tAzureStorageList_1 begin ] stop
						 */

						/**
						 * [tAzureStorageList_1 main ] start
						 */

						currentComponent = "tAzureStorageList_1";

						tos_count_tAzureStorageList_1++;

						/**
						 * [tAzureStorageList_1 main ] stop
						 */

						/**
						 * [tAzureStorageList_1 process_data_begin ] start
						 */

						currentComponent = "tAzureStorageList_1";

						/**
						 * [tAzureStorageList_1 process_data_begin ] stop
						 */

						/**
						 * [tJava_1 main ] start
						 */

						currentComponent = "tJava_1";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "row1", "tAzureStorageList_1", "tAzureStorageList_1", "tAzureStorageList", "tJava_1",
								"tJava_1", "tJava"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("row1 - " + (row1 == null ? "" : row1.toLogString()));
						}

						tos_count_tJava_1++;

						/**
						 * [tJava_1 main ] stop
						 */

						/**
						 * [tJava_1 process_data_begin ] start
						 */

						currentComponent = "tJava_1";

						/**
						 * [tJava_1 process_data_begin ] stop
						 */

						/**
						 * [tJava_1 process_data_end ] start
						 */

						currentComponent = "tJava_1";

						/**
						 * [tJava_1 process_data_end ] stop
						 */

						/**
						 * [tAzureStorageList_1 process_data_end ] start
						 */

						currentComponent = "tAzureStorageList_1";

						/**
						 * [tAzureStorageList_1 process_data_end ] stop
						 */

						/**
						 * [tAzureStorageList_1 end ] start
						 */

						currentComponent = "tAzureStorageList_1";

// end of generic

						resourceMap.put("finish_tAzureStorageList_1", Boolean.TRUE);

					} // while
				} // end of "if (sourceOrSink_tAzureStorageList_1 instanceof ...Source)"
				java.util.Map<String, Object> resultMap_tAzureStorageList_1 = null;
				if (reader_tAzureStorageList_1 != null) {
					reader_tAzureStorageList_1.close();
					resultMap_tAzureStorageList_1 = reader_tAzureStorageList_1.getReturnValues();
				}
				if (resultMap_tAzureStorageList_1 != null) {
					for (java.util.Map.Entry<String, Object> entry_tAzureStorageList_1 : resultMap_tAzureStorageList_1
							.entrySet()) {
						switch (entry_tAzureStorageList_1.getKey()) {
						case org.talend.components.api.component.ComponentDefinition.RETURN_ERROR_MESSAGE:
							container_tAzureStorageList_1.setComponentData("tAzureStorageList_1", "ERROR_MESSAGE",
									entry_tAzureStorageList_1.getValue());
							break;
						case org.talend.components.api.component.ComponentDefinition.RETURN_TOTAL_RECORD_COUNT:
							container_tAzureStorageList_1.setComponentData("tAzureStorageList_1", "NB_LINE",
									entry_tAzureStorageList_1.getValue());
							break;
						case org.talend.components.api.component.ComponentDefinition.RETURN_SUCCESS_RECORD_COUNT:
							container_tAzureStorageList_1.setComponentData("tAzureStorageList_1", "NB_SUCCESS",
									entry_tAzureStorageList_1.getValue());
							break;
						case org.talend.components.api.component.ComponentDefinition.RETURN_REJECT_RECORD_COUNT:
							container_tAzureStorageList_1.setComponentData("tAzureStorageList_1", "NB_REJECT",
									entry_tAzureStorageList_1.getValue());
							break;
						default:
							StringBuilder studio_key_tAzureStorageList_1 = new StringBuilder();
							for (int i_tAzureStorageList_1 = 0; i_tAzureStorageList_1 < entry_tAzureStorageList_1
									.getKey().length(); i_tAzureStorageList_1++) {
								char ch_tAzureStorageList_1 = entry_tAzureStorageList_1.getKey()
										.charAt(i_tAzureStorageList_1);
								if (Character.isUpperCase(ch_tAzureStorageList_1) && i_tAzureStorageList_1 > 0) {
									studio_key_tAzureStorageList_1.append('_');
								}
								studio_key_tAzureStorageList_1.append(ch_tAzureStorageList_1);
							}
							container_tAzureStorageList_1.setComponentData("tAzureStorageList_1",
									studio_key_tAzureStorageList_1.toString().toUpperCase(java.util.Locale.ENGLISH),
									entry_tAzureStorageList_1.getValue());
							break;
						}
					}
				}

				ok_Hash.put("tAzureStorageList_1", true);
				end_Hash.put("tAzureStorageList_1", System.currentTimeMillis());

				/**
				 * [tAzureStorageList_1 end ] stop
				 */

				/**
				 * [tJava_1 end ] start
				 */

				currentComponent = "tJava_1";

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row1", 2, 0,
						"tAzureStorageList_1", "tAzureStorageList_1", "tAzureStorageList", "tJava_1", "tJava_1",
						"tJava", "output")) {
					talendJobLogProcess(globalMap);
				}

				ok_Hash.put("tJava_1", true);
				end_Hash.put("tJava_1", System.currentTimeMillis());

				/**
				 * [tJava_1 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tAzureStorageList_1 finally ] start
				 */

				currentComponent = "tAzureStorageList_1";

// finally of generic

				if (resourceMap.get("finish_tAzureStorageList_1") == null) {
					if (resourceMap.get("reader_tAzureStorageList_1") != null) {
						try {
							((org.talend.components.api.component.runtime.Reader) resourceMap
									.get("reader_tAzureStorageList_1")).close();
						} catch (java.io.IOException e_tAzureStorageList_1) {
							String errorMessage_tAzureStorageList_1 = "failed to release the resource in tAzureStorageList_1 :"
									+ e_tAzureStorageList_1.getMessage();
							System.err.println(errorMessage_tAzureStorageList_1);
						}
					}
				}

				/**
				 * [tAzureStorageList_1 finally ] stop
				 */

				/**
				 * [tJava_1 finally ] start
				 */

				currentComponent = "tJava_1";

				/**
				 * [tJava_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tAzureStorageList_1_SUBPROCESS_STATE", 1);
	}

	public void talendJobLogProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("talendJobLog_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "talendJobLog");
		org.slf4j.MDC.put("_subJobPid", "lPnreH_" + subJobPidCounter.getAndIncrement());

		String iterateId = "";

		String currentComponent = "";
		String cLabel = null;
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [talendJobLog begin ] start
				 */

				ok_Hash.put("talendJobLog", false);
				start_Hash.put("talendJobLog", System.currentTimeMillis());

				currentComponent = "talendJobLog";

				int tos_count_talendJobLog = 0;

				for (JobStructureCatcherUtils.JobStructureCatcherMessage jcm : talendJobLog.getMessages()) {
					org.talend.job.audit.JobContextBuilder builder_talendJobLog = org.talend.job.audit.JobContextBuilder
							.create().jobName(jcm.job_name).jobId(jcm.job_id).jobVersion(jcm.job_version)
							.custom("process_id", jcm.pid).custom("thread_id", jcm.tid).custom("pid", pid)
							.custom("father_pid", fatherPid).custom("root_pid", rootPid);
					org.talend.logging.audit.Context log_context_talendJobLog = null;

					if (jcm.log_type == JobStructureCatcherUtils.LogType.PERFORMANCE) {
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.sourceId(jcm.sourceId)
								.sourceLabel(jcm.sourceLabel).sourceConnectorType(jcm.sourceComponentName)
								.targetId(jcm.targetId).targetLabel(jcm.targetLabel)
								.targetConnectorType(jcm.targetComponentName).connectionName(jcm.current_connector)
								.rows(jcm.row_count).duration(duration).build();
						auditLogger_talendJobLog.flowExecution(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.JOBSTART) {
						log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment).build();
						auditLogger_talendJobLog.jobstart(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.JOBEND) {
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment).duration(duration)
								.status(jcm.status).build();
						auditLogger_talendJobLog.jobstop(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.RUNCOMPONENT) {
						log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment)
								.connectorType(jcm.component_name).connectorId(jcm.component_id)
								.connectorLabel(jcm.component_label).build();
						auditLogger_talendJobLog.runcomponent(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.FLOWINPUT) {// log current component
																							// input line
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.connectorType(jcm.component_name)
								.connectorId(jcm.component_id).connectorLabel(jcm.component_label)
								.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
								.rows(jcm.total_row_number).duration(duration).build();
						auditLogger_talendJobLog.flowInput(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.FLOWOUTPUT) {// log current component
																								// output/reject line
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.connectorType(jcm.component_name)
								.connectorId(jcm.component_id).connectorLabel(jcm.component_label)
								.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
								.rows(jcm.total_row_number).duration(duration).build();
						auditLogger_talendJobLog.flowOutput(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.JOBERROR) {
						java.lang.Exception e_talendJobLog = jcm.exception;
						if (e_talendJobLog != null) {
							try (java.io.StringWriter sw_talendJobLog = new java.io.StringWriter();
									java.io.PrintWriter pw_talendJobLog = new java.io.PrintWriter(sw_talendJobLog)) {
								e_talendJobLog.printStackTrace(pw_talendJobLog);
								builder_talendJobLog.custom("stacktrace", sw_talendJobLog.getBuffer().substring(0,
										java.lang.Math.min(sw_talendJobLog.getBuffer().length(), 512)));
							}
						}

						if (jcm.extra_info != null) {
							builder_talendJobLog.connectorId(jcm.component_id).custom("extra_info", jcm.extra_info);
						}

						log_context_talendJobLog = builder_talendJobLog
								.connectorType(jcm.component_id.substring(0, jcm.component_id.lastIndexOf('_')))
								.connectorId(jcm.component_id)
								.connectorLabel(jcm.component_label == null ? jcm.component_id : jcm.component_label)
								.build();

						auditLogger_talendJobLog.exception(log_context_talendJobLog);
					}

				}

				/**
				 * [talendJobLog begin ] stop
				 */

				/**
				 * [talendJobLog main ] start
				 */

				currentComponent = "talendJobLog";

				tos_count_talendJobLog++;

				/**
				 * [talendJobLog main ] stop
				 */

				/**
				 * [talendJobLog process_data_begin ] start
				 */

				currentComponent = "talendJobLog";

				/**
				 * [talendJobLog process_data_begin ] stop
				 */

				/**
				 * [talendJobLog process_data_end ] start
				 */

				currentComponent = "talendJobLog";

				/**
				 * [talendJobLog process_data_end ] stop
				 */

				/**
				 * [talendJobLog end ] start
				 */

				currentComponent = "talendJobLog";

				ok_Hash.put("talendJobLog", true);
				end_Hash.put("talendJobLog", System.currentTimeMillis());

				/**
				 * [talendJobLog end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [talendJobLog finally ] start
				 */

				currentComponent = "talendJobLog";

				/**
				 * [talendJobLog finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("talendJobLog_SUBPROCESS_STATE", 1);
	}

	public String resuming_logs_dir_path = null;
	public String resuming_checkpoint_path = null;
	public String parent_part_launcher = null;
	private String resumeEntryMethodName = null;
	private boolean globalResumeTicket = false;

	public boolean watch = false;
	// portStats is null, it means don't execute the statistics
	public Integer portStats = null;
	public int portTraces = 4334;
	public String clientHost;
	public String defaultClientHost = "localhost";
	public String contextStr = "Default";
	public boolean isDefaultContext = true;
	public String pid = "0";
	public String rootPid = null;
	public String fatherPid = null;
	public String fatherNode = null;
	public long startTime = 0;
	public boolean isChildJob = false;
	public String log4jLevel = "";

	private boolean enableLogStash;

	private boolean execStat = true;

	private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
		protected java.util.Map<String, String> initialValue() {
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	protected PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	private final org.talend.components.common.runtime.SharedConnectionsPool connectionPool = new org.talend.components.common.runtime.SharedConnectionsPool() {
		public java.sql.Connection getDBConnection(String dbDriver, String url, String userName, String password,
				String dbConnectionName) throws ClassNotFoundException, java.sql.SQLException {
			return SharedDBConnection.getDBConnection(dbDriver, url, userName, password, dbConnectionName);
		}

		public java.sql.Connection getDBConnection(String dbDriver, String url, String dbConnectionName)
				throws ClassNotFoundException, java.sql.SQLException {
			return SharedDBConnection.getDBConnection(dbDriver, url, dbConnectionName);
		}
	};

	private static final String GLOBAL_CONNECTION_POOL_KEY = "GLOBAL_CONNECTION_POOL";

	{
		globalMap.put(GLOBAL_CONNECTION_POOL_KEY, connectionPool);
	}

	private final static java.util.Properties jobInfo = new java.util.Properties();
	private final static java.util.Map<String, String> mdcInfo = new java.util.HashMap<>();
	private final static java.util.concurrent.atomic.AtomicLong subJobPidCounter = new java.util.concurrent.atomic.AtomicLong();

	public static void main(String[] args) {
		final j1 j1Class = new j1();

		int exitCode = j1Class.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'j1' - Done.");
		}

		System.exit(exitCode);
	}

	private void getjobInfo() {
		final String TEMPLATE_PATH = "src/main/templates/jobInfo_template.properties";
		final String BUILD_PATH = "../jobInfo.properties";
		final String path = this.getClass().getResource("").getPath();
		if (path.lastIndexOf("target") > 0) {
			final java.io.File templateFile = new java.io.File(
					path.substring(0, path.lastIndexOf("target")).concat(TEMPLATE_PATH));
			if (templateFile.exists()) {
				readJobInfo(templateFile);
				return;
			}
		}
		readJobInfo(new java.io.File(BUILD_PATH));
	}

	private void readJobInfo(java.io.File jobInfoFile) {

		if (jobInfoFile.exists()) {
			try (java.io.InputStream is = new java.io.FileInputStream(jobInfoFile)) {
				jobInfo.load(is);
			} catch (IOException e) {

				log.debug("Read jobInfo.properties file fail: " + e.getMessage());

			}
		}
		log.info(String.format("Project name: %s\tJob name: %s\tGIT Commit ID: %s\tTalend Version: %s", projectName,
				jobName, jobInfo.getProperty("gitCommitId"), "8.0.1.20230612_1054-patch"));

	}

	public String[][] runJob(String[] args) {

		int exitCode = runJobInTOS(args);
		String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

		return bufferValue;
	}

	public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;

		return hastBufferOutput;
	}

	public int runJobInTOS(String[] args) {
		// reset status
		status = "";

		String lastStr = "";
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--context_param")) {
				lastStr = arg;
			} else if (lastStr.equals("")) {
				evalParam(arg);
			} else {
				evalParam(lastStr + " " + arg);
				lastStr = "";
			}
		}
		enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

		if (!"".equals(log4jLevel)) {

			if ("trace".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.TRACE);
			} else if ("debug".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.DEBUG);
			} else if ("info".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.INFO);
			} else if ("warn".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.WARN);
			} else if ("error".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.ERROR);
			} else if ("fatal".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.FATAL);
			} else if ("off".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.OFF);
			}
			org.apache.logging.log4j.core.config.Configurator
					.setLevel(org.apache.logging.log4j.LogManager.getRootLogger().getName(), log.getLevel());

		}

		getjobInfo();
		log.info("TalendJob: 'j1' - Start.");

		java.util.Set<Object> jobInfoKeys = jobInfo.keySet();
		for (Object jobInfoKey : jobInfoKeys) {
			org.slf4j.MDC.put("_" + jobInfoKey.toString(), jobInfo.get(jobInfoKey).toString());
		}
		org.slf4j.MDC.put("_pid", pid);
		org.slf4j.MDC.put("_rootPid", rootPid);
		org.slf4j.MDC.put("_fatherPid", fatherPid);
		org.slf4j.MDC.put("_projectName", projectName);
		org.slf4j.MDC.put("_startTimestamp", java.time.ZonedDateTime.now(java.time.ZoneOffset.UTC)
				.format(java.time.format.DateTimeFormatter.ISO_INSTANT));
		org.slf4j.MDC.put("_jobRepositoryId", "__1f-8Dc3Ee6XMMEitA0DZA");
		org.slf4j.MDC.put("_compiledAtTimestamp", "2023-08-10T05:21:39.026861100Z");

		java.lang.management.RuntimeMXBean mx = java.lang.management.ManagementFactory.getRuntimeMXBean();
		String[] mxNameTable = mx.getName().split("@"); //$NON-NLS-1$
		if (mxNameTable.length == 2) {
			org.slf4j.MDC.put("_systemPid", mxNameTable[0]);
		} else {
			org.slf4j.MDC.put("_systemPid", String.valueOf(java.lang.Thread.currentThread().getId()));
		}

		if (enableLogStash) {
			java.util.Properties properties_talendJobLog = new java.util.Properties();
			properties_talendJobLog.setProperty("root.logger", "audit");
			properties_talendJobLog.setProperty("encoding", "UTF-8");
			properties_talendJobLog.setProperty("application.name", "Talend Studio");
			properties_talendJobLog.setProperty("service.name", "Talend Studio Job");
			properties_talendJobLog.setProperty("instance.name", "Talend Studio Job Instance");
			properties_talendJobLog.setProperty("propagate.appender.exceptions", "none");
			properties_talendJobLog.setProperty("log.appender", "file");
			properties_talendJobLog.setProperty("appender.file.path", "audit.json");
			properties_talendJobLog.setProperty("appender.file.maxsize", "52428800");
			properties_talendJobLog.setProperty("appender.file.maxbackup", "20");
			properties_talendJobLog.setProperty("host", "false");

			System.getProperties().stringPropertyNames().stream().filter(it -> it.startsWith("audit.logger."))
					.forEach(key -> properties_talendJobLog.setProperty(key.substring("audit.logger.".length()),
							System.getProperty(key)));

			org.apache.logging.log4j.core.config.Configurator
					.setLevel(properties_talendJobLog.getProperty("root.logger"), org.apache.logging.log4j.Level.DEBUG);

			auditLogger_talendJobLog = org.talend.job.audit.JobEventAuditLoggerFactory
					.createJobAuditLogger(properties_talendJobLog);
		}

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		org.slf4j.MDC.put("_pid", pid);

		if (rootPid == null) {
			rootPid = pid;
		}

		org.slf4j.MDC.put("_rootPid", rootPid);

		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}
		org.slf4j.MDC.put("_fatherPid", fatherPid);

		if (portStats != null) {
			// portStats = -1; //for testing
			if (portStats < 0 || portStats > 65535) {
				// issue:10869, the portStats is invalid, so this client socket can't open
				System.err.println("The statistics socket port " + portStats + " is invalid.");
				execStat = false;
			}
		} else {
			execStat = false;
		}
		boolean inOSGi = routines.system.BundleUtils.inOSGi();

		try {
			java.util.Dictionary<String, Object> jobProperties = null;
			if (inOSGi) {
				jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

				if (jobProperties != null && jobProperties.get("context") != null) {
					contextStr = (String) jobProperties.get("context");
				}
			}
			// call job/subjob with an existing context, like: --context=production. if
			// without this parameter, there will use the default context instead.
			java.io.InputStream inContext = j1.class.getClassLoader()
					.getResourceAsStream("mdf_ft/j1_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = j1.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null) {
				try {
					// defaultProps is in order to keep the original context value
					if (context != null && context.isEmpty()) {
						defaultProps.load(inContext);
						if (inOSGi && jobProperties != null) {
							java.util.Enumeration<String> keys = jobProperties.keys();
							while (keys.hasMoreElements()) {
								String propKey = keys.nextElement();
								if (defaultProps.containsKey(propKey)) {
									defaultProps.put(propKey, (String) jobProperties.get(propKey));
								}
							}
						}
						context = new ContextProperties(defaultProps);
					}
				} finally {
					inContext.close();
				}
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param is not empty.
				System.err.println("Could not find the context " + contextStr);
			}

			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
			}
			class ContextProcessing {
				private void processContext_0() {
				}

				public void processAllContext() {
					processContext_0();
				}
			}

			new ContextProcessing().processAllContext();
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, ContextProperties.class, parametersToEncrypt));

		org.slf4j.MDC.put("_context", contextStr);
		log.info("TalendJob: 'j1' - Started.");
		mdcInfo.putAll(org.slf4j.MDC.getCopyOfContextMap());

		if (execStat) {
			try {
				runStat.openSocket(!isChildJob);
				runStat.setAllPID(rootPid, fatherPid, pid, jobName);
				runStat.startThreadStat(clientHost, portStats);
				runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
			} catch (java.io.IOException ioException) {
				ioException.printStackTrace();
			}
		}

		java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
		globalMap.put("concurrentHashMap", concurrentHashMap);

		long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		if (enableLogStash) {
			talendJobLog.addJobStartMessage();
			try {
				talendJobLogProcess(globalMap);
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		}

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tAzureAdlsGen2Get_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tAzureAdlsGen2Get_1) {
			globalMap.put("tAzureAdlsGen2Get_1_SUBPROCESS_STATE", -1);

			e_tAzureAdlsGen2Get_1.printStackTrace();

		}
		try {
			errorCode = null;
			tAzureStorageList_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tAzureStorageList_1) {
			globalMap.put("tAzureStorageList_1_SUBPROCESS_STATE", -1);

			e_tAzureStorageList_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : j1");
		}
		if (enableLogStash) {
			talendJobLog.addJobEndMessage(startTime, end, status);
			try {
				talendJobLogProcess(globalMap);
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		}

		if (execStat) {
			runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
			runStat.stopThreadStat();
		}
		int returnCode = 0;

		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "",
				"" + returnCode, "", "", "");
		resumeUtil.flush();

		org.slf4j.MDC.remove("_subJobName");
		org.slf4j.MDC.remove("_subJobPid");
		org.slf4j.MDC.remove("_systemPid");
		log.info("TalendJob: 'j1' - Finished - status: " + status + " returnCode: " + returnCode);

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {

	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();

		return connections;
	}

	private void evalParam(String arg) {
		if (arg.startsWith("--resuming_logs_dir_path")) {
			resuming_logs_dir_path = arg.substring(25);
		} else if (arg.startsWith("--resuming_checkpoint_path")) {
			resuming_checkpoint_path = arg.substring(27);
		} else if (arg.startsWith("--parent_part_launcher")) {
			parent_part_launcher = arg.substring(23);
		} else if (arg.startsWith("--watch")) {
			watch = true;
		} else if (arg.startsWith("--stat_port=")) {
			String portStatsStr = arg.substring(12);
			if (portStatsStr != null && !portStatsStr.equals("null")) {
				portStats = Integer.parseInt(portStatsStr);
			}
		} else if (arg.startsWith("--trace_port=")) {
			portTraces = Integer.parseInt(arg.substring(13));
		} else if (arg.startsWith("--client_host=")) {
			clientHost = arg.substring(14);
		} else if (arg.startsWith("--context=")) {
			contextStr = arg.substring(10);
			isDefaultContext = false;
		} else if (arg.startsWith("--father_pid=")) {
			fatherPid = arg.substring(13);
		} else if (arg.startsWith("--root_pid=")) {
			rootPid = arg.substring(11);
		} else if (arg.startsWith("--father_node=")) {
			fatherNode = arg.substring(14);
		} else if (arg.startsWith("--pid=")) {
			pid = arg.substring(6);
		} else if (arg.startsWith("--context_type")) {
			String keyValue = arg.substring(15);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {// for trunjob call
			final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" }, { "\\'", "\'" }, { "\\r", "\r" },
			{ "\\f", "\f" }, { "\\b", "\b" }, { "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the
			// result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getStatus() {
		return status;
	}

	ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 * 79856 characters generated by Talend Cloud Data Management Platform on the
 * August 10, 2023 at 1:21:39 a.m. EDT
 ************************************************************************************************/