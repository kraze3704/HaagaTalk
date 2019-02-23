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
- [ ] Create repositories for all domains
  - [X] userRepository
  - [ ] teacherRepository
  - [ ] courseRepository
  - [ ] commentRepository
- [ ] Create a page to show all the comments of a course
- [ ] Create a page to add a comment to a course
- [ ] change user authentication to firebase
  - [ ] setup Spring security with firebase
  - [ ] define authority to pages
- [ ] bootstrap application!
- [ ] test the server with dummy data
- [ ] deploy server and test

### SELF NOTES

- mongoDB requires the id type to be a String, not Long
- springSecurity5 requires the password to be encoded in any way

- I don't need authentication for everyone for now, just ADMIN for console?
- can I configure the login page to be a popup instead of a whole page?
- config redirection after logout session => logoutSuccessUrl() in WebConfig

### References

- [Basic writing and formatting README.md](https://help.github.com/en/articles/basic-writing-and-formatting-syntax)
- [firebase authentication](https://firebase.google.com/docs/auth/admin/manage-users)
- [MongoDB documentation](http://mongodb.github.io/mongo-java-driver/?_ga=2.72866069.703837665.1550930650-1251151850.1549826134)
  - [One-to-Many-Relations](https://docs.mongodb.com/manual/tutorial/model-referenced-one-to-many-relationships-between-documents/)
  - [Query documents](https://docs.mongodb.com/manual/tutorial/query-documents/)
- [Accessing Data with MongoDB - Spring boot](https://spring.io/guides/gs/accessing-data-mongodb/)
- [Installing and running MongoDB](https://docs.mongodb.com/manual/tutorial/install-mongodb-on-windows/#run-mongodb-from-cmd)
- [Configuring logout in Spring](https://www.baeldung.com/spring-security-logout)
