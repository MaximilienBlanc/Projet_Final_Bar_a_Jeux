package test;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import config.AppConfig;
import service.AdminService;

@SpringJUnitConfig(AppConfig.class)
@Transactional
@Rollback
public class AdminServiceTest {

	@Autowired 
	AdminService adminSrv;
	

	
}
