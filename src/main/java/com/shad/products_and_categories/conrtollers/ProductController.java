package com.shad.products_and_categories.conrtollers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shad.products_and_categories.models.Category;
import com.shad.products_and_categories.models.Product;
import com.shad.products_and_categories.services.CategoryService;
import com.shad.products_and_categories.services.ProductService;


@Controller
public class ProductController {
	private final ProductService productSvc;
	private final CategoryService categorySvc;
	
	public ProductController(ProductService productSvc, CategoryService categorySvc) {
		this.productSvc = productSvc;
		this.categorySvc = categorySvc;
	}

	@RequestMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		
		// build a list of all products & categories
		List<Product> products = productSvc.allProducts();
		List<Category> categories = categorySvc.allCategorys();

		
		// pass the lists to the dashboard
		model.addAttribute("products", products);
		model.addAttribute("categories", categories);
		
		// load the dashboard
		return "/dashboard.jsp";
	}
	
	
	
	@RequestMapping("/products/add")
	public String showProductForm(@ModelAttribute ("product") Product product, 
			Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		List<Product> products = productSvc.allProducts();
		model.addAttribute("products", products);
		return "/products/newProduct.jsp";
	}
	
	
	@RequestMapping(value="/products/new", method=RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute ("product") Product product, 
			BindingResult result, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		} 
		
		if(result.hasErrors()) {
			return "/products/newProduct.jsp";
        } else {
        	productSvc.addProduct(product);
			return "redirect:/products/add";
        }
	}
	
	
	@RequestMapping("/products/{id}")
	public String showProductPage(@PathVariable("id") Long id,
										Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		
		// get the product by it's id
		Product product = productSvc.getProductById(id);
		
		// get a list of categories not currently assigned to the product 
		List<Category> availCat = categorySvc.findByProductsNotContaining(product);
		
		// add the products and the categories to the model
		model.addAttribute("product", product);
		model.addAttribute("availCat", availCat);
		
		// load the jsp page
		return "/products/showProduct.jsp";
	}
	
	@RequestMapping(value="/products/{id}/edit", method=RequestMethod.POST)
	public String getProductsByCategory(@PathVariable("id") Long id, 
							@RequestParam("category_id") Long category_id) {
		
		Product my_product = productSvc.getProductById(id);
		Category my_category = categorySvc.getCategoryById(category_id);
		
		my_product.getCategories().add(my_category);
		productSvc.editProduct(my_product);
		
		return "redirect:/dashboard";
	}

}
