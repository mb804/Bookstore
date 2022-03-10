package hh.swd20.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.CategoryRepository;

@CrossOrigin
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
	
	// Show full booklist
	// http://localhost:8080/booklist
	@RequestMapping(value = "/booklist")
	public String bookList(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		
		return "booklist"; // booklist.html
	}
	
	// RESTful service to get all books
	// Java-kielinen Book-luokan oliolista muunnetaan JSON-booklistaksi ja lähetetään web-selaimelle vastauksena
	@RequestMapping(value="/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest() {
		
	    return (List<Book>) bookRepository.findAll();
	}
	
	// RESTful service to get book by id
    @RequestMapping(value="/books/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
    	
    	return bookRepository.findById(bookId);
    }
    
    // RESTful service to save new book
    // POST = uuden tiedon lisäystä
    @RequestMapping(value="/books", method = RequestMethod.POST)
    public @ResponseBody Book saveBookRest(@RequestBody Book book) {	
    	return bookRepository.save(book);
    }
	
	// http://localhost:8080/addbook
	@RequestMapping(value = "/addbook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryRepository.findAll());
		
		return "addbook"; // return to addbook.html
	}
	
	// http://localhost:8080/save
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBook(Book book) {
		bookRepository.save(book);
		
		return "redirect:/booklist"; // return to redirect:/booklist.html
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
