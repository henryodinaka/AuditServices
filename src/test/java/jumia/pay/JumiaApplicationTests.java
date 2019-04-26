package jumia.pay;

import com.mongodb.MongoClient;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import jumia.pay.dto.ActivityRequest;
import jumia.pay.enums.Actions;
import jumia.pay.enums.RoleName;
import jumia.pay.interfaces.AuditService;
import jumia.pay.model.Audit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JumiaApplicationTests {
	static MongodExecutable mongodExecutable;
	private MongoClient mongoClient;
	@Autowired
	private AuditService auditService;

	@BeforeClass
	public static void setup() throws Exception {
		MongodStarter starter = MongodStarter.getDefaultInstance();
		String bindIp = "localhost";
		int port = 27018;
		IMongodConfig mongodConfig = new MongodConfigBuilder()
				.version(Version.Main.PRODUCTION)
				.net(new Net(bindIp, port, Network.localhostIsIPv6()))
				.build();
		mongodExecutable = null;
		try {
			mongodExecutable = starter.prepare(mongodConfig);
			mongodExecutable.start();
		} catch (Exception e){
			if (mongodExecutable != null)
				mongodExecutable.stop();
		}
	}

	@AfterClass
	public static void teardown() throws Exception {
		if (mongodExecutable != null)
			mongodExecutable.stop();
	}
    @After
    public void tearDown() throws Exception {
        if (mongodExecutable != null)
            mongodExecutable.stop();
    }

    @Bean
	public MongoTemplate mongoTemplate() {
		mongoClient = new MongoClient("localhost" , 27018);
		MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, "AuditService");
		return mongoTemplate;
	}

	@Test
	public void saveLog() {
		Audit audit = new Audit( Actions.ADD_PRODUCT_TO_CART,"just@gmail.com", RoleName.CUSTOMER);
        Audit savedAudit = auditService.save(audit);
        assertTrue("Audit was saved successfully",savedAudit!=null);
	}
	@Test
	public void getAllLog() {
        Audit audit1 = new Audit( Actions.ADD_PRODUCT_TO_CART,"just@gmail.com", RoleName.CUSTOMER);
        Audit audit2 = new Audit( Actions.ADD_PRODUCT_TO_CART,"just@gmail.com", RoleName.OPERATION);
        Audit audit3 = new Audit( Actions.ADD_PRODUCT_TO_CART,"just@gmail.com", RoleName.CUSTOMERSERVICE);
        Audit savedAudit1 = auditService.save(audit1);
        Audit savedAudit2 = auditService.save(audit2);
        Audit savedAudit3 = auditService.save(audit3);

        List<Audit> userLog = auditService.getLogs();
        assertTrue("User log retrieved",!userLog.isEmpty());

    }
	@Test
	public void getUserLog() {
        Audit audit1 = new Audit( Actions.ADD_PRODUCT_TO_CART,"just@gmail.com", RoleName.OPERATION);
        Audit audit2 = new Audit( Actions.ADD_PRODUCT_TO_CART,"just@gmail.com", RoleName.CUSTOMER);
        Audit audit3 = new Audit( Actions.ADD_PRODUCT_TO_CART,"just@gmail.com", RoleName.CUSTOMERSERVICE);
        Audit savedAudit1 = auditService.save(audit1);
        Audit savedAudit2 = auditService.save(audit2);
        Audit savedAudit3 = auditService.save(audit3);

        List<Audit> userLog = auditService.getLogs();
        assertTrue("User log retrieved",!userLog.isEmpty());

    }

}
