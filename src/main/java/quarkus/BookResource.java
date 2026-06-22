package quarkus;

import java.util.List;
import java.util.NoSuchElementException;

import io.vertx.core.impl.NoStackTraceException;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/books")
@Transactional
public class BookResource {

    @Inject
    private BookRepository repo;

    @GET
    public List<Book> index(){
        return repo.listAll();

    }

    @POST
    public Book insert(Book insertedBook){
        repo.persist(insertedBook);
        return insertedBook;
    }

    @GET
    @Path("/{id}")
    public Book retrieve(@PathParam("id") Long id){
        var book = repo.findById(id);
        if (book != null){
            return book;
        }
        throw new NoSuchElementException("no hay libro con el ID: " + id);
    }

    @DELETE
    @Path("/{id}")
    public String delete(@PathParam("id") Long id){
        if(repo.deleteById(id)){
            return "Libro eliminado exitosamente";
        } else {
            return "No hay libro con id: " + id;
        }
    }

    @PUT
    @Path("/{id}")
    public Book update(@PathParam("id") Long id, Book book){
        var updateBook = repo.findById(id);
        if (updateBook != null){
            updateBook.setTitle(book.getTitle());
            updateBook.setDescription(book.getDescription());
            updateBook.setNumPages(book.getNumPages());
            updateBook.setPubDate(book.getPubDate());
            repo.persist(updateBook);
            return updateBook;
        } 
        throw new NoSuchElementException("no hay libro con el ID: " + id);
    }
}
