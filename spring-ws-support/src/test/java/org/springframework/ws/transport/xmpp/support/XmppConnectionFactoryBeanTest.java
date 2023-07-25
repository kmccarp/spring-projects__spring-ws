/*
 * Copyright 2005-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.ws.transport.xmpp.support;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** @author Arjen Poutsma */
public class XmppConnectionFactoryBeanTest {

	private XmppConnectionFactoryBean factoryBean;

	@BeforeEach
	public void createFactoryBean() {
		factoryBean = new XmppConnectionFactoryBean();
	}

	@Test
	public void noHost() {
		assertThatIllegalArgumentException().isThrownBy(factoryBean::afterPropertiesSet);
	}

	@Test
	public void noUsername() {

		assertThatIllegalArgumentException().isThrownBy(() -> {

			factoryBean.setHost("jabber.org");
			factoryBean.afterPropertiesSet();
		});
	}

	@Test
	public void wrongPort() {
		assertThatIllegalArgumentException().isThrownBy(() -> factoryBean.setPort(-10));
	}
}
