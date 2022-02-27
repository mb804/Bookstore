package hh.swd20.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	// http://localhost:8080/index
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String indexBookstore(Model model) {
		
		return "index"; // index.html
	}
	
	// http://localhost:8080/booklist
	@RequestMapping(value = "/booklist")
	public String bookList(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		
		return "booklist"; // booklist.html
	}
	
	// http://localhost:8080/addbook
	@RequestMapping(value = "/addbook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryRepository.findAll());
		
		return "addbook"; // addbook.html
	}
	
	// http://localhost:8080/save
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBook(Book book) {
		bookRepository.save(book);
		
		return "redirect:/booklist"; // return to booklist.html
	}
	
	// http://localhost:8080/delete/{id}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		bookRepository.deleteById(bookId);
		
		return "redirect:/booklist"; // return to booklist.html
	}
	
	// http://localhost:8080/editbook/{id}
	@RequestMapping(value = "/editbook/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", bookRepository.findById(bookId));
		model.addAttribute("categories", categoryRepository.findAll());
		
		return "/editbook"; // editbook.html
	}
}
