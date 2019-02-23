# HaagaTalk prototype

personal project for Server programming course

## TO-DO LIST
- [ ] create required domains
  - [ ] user: what attributes do I need for firebase?
  - [X] Course{ courseCode, courseName, teacherId}
    - calendar implementation for course time?
    - coursetime removed for now, may add later
  - [X] Teacher{ teacherId, firstName, lastName}
  - [X] Comments{ commentId, courseCode, username, comment}
- [X] create Controller
- [ ] create Views
  - [ ] login page
  - [ ] main(?) page
  - [ ] signup page
  - [ ] admin page maybe?
- [ ] user authentication with firebase
  - [ ] setup Spring security with firebase
  - [ ] define authority to pages
- [ ] test the server with dummy data
- [ ] deploy server and test

### SELF NOTES

- mongoDB requires the id type to be a String, not Long

### References

- [Basic writing and formatting README.md](https://help.github.com/en/articles/basic-writing-and-formatting-syntax)
- [firebase authentication](https://firebase.google.com/docs/auth/admin/manage-users)
- [MongoDB documentation](http://mongodb.github.io/mongo-java-driver/?_ga=2.72866069.703837665.1550930650-1251151850.1549826134)
- [Accessing Data with MongoDB - Spring boot](https://spring.io/guides/gs/accessing-data-mongodb/)
- [Installing and running MongoDB](https://docs.mongodb.com/manual/tutorial/install-mongodb-on-windows/#run-mongodb-from-cmd)