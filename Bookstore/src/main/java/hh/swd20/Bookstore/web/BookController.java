package hh.swd20.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.Bookstore.domain.Book;

@Controller
public class BookController {
	
	// http://localhost:8080/index
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String indexBookstore(Model model) {
		
		return "index"; // index.html
	}
}
