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

package org.springframework.boot.autoconfigure.orm.jpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.boot.model.naming.ImplicitNamingStrategy;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.cfg.AvailableSettings;

import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.aot.hint.TypeHint;
import org.springframework.aot.hint.TypeHint.Builder;
import org.springframework.aot.hint.TypeReference;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaConfiguration.HibernateRuntimeHints;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.SchemaManagementProvider;
import org.springframework.boot.jdbc.metadata.CompositeDataSourcePoolMetadataProvider;
import org.springframework.boot.jdbc.metadata.DataSourcePoolMetadata;
import org.springframework.boot.jdbc.metadata.DataSourcePoolMetadataProvider;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.boot.orm.jpa.hibernate.SpringJtaPlatform;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;
import org.springframework.jndi.JndiLocatorDelegate;
import org.springframework.orm.hibernate5.SpringBeanContainer;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.util.ClassUtils;
public class HibernateJpaConfigurationBuilder {
	private DataSource dataSource;
	private JpaProperties jpaProperties;
	private ConfigurableListableBeanFactory beanFactory;
	private ObjectProvider<JtaTransactionManager> jtaTransactionManager;
	private HibernateProperties hibernateProperties;
	private ObjectProvider<Collection<DataSourcePoolMetadataProvider>> metadataProviders;
	private ObjectProvider<SchemaManagementProvider> providers;
	private ObjectProvider<PhysicalNamingStrategy> physicalNamingStrategy;
	private ObjectProvider<ImplicitNamingStrategy> implicitNamingStrategy;
	private ObjectProvider<HibernatePropertiesCustomizer> hibernatePropertiesCustomizers;

	public HibernateJpaConfigurationBuilder(DataSource dataSource, JpaProperties jpaProperties, ConfigurableListableBeanFactory beanFactory, ObjectProvider<JtaTransactionManager> jtaTransactionManager) {
		this.dataSource = dataSource;
		this.jpaProperties = jpaProperties;
		this.beanFactory = beanFactory;
		this.jtaTransactionManager = jtaTransactionManager;
	}

	public HibernateJpaConfigurationBuilder withHibernateProperties(HibernateProperties hibernateProperties) {
		this.hibernateProperties = hibernateProperties;
		return this;
	}

}
