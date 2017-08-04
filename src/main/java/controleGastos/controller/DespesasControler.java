package controleGastos.controller;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

		carregaDespesas(model);

		return "listadedespesas";
	}

	private void carregaDespesas(Model model) {
		Iterable<Despesa> despesas = repository.findAll();

		model.addAttribute("despesas", despesas);
	}

	@RequestMapping(value = "adicionar", method = RequestMethod.POST)
	public String salvar(@RequestParam("data") LocalDate data, @RequestParam("descricao") String descricao,
			@RequestParam("valor") BigDecimal valor, Model model) {

		Despesa despesa = new Despesa(data, descricao, valor);

		repository.save(despesa);

		carregaDespesas(model);

		return "listadedespesas";
	}
}
