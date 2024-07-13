Resources: Books, Authors, Borrowers
Relationships:
Many-to-many: Books and Authors (a book can have multiple authors, and an author can write multiple books)
Many-to-one/One-to-many: Borrowers and Books (a borrower can borrow multiple books, but each book is borrowed by one borrower at a time)
Endpoints:
GET all books, GET all authors
POST a new book, POST a new author
GET a single book, GET a single author
PUT to update book details, PUT to update author details
DELETE a book, DELETE an author



Data is stored in a Postgresql database
Data access is implemented with a Spring Data JPA Repository
Request/Response is handled with a Spring Web MVC RestController
At least three resources
At least one Many-to-many relationship
At least one Many-to-one/One-to-many relationship
Required endpoints
At least two endpoints supporting GET to retrieve the collection of all entries of a resource
At least two endpoints supporting POST to create a new entry of a resource
At least two endpoints supporting GET to retrieve a single entry of a resource
At least two endpoints supporting PUT to update a single entry of a resource
At least two endpoints supporting DELETE to delete a single entry of a resource