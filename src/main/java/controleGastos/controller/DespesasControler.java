package controleGastos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import controleGastos.model.Despesa;
import controleGastos.repository.DespesaRepository;

@Controller
public class DespesasControler {
	
	@Autowired
	private DespesaRepository repository; 
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("listadedespesas")
	public String listaDeDespesas(Model model) {
		
		Iterable<Despesa> despesas = repository.findAll();
		
		model.addAttribute("despesas",despesas);
		
		return "listadedespesas";
	}
}
