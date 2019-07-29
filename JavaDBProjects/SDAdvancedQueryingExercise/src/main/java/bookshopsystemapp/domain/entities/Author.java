package bookshopsystemapp.domain.entities;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "authors")
@NamedStoredProcedureQuery(name = "getBookCountByAuthorName",
        procedureName = "usp_count_written_books",
        parameters = {@StoredProcedureParameter(name = "full_name", mode = ParameterMode.IN, type = String.class)})
public class Author extends BaseEntity {

    private String firstName;
    private String lastName;
    private Set<Book> books;

    public Author() {
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Transient
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    @OneToMany(targetEntity = Book.class, mappedBy = "author", fetch = FetchType.EAGER)
    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
