/*
 * Copyright 2012-2016 the original author or authors.
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

package org.oauth2;

import org.gold.reststack.runtime.APIContext;
import org.gold.starter.AppApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Basic integration tests for demo application.
 *
 * @author Dave Syer
 */
/*@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(AppApplication.class)
@WebIntegrationTest(value = "8080")
@DirtiesContext*/
public class SampleServletApplicationTests extends BaseTest{

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void testHomeIsSecure() throws Exception {
		ResponseEntity<String> entity = new TestRestTemplate().getForEntity("http://localhost:8080/home.beannote", String.class);
		System.out.println(entity.getStatusCode());
		System.out.println(entity.toString());
	}


	@Test
	public void apiTest(){
		super.show(APIContext.getAllReqMappings(applicationContext));
	}

}
