# HaagaTalk prototype

personal project for Server programming course

## TO-DO LIST
- [X] create required domains
  - [X] user: { id, username, password, role }
  - [X] Course{ courseCode, courseName, teacherId}
    - calendar implementation for course time?
    - coursetime removed for now, may add later
  - [X] Teacher{ teacherId, firstName, lastName}
  - [X] Comments{ commentId, courseCode, username, comment}
- [X] create Controller
- [X] create Views
  - [X] login page
  - [X] main(?) page
  - [X] signup page
  - [X] admin page maybe?
- [X] Create repositories for all domains
  - [X] userRepository
  - [X] teacherRepository
  - [X] courseRepository
  - [X] commentRepository
- [X] Create a page to show all the comments of a course  
- [X] Create add comment feature
- [ ] Create validation when adding comments
- [X] Create delete comment feature
- [X] Create edit comment feature
  - [X] Make so only ADMIN and user can edit/delete?
  - how do I deal with anonymous comments in this case?
  
- [ ] JOIN collections from mongo db?
  - do I need this?
  - different data structure for mongo db maybe? maybe?
  
- [X] bootstrap application!
- [X] test the server with dummy data
- [X] deploy server and test

- [ ] change user authentication to firebase
  - [ ] setup Spring security with firebase
  - [ ] define authority to pages

### SELF NOTES

- mongoDB requires the id type to be a String, not Long
- springSecurity5 requires the password to be encoded in any way
- concating th:text works with |. example: "|${var1} no need to add 's! ${var2}|"
- thymeleaf form th:field technically creates a name attribute with the given value. Can I design this in another way? Course Comment add function<

- I don't need authentication for everyone for now, just ADMIN for console?
- can I configure the login page to be a popup instead of a whole page?
- config redirection after logout session => logoutSuccessUrl() in WebConfig

- study @document(collection="collection_name") annotation
- may have to think of a different database structure for mongoDB?

### References

- [Basic writing and formatting README.md](https://help.github.com/en/articles/basic-writing-and-formatting-syntax)
- [W3schools: Node.js MongoDB](https://www.w3schools.com/nodejs/nodejs_mongodb.asp)
- [MongoDB documentation](http://mongodb.github.io/mongo-java-driver/?_ga=2.72866069.703837665.1550930650-1251151850.1549826134)
  - [One-to-Many-Relations](https://docs.mongodb.com/manual/tutorial/model-referenced-one-to-many-relationships-between-documents/)
  - [Query documents](https://docs.mongodb.com/manual/tutorial/query-documents/)
  - [MongoDB CRUD operations](https://docs.mongodb.com/v3.2/tutorial/remove-documents/)
- [Accessing Data with MongoDB - Spring boot](https://spring.io/guides/gs/accessing-data-mongodb/)
- [Installing and running MongoDB](https://docs.mongodb.com/manual/tutorial/install-mongodb-on-windows/#run-mongodb-from-cmd)
- [Configuring logout in Spring](https://www.baeldung.com/spring-security-logout)
- [Standard URL syntax - thymeleaf](https://www.thymeleaf.org/doc/articles/standardurlsyntax.html)
- [Heroku dev center: configuration and config vars](https://devcenter.heroku.com/articles/config-vars)
- [firebase authentication](https://firebase.google.com/docs/auth/admin/manage-users)