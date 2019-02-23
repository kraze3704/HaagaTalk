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


### References

- [Basic writing and formatting README.md](https://help.github.com/en/articles/basic-writing-and-formatting-syntax)
- [firebase authentication](https://firebase.google.com/docs/auth/admin/manage-users)
