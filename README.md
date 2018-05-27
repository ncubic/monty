# Monty

This project was created with [Spring framework](https://spring.io/).

This is a simple project for inserting and viewing jokes.

  - View all jokes in the database with categories and like/dislike count
  - Like or dislike a joke
  - As authorized user insert a new joke
  
Jokes are saved in memory with H2 database. Categories and users are created on application start.

### Installation

This project requires [Maven](https://maven.apache.org/) build tool.

After cloning the project either build it with the following command (will run tests):

```sh
$ cd monty
$ mvn clean package
```

or simply run it with:

```sh
$ cd monty
$ mvn spring-boot:run
```

### Additional used software

| Name | Link |
| ------ | ------ |
| Bootstrap | https://getbootstrap.com/ |
| JQuery | https://jquery.com/ |
| Font Awesome | https://fontawesome.com/ |
| Open Sans font | https://fonts.google.com/specimen/Open+Sans |