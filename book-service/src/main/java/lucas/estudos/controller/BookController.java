package lucas.estudos.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lucas.estudos.model.Book;
import lucas.estudos.proxy.CambioProxy;
import lucas.estudos.repository.BookRepository;
import lucas.estudos.response.Cambio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Tag(name = "Book endpoint")
@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CambioProxy proxy;

    /*
    @GetMapping(value = "/{id}/{currency}")
    public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency) {

        var book = bookRepository.getById(id);
        if (book == null) {
            throw new RuntimeException("Book not Found");
        }

        HashMap<String, String> params = new HashMap<>();

        params.put("amount", book.getPrice().toString());
        params.put("from", "USD");
        params.put("to", currency);

       var response =  new RestTemplate()
                .getForEntity("http://localhost:8000/cambio-service/{amount}/{from}/{to}", Cambio.class,
                params);

        var port = environment.getProperty("local.server.port");
        book.setPrice(response.getBody().getConvertedValue());

        book.setEnvironment(port);

        return book;
    }
     */

    @Operation(summary = "Find a specific book by your ID")
    @GetMapping(value = "/{id}/{currency}")
    public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency) {

        var book = bookRepository.getById(id);
        if (book == null) {
            throw new RuntimeException("Book not Found");
        }

        var cambio = proxy.getCambio(book.getPrice(),"USD", currency);

        var port = environment.getProperty("local.server.port");
        book.setPrice(cambio.getConvertedValue());

        book.setEnvironment("Book port" + port + " Cambio Port" + cambio.getEnvironment());

        return book;
    }



}
