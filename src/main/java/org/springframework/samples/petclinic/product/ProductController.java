package org.springframework.samples.petclinic.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService ps;
	
	@GetMapping(path = "/product/create")
	public String initCreationForm(ModelMap modelMap) {
		Product product = new Product();
		modelMap.addAttribute("product", product);
		modelMap.addAttribute("productType", ps.findAllProductTypes());
		return "products/createOrUpdateProductForm";
	}
    
	@PostMapping(value = "/product/create")
	public String processCreationForm(@Valid Product product, BindingResult result, ModelMap modelMap) {
		if (result.hasErrors()) {
			modelMap.addAttribute("productType", ps.findAllProductTypes());
			return "products/createOrUpdateProductForm";
		}
		else {
			this.ps.save(product);
			modelMap.addAttribute("message", "Se ha guardado bien chingon");
			return "welcome";
		}
	}
	
}