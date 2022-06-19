package pl.coderslab.utils;

public class MainDao {
    public static void main(String[] args) {
//        User user = new User();
//        user.setUsername("Johny");
//        user.setEmail("test6@mail.com");
//        user.setPassword("hasełko");

//        UserDao userDao = new UserDao();
//        userDao.create(user);
//        System.out.println(user.toString());

//        UserDao userDao = new UserDao();
//        User user = userDao.read(1);
//
//        if (user == null) {
//            System.out.println("Nie ma takiego użytkownika");
//        } else {
//            System.out.println(user.getUsername());
//        }

//        UserDao userDao = new UserDao();
//        User user = userDao.read(1);
//        user.setUsername("Bruno");
//        user.setEmail("testowyemail@gmail.com");
//        userDao.update(user);

//        UserDao userDao = new UserDao();
//        userDao.delete(3);

        UserDao userDao = new UserDao();
        User[] users = userDao.findAll();
        printUsers(users);

    }

    public static void printUsers(User[] users) {
        for (int i =0; i < users.length; i++) {
            System.out.println(users[i].getId() + " " + users[i].getUsername() + " " + users[i].getEmail());
        }
    }
}
