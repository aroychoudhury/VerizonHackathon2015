package test.codeavengers.main.data.jpa.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.codeavengers.common.dto.entity.Category;
import org.codeavengers.common.dto.entity.LocationCategoryAssn;
import org.codeavengers.common.dto.entity.LocationMaster;
import org.codeavengers.main.data.jpa.JPAPersister;
import org.codeavengers.main.data.jpa.impl.LocationPersister;
import org.codeavengers.spring.config.SpringRootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringRootConfig.class })
public class TestLocationPersister {
	private static Logger log = LoggerFactory.getLogger(TestLocationPersister.class);

	@Autowired
	@Qualifier("LocationPersister")
	private JPAPersister<Long, LocationMaster> persister;

	@Autowired
	private ApplicationContext appContext;

	@Test
	public void testIdentify() {
		System.out.println(appContext.getBeanDefinitionNames());
		for(String beanName : appContext.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}
		assertNotNull(persister);
		assertEquals(LocationPersister.class.getSimpleName(), persister.identify());
		log.info("LocationPersister.identify() success");
	}

	@Rollback(false)
	@Test
	public void testAdd() {
		LocationMaster location = new LocationMaster();
		location.setArea("Hyderabad");
		location.setCode("HYD");
		location.setParentLocId(2L);
		location.setLat("27.00000");
		location.setLon("27.00000");
		location.setAssns(new ArrayList<LocationCategoryAssn>(1));

		Category category = new Category();
		category.setCatDesc("Accidents");
		category.setAssns(new ArrayList<LocationCategoryAssn>(1));

		LocationCategoryAssn assn = new LocationCategoryAssn();
		assn.setCategory(category);
		assn.setLocation(location);
		assn.setCategoryField("No. of Persons");
		assn.setCategoryValue("29081");
		location.getAssns().add(assn);
		category.getAssns().add(assn);

		//persister.add(location);
		for(String beanName : appContext.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}

		//JPAPersister persister = (JPAPersister) appContext.getBean("LocationPersister");
		//System.out.println(persister);
	}

	@Test
	public void testUpdate() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testDelete() {
		System.out.println("Not yet implemented");
	}

	@Test
	public void testRetrieve() {
		LocationMaster location = persister.retrieve(1L);
		System.out.println("location -> " + location);
		LocationCategoryAssn assn = location.getAssns().get(0);
		System.out.println("assn -> " + assn);
		System.out.println("Category -> " + assn.getCategory());
	}

}
