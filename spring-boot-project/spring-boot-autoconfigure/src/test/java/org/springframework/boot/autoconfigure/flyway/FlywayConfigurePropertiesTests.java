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

import java.time.Duration;
import java.util.Arrays;

import org.flywaydb.core.api.Location;
import org.flywaydb.core.api.MigrationVersion;
import org.flywaydb.core.api.configuration.Configuration;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FlywayConfigurePropertiesTests {
	@Test
	void defaultValuesAreConsistent() {
		FlywayProperties properties = new FlywayConfigureProperties();
		Configuration configuration = new FluentConfiguration();
		assertThat(((FlywayConfigureProperties) properties).isFailOnMissingLocations()).isEqualTo(configuration.isFailOnMissingLocations());
		assertThat(((FlywayConfigureProperties) properties).getLocations().stream().map(Location::new).toArray(Location[]::new))
				.isEqualTo(configuration.getLocations());
		assertThat(((FlywayConfigureProperties) properties).getEncoding()).isEqualTo(configuration.getEncoding());
		assertThat(((FlywayConfigureProperties) properties).getConnectRetries()).isEqualTo(configuration.getConnectRetries());
		assertThat(((FlywayConfigureProperties) properties).getConnectRetriesInterval()).extracting(Duration::getSeconds)
				.extracting(Long::intValue)
				.isEqualTo(configuration.getConnectRetriesInterval());
		assertThat(((FlywayConfigureProperties) properties).getLockRetryCount()).isEqualTo(configuration.getLockRetryCount());
		assertThat(((FlywayConfigureProperties) properties).getDefaultSchema()).isEqualTo(configuration.getDefaultSchema());
		assertThat(((FlywayConfigureProperties) properties).getSchemas()).isEqualTo(Arrays.asList(configuration.getSchemas()));
		assertThat(((FlywayConfigureProperties) properties).isCreateSchemas()).isEqualTo(configuration.isCreateSchemas());
		assertThat(((FlywayConfigureProperties) properties).getTable()).isEqualTo(configuration.getTable());
		assertThat(((FlywayConfigureProperties) properties).getBaselineDescription()).isEqualTo(configuration.getBaselineDescription());
		assertThat(MigrationVersion.fromVersion(((FlywayConfigureProperties) properties).getBaselineVersion()))
				.isEqualTo(configuration.getBaselineVersion());
		assertThat(((FlywayConfigureProperties) properties).getInstalledBy()).isEqualTo(configuration.getInstalledBy());
		assertThat(((FlywayConfigureProperties) properties).getPlaceholders()).isEqualTo(configuration.getPlaceholders());
		assertThat(((FlywayConfigureProperties) properties).getPlaceholderPrefix()).isEqualToIgnoringWhitespace(configuration.getPlaceholderPrefix());
		assertThat(((FlywayConfigureProperties) properties).getPlaceholderSuffix()).isEqualTo(configuration.getPlaceholderSuffix());
		assertThat(((FlywayConfigureProperties) properties).isPlaceholderReplacement()).isEqualTo(configuration.isPlaceholderReplacement());
		assertThat(((FlywayConfigureProperties) properties).getSqlMigrationPrefix()).isEqualTo(configuration.getSqlMigrationPrefix());
		assertThat(((FlywayConfigureProperties) properties).getSqlMigrationSuffixes()).containsExactly(configuration.getSqlMigrationSuffixes());
		assertThat(((FlywayConfigureProperties) properties).getSqlMigrationSeparator()).isEqualTo(configuration.getSqlMigrationSeparator());
		assertThat(((FlywayConfigureProperties) properties).getRepeatableSqlMigrationPrefix())
				.isEqualTo(configuration.getRepeatableSqlMigrationPrefix());
		assertThat(MigrationVersion.fromVersion(((FlywayConfigureProperties) properties).getTarget())).isEqualTo(configuration.getTarget());
		assertThat(configuration.getInitSql()).isNull();
		assertThat(((FlywayConfigureProperties) properties).getInitSqls()).isEmpty();
		assertThat(((FlywayConfigureProperties) properties).isBaselineOnMigrate()).isEqualTo(configuration.isBaselineOnMigrate());
		assertThat(((FlywayConfigureProperties) properties).isCleanDisabled()).isEqualTo(configuration.isCleanDisabled());
		assertThat(((FlywayConfigureProperties) properties).isCleanOnValidationError()).isEqualTo(configuration.isCleanOnValidationError());
		assertThat(((FlywayConfigureProperties) properties).isGroup()).isEqualTo(configuration.isGroup());
		assertThat(((FlywayConfigureProperties) properties).isMixed()).isEqualTo(configuration.isMixed());
		assertThat(((FlywayConfigureProperties) properties).isOutOfOrder()).isEqualTo(configuration.isOutOfOrder());
		assertThat(((FlywayConfigureProperties) properties).isSkipDefaultCallbacks()).isEqualTo(configuration.isSkipDefaultCallbacks());
		assertThat(((FlywayConfigureProperties) properties).isSkipDefaultResolvers()).isEqualTo(configuration.isSkipDefaultResolvers());
		assertThat(((FlywayConfigureProperties) properties).isValidateMigrationNaming()).isEqualTo(configuration.isValidateMigrationNaming());
		assertThat(((FlywayConfigureProperties) properties).isValidateOnMigrate()).isEqualTo(configuration.isValidateOnMigrate());
		assertThat(((FlywayConfigureProperties) properties).getDetectEncoding()).isNull();
		assertThat(((FlywayConfigureProperties) properties).getPlaceholderSeparator()).isEqualTo(configuration.getPlaceholderSeparator());
		assertThat(((FlywayConfigureProperties) properties).getScriptPlaceholderPrefix()).isEqualTo(configuration.getScriptPlaceholderPrefix());
		assertThat(((FlywayConfigureProperties) properties).getScriptPlaceholderSuffix()).isEqualTo(configuration.getScriptPlaceholderSuffix());
		assertThat(properties.isExecuteInTransaction()).isEqualTo(configuration.isExecuteInTransaction());
	}
}
