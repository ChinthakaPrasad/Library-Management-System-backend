package src.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import src.dto.Book;
import src.entity.BookEntity;
import src.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
@CrossOrigin
public class BookController {
    final private BookService bookService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping("/getBooks")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @DeleteMapping("/{id}")
    public Boolean deleteBook(@PathVariable Long id){
        System.out.println("Delete method execute");
        return bookService.deleteBook(id);
    }

    @PostMapping("/updateBook")
    public boolean updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }
}
