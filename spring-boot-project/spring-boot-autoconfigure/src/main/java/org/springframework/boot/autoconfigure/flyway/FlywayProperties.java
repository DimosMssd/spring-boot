/*
 * Copyright 2012-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.autoconfigure.flyway;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.DeprecatedConfigurationProperty;
import org.springframework.boot.convert.DurationUnit;

/**
 * Configuration properties for Flyway database migrations.
 *
 * @author Dave Syer
 * @author Eddú Meléndez
 * @author Stephane Nicoll
 * @author Chris Bono
 * @since 1.1.0
 */
@ConfigurationProperties(prefix = "spring.flyway")
public class FlywayProperties {

	/**
	 * Whether to enable flyway.
	 */
	private boolean enabled = true;










	/**
	 * Whether Flyway should execute SQL within a transaction.
	 */
	private boolean executeInTransaction = true;



	private final Oracle oracle = new Oracle();

	private final Postgresql postgresql = new Postgresql();

	private final Sqlserver sqlserver = new Sqlserver();

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isExecuteInTransaction() {
		return this.executeInTransaction;
	}

	public void setExecuteInTransaction(boolean executeInTransaction) {
		this.executeInTransaction = executeInTransaction;
	}

	@DeprecatedConfigurationProperty(replacement = "spring.flyway.oracle.sqlplus", since = "3.2.0")
	@Deprecated(since = "3.2.0", forRemoval = true)
	public Boolean getOracleSqlplus() {
		return getOracle().getSqlplus();
	}

	@Deprecated(since = "3.2.0", forRemoval = true)
	public void setOracleSqlplus(Boolean oracleSqlplus) {
		getOracle().setSqlplus(oracleSqlplus);
	}

	@DeprecatedConfigurationProperty(replacement = "spring.flyway.oracle.sqlplus-warn", since = "3.2.0")
	@Deprecated(since = "3.2.0", forRemoval = true)
	public Boolean getOracleSqlplusWarn() {
		return getOracle().getSqlplusWarn();
	}

	@Deprecated(since = "3.2.0", forRemoval = true)
	public void setOracleSqlplusWarn(Boolean oracleSqlplusWarn) {
		getOracle().setSqlplusWarn(oracleSqlplusWarn);
	}

	@DeprecatedConfigurationProperty(replacement = "spring.flyway.oracle.wallet-location", since = "3.2.0")
	@Deprecated(since = "3.2.0", forRemoval = true)
	public String getOracleWalletLocation() {
		return getOracle().getWalletLocation();
	}

	@Deprecated(since = "3.2.0", forRemoval = true)
	public void setOracleWalletLocation(String oracleWalletLocation) {
		getOracle().setWalletLocation(oracleWalletLocation);
	}



	@DeprecatedConfigurationProperty(replacement = "spring.flyway.oracle.kerberos-cache-file", since = "3.2.0")
	@Deprecated(since = "3.2.0", forRemoval = true)
	public String getOracleKerberosCacheFile() {
		return getOracle().getKerberosCacheFile();
	}

	@Deprecated(since = "3.2.0", forRemoval = true)
	public void setOracleKerberosCacheFile(String oracleKerberosCacheFile) {
		getOracle().setKerberosCacheFile(oracleKerberosCacheFile);
	}


	@DeprecatedConfigurationProperty(replacement = "spring.flyway.sqlserver.kerberos-login-file")
	@Deprecated(since = "3.2.0", forRemoval = true)
	public String getSqlServerKerberosLoginFile() {
		return getSqlserver().getKerberosLoginFile();
	}

	@Deprecated(since = "3.2.0", forRemoval = true)
	public void setSqlServerKerberosLoginFile(String sqlServerKerberosLoginFile) {
		getSqlserver().setKerberosLoginFile(sqlServerKerberosLoginFile);
	}



	public Oracle getOracle() {
		return this.oracle;
	}

	public Postgresql getPostgresql() {
		return this.postgresql;
	}

	public Sqlserver getSqlserver() {
		return this.sqlserver;
	}

}
