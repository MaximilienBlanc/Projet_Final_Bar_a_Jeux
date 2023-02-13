package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Civilite;
import model.Client;
import service.ClientService;


@Controller
@RequestMapping("/inscription")
public class InscriptionController {

	@Autowired
	private ClientService clientSrv;
	
	@GetMapping("")
	public String inscription(Model model) {
		return goForm(model, new Client());
	}
	
	private String goForm(Model model, Client client) {
		model.addAttribute("client", client);
		model.addAttribute("civilites", Civilite.values());
		return "inscription/inscription";
	}
	
	@PostMapping("")
	public String save(@ModelAttribute Client client) {
		if (client.getId() == null) {
			clientSrv.save(client);
		} 
		else {
			clientSrv.update(client);
		}
		return "redirect:/home";
	}
		
	
}
