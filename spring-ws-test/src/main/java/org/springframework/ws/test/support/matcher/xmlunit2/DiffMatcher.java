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

package org.springframework.ws.test.support.matcher.xmlunit2;

import static org.springframework.ws.test.support.AssertionErrors.assertTrue;

import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.test.support.matcher.WebServiceMessageMatcher;
import org.xmlunit.diff.Diff;

/**
 * Implementation of {@link WebServiceMessageMatcher} based on XMLUnit's {@link Diff}.
 *
 * @author Greg Turnquist
 * @since 4.0
 */
public abstract class DiffMatcher implements WebServiceMessageMatcher {

	@Override
	public final void match(WebServiceMessage message) throws AssertionError {

		Diff diff = createDiff(message);
		assertTrue("Messages are different, " + diff.toString(), !diff.hasDifferences(), "Payload",
	message.getPayloadSource());
	}

	/**
	 * Creates a {@link Diff} for the given message.
	 *
	 * @param message the message
	 * @return the diff
	 * @throws Exception in case of errors
	 */
	protected abstract Diff createDiff(WebServiceMessage message);

}
