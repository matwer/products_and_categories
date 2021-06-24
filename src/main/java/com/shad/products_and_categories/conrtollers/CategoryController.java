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
public class CategoryController {
	private final CategoryService categorySvc;
	private final ProductService productSvc;
	
	public CategoryController(CategoryService categorySvc, ProductService productSvc) {
		this.categorySvc = categorySvc;
		this.productSvc = productSvc;
	}
	
	
	@RequestMapping("/categories/add")
	public String showCategoryForm(@ModelAttribute ("category") Category category, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		} else {		
			return "/categories/newCategory.jsp";
		}
	}
	
	
	@RequestMapping(value="/categories/new", method=RequestMethod.POST)
	public String addCategory(@Valid @ModelAttribute ("category") Category category, 
								BindingResult result, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		
		if(result.hasErrors()) {
			return "/categories/newCategory.jsp";
        } else {
        	categorySvc.addCategory(category);
			return "redirect:/categories/add";
        }
	}
	
	
	@RequestMapping("/categories/{id}")
	public String getCategoriesByProducts(@PathVariable("id") Long id, 
										@ModelAttribute("category") Category category, 
										Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/login";
		}
		
		// get the category by it's id
		Category c = categorySvc.getCategoryById(id);
		
		// get a list of categories not currently assigned to the product 
		List<Product> availPrd = productSvc.findByCategoriesNotContaining(category);
		
		// add the products and the categories to the model
		model.addAttribute("category", c);
		model.addAttribute("availPrd", availPrd);
		
		return "/categories/showCategory.jsp";
	}
	
	@RequestMapping(value="/categories/{id}/edit", method=RequestMethod.POST)
	public String getCategoriesByProduct(@PathVariable("id") Long id, 
							@RequestParam("product_id") Long product_id) {
		
		Category my_category = categorySvc.getCategoryById(id);
		Product my_product = productSvc.getProductById(product_id);
		
		my_category.getProducts().add(my_product);
		categorySvc.editCategory(my_category);
		
		return "redirect:/dashboard";
	}
	
}
