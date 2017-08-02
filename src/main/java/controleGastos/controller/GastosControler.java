package controleGastos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GastosControler {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
