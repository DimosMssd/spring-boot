/*
 * Copyright 2012-2022 the original author or authors.
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

package org.springframework.boot.autoconfigure.hazelcast;

import com.hazelcast.core.HazelcastInstance;
import jakarta.persistence.EntityManagerFactory;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.AllNestedConditions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
/*import org.springframework.boot.autoconfigure.orm.jpa.AbstractEntityManagerFactoryBean;*/
import org.springframework.boot.autoconfigure.orm.jpa.EntityManagerFactoryDependsOnPostProcessor;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

/**
 * {@link AutoConfiguration Auto-configuration} for Hazelcast IMDG. Creates a
 * {@link HazelcastInstance} based on explicit configuration or when a default
 * configuration file is found in the environment. Additional configuration ensures
 * that {@link EntityManagerFactory} beans depend on the {@code hazelcastInstance} bean.
 *
 * @author Stephane Nicoll
 * @since 1.3.0
 * @see HazelcastConfigResourceCondition
 */
@AutoConfiguration
@ConditionalOnClass(HazelcastInstance.class)
@EnableConfigurationProperties(HazelcastProperties.class)
@Import({ HazelcastClientConfiguration.class, HazelcastServerConfiguration.class, HazelcastJpaDependencyAutoConfiguration.HazelcastInstanceEntityManagerFactoryDependsOnPostProcessor.class })
public class HazelcastAutoConfigurationDimos {

	@Conditional(HazelcastJpaDependencyAutoConfiguration.OnHazelcastAndJpaCondition.class)
	static class HazelcastInstanceEntityManagerFactoryDependsOnPostProcessor
			extends EntityManagerFactoryDependsOnPostProcessor {
		HazelcastInstanceEntityManagerFactoryDependsOnPostProcessor() {
			super("hazelcastInstance");
		}

	}
	static class OnHazelcastAndJpaCondition extends AllNestedConditions {
		OnHazelcastAndJpaCondition() {
			super(ConfigurationPhase.REGISTER_BEAN);
		}
		@ConditionalOnBean(name = "hazelcastInstance")
		static class HasHazelcastInstance {
		}
		/*
		@ConditionalOnBean(AbstractEntityManagerFactoryBean.class)
		static class HasJpa {
		}
		*/
	}

}
