package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import quest.service.ClientService;

@Controller
@RequestMapping("/clientInfo")
public class ClientController {

	@Autowired
	private ClientService clientSrv;
	
//	@GetMapping("")
//	public String listeDeClient(Model model) {
//		model.addAttribute("clients", clientSrv.findAll());
//		return "client/clientInfo";
//	}
	
	@GetMapping("/clientInfo")
	public String clientInfo() {
		return "clientInfo";
	}
	
}
