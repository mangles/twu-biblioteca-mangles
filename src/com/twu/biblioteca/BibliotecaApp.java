package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.setup();

    }
    private void setup(){
        welcomeMessage();
        Login login = defineSomeUsers();
        if (login.authenticateUser()){
            Library library = defineSomeBooksAndMovies();
            MainMenu mainMenu = new MainMenu(library);
            mainMenu.selectOption();
        }else{
            System.out.println(Enumerations.Messages.LOGIN_FAILURE);
        }
    }

    public void welcomeMessage() {
        System.out.println(Enumerations.Messages.WELCOME);

    }

    public Login defineSomeUsers() {
        Login login = new Login();
        User u1 = new User("189-2017", "MyPassword1");
        User u2 = new User("814-2012", "MyPassword2");
        login.addUsers(u1);
        login.addUsers(u2);
        return login;

    }

    private Library defineSomeBooksAndMovies(){
        Library library = new Library();
        Elements b1 = new Book("Awesome book 1", "Author 1", 2017);
        Elements b2 = new Book("Awesome book 2", "Author 2", 2016);
        Elements b3 = new Book("Awesome book 3", "Author 3", 2015);
        library.addElements(b1);
        library.addElements(b2);
        library.addElements(b3);
        Elements m1 = new Movie("Awesome movie 1", "Director 1", 2017, 9.0);
        Elements m2 = new Movie("Awesome movie 2", "Director 2", 2016, 8.0);
        Elements m3 = new Movie("Awesome movie 3", "Director 3", 2015, 5.4);
        library.addElements(m1);
        library.addElements(m2);
        library.addElements(m3);
        return library;

    }

}
