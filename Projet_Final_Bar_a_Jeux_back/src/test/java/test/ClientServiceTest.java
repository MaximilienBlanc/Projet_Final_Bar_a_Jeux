package test;

import javax.transaction.Transactional;

import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import config.AppConfig;

@SpringJUnitConfig(AppConfig.class)
@Transactional
@Rollback
public class ClientServiceTest {

	
	
	
	
}
