package springMVCproject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import springMVCproject.dao.ProductDao;
import springMVCproject.model.Product;

@Controller
public class MainController {
	
	@Autowired
	private ProductDao productDao;

	@RequestMapping(path = "/",method = RequestMethod.GET)
	public String home(Model m) {
		List<Product> products = productDao.getProducts();
		m.addAttribute("products",products);
		return "index";
	}
	
//	show add product form
	@RequestMapping(path = "/add-product",method = RequestMethod.GET)
	public String addProduct(Model m) {
		m.addAttribute("title", "Add Product");
		return "add-product-form";
	}
	
//	add project
	@RequestMapping(path = "/handle-product",method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product,HttpServletRequest request) {
		System.out.println(product);
		productDao.createProduct(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
//	delete handler
	@RequestMapping(path = "/delete/{productId}",method = RequestMethod.GET)
	public RedirectView deleteProduct(@PathVariable("productId") int productId,HttpServletRequest request) {
	this.productDao.deleteProduct(productId);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
//	update product
	@RequestMapping(path = "/update/{productId}",method = RequestMethod.GET)
	public String updateProduct(@PathVariable("productId") int productId,Model model) {
		Product product = this.productDao.getProduct(productId);
		model.addAttribute("product",product);
		return "update-form";
	}
	
}
