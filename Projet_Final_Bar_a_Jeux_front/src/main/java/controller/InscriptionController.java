package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import quest.service.ClientService;

@Controller
@RequestMapping("/client")
public class InscriptionController {

	@Autowired
	private ClientService clientSrv;
	
	@GetMapping("")
	public String inscription() {
		return "client/inscription";
	}
	

	
	
	
	
	// nouveau client
		// add client
	
}
