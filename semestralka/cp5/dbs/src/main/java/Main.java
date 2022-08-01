import entity.*;

import java.util.Set;

public class Main {

    public static void main(String[] args) {

        MyDAO dao = new MyDAO();

        //MANY TO MANY WITH READ
        //return all books in library with libraryCode = 456
        Set<BookEntity> beS = dao.getBookInLibrary(456);
        System.out.println(beS.toString());

        //INHERITANCE
        //return info about student in library
        StudentEntity re = (StudentEntity) dao.getTeacherOrStudent(5463);
        System.out.println(re.toString());

        // 1 ADD TO DATABASE
        dao.addNewBook(111114, "In library", "Romance", "MyBook4", 123);

        // DELETE BOOK
//        dao.deleteBook(111111);

        // 2 ADD TO DATABASE
//        dao.addNewReader(4446,"Cal Oldport2","oldca2l32@gmail.com","161 3rd Parkway",12,"doctor");

        // 3 ADD TO DATABASE
//        dao.addNewLibrary(1,"NewLib",1);

        // 4 ADD TO DATABASE
//        dao.addNewPenalty(4444,3);

        // 5 TRANSACTION IN DATABASE WITH UPDATE
//        System.out.println(dao.pay(5533,1114,987654321));
    }
}
