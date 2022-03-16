package hh.swd20.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	// http://localhost:8080/categorylist
	@RequestMapping(value="/categorylist")
	public String categorylist(Model model) {
		model.addAttribute("categories", categoryRepository.findAll());
		
		return "categorylist"; // categorylist.html
	}
	
	// http://localhost:8080/addcategory
	@RequestMapping(value = "/addcategory")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		
		return "addcategory"; // addcategory.html
	}
	
	// http://localhost:8080/save
	@RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
	public String saveCategory(Category category) {
		categoryRepository.save(category);
			
		return "redirect:/categorylist"; // return to categorylist.html
	}
	
	// http://localhost:8080/delete/{id}
		@RequestMapping(value = "/deleteCategory/{id}", method = RequestMethod.GET)
		// Vain ADMIN voi poistaa
	    @PreAuthorize("hasAuthority('ADMIN')")
		public String deleteCategory(@PathVariable("id") Long categoryId, Model model) {
			categoryRepository.deleteById(categoryId);
			
			return "redirect:/categorylist"; // return to categorylist.html
		}
}
