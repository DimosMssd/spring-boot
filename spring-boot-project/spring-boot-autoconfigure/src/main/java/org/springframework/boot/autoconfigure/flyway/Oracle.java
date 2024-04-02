/*
 * Copyright 2012-2024 the original author or authors.
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

/**
 * {@code OracleConfigurationExtension} properties.
 */
public class Oracle {

	/**
	 * Whether to enable support for Oracle SQL*Plus commands. Requires Flyway Teams.
	 */
	private Boolean sqlplus;

	/**
	 * Whether to issue a warning rather than an error when a not-yet-supported Oracle
	 * SQL*Plus statement is encountered. Requires Flyway Teams.
	 */
	private Boolean sqlplusWarn;

	/**
	 * Path of the Oracle Kerberos cache file. Requires Flyway Teams.
	 */
	private String kerberosCacheFile;

	/**
	 * Location of the Oracle Wallet, used to sign in to the database automatically.
	 * Requires Flyway Teams.
	 */
	private String walletLocation;

	public Boolean getSqlplus() {
		return this.sqlplus;
	}

	public void setSqlplus(Boolean sqlplus) {
		this.sqlplus = sqlplus;
	}

	public Boolean getSqlplusWarn() {
		return this.sqlplusWarn;
	}

	public void setSqlplusWarn(Boolean sqlplusWarn) {
		this.sqlplusWarn = sqlplusWarn;
	}

	public String getKerberosCacheFile() {
		return this.kerberosCacheFile;
	}

	public void setKerberosCacheFile(String kerberosCacheFile) {
		this.kerberosCacheFile = kerberosCacheFile;
	}

	public String getWalletLocation() {
		return this.walletLocation;
	}

	public void setWalletLocation(String walletLocation) {
		this.walletLocation = walletLocation;
	}

}
