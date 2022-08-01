package entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Set;

public class MyDAO{
    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction et;

    public MyDAO(){
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        et = em.getTransaction();
    }

    public void beginTransaction(){
        et.begin();
    }

    public void commitTransaction(){
        et.commit();
    }


    public Set<BookEntity> getBookInLibrary(int addressLibrary){
        LibraryEntity le = em.find(LibraryEntity.class,addressLibrary);
        return le.getBookSet();
    }

    public ReaderEntity getTeacherOrStudent(int ID){
        return em.find(ReaderEntity.class,ID);
    }

    public void deleteBook(int bookNumber){
        beginTransaction();
        BookEntity book = em.find(BookEntity.class, bookNumber);
        em.remove(book);
        System.out.println("Remove book "+ book.toString());
        commitTransaction();
    }

    // next 5 function with transaction

    // 1 add
    public void addNewBook(int id, String stateBook, String category, String title, int libraryID){
        beginTransaction();
        BookEntity newBook = new BookEntity();
        HasEntity has = new HasEntity();
        newBook.setNumberbook(id);
        newBook.setStatebook(stateBook);
        newBook.setTitle(title);
        newBook.setCategory(category);
        em.persist(newBook);
        has.setCodelibraryhas(libraryID);
        has.setHasnumberbook(id);
        em.persist(has);
        System.out.println("add Book " + newBook);
        System.out.println("add Has "+ has);
        commitTransaction();
    }

    // 2 add
    public void addNewReader(int ID, String name, String mail, String address, int numberBookOfAvailable, String degree){
        beginTransaction();
        ReaderEntity newReader = null;
        AccountlibraryandUserEntity accUser = new AccountlibraryandUserEntity();
        if(Objects.equals(degree, "master") || Objects.equals(degree, "doctor")){
            newReader = new TeacherEntity();
        }else if (Objects.equals(degree, "bachelor")){
            newReader = new StudentEntity();
        }else{
            System.err.println("ERROR: invalid degree");
        }

        assert newReader != null;
        newReader.setReaderid(ID);
        newReader.setNamereader(name);
        newReader.setMail(mail);
        newReader.setAddress(address);
        newReader.setNumberofbooksavailabel(numberBookOfAvailable);
        if(newReader instanceof TeacherEntity) {
            ((TeacherEntity) newReader).setDegree(degree);
        }else {
            ((StudentEntity) newReader).setDegree(degree);
        }
        em.merge(newReader);
        accUser.setAccountnumber(ID-1370);
        accUser.setOwner(ID);
        accUser.setBalance(400);
        em.persist(accUser);

        System.out.println("add Reader" + newReader);
        System.out.println("add AccountUser + " + accUser);
        commitTransaction();
    }

    // 3 add
    public void addNewLibrary(int id, String nameLibrary, int capacity){
        beginTransaction();
        LibraryEntity le = new LibraryEntity();
        AccountlibraryandUserEntity accLib = new AccountlibraryandUserEntity();
        le.setLibrarycode(id);
        le.setCapacity(capacity);
        le.setNamelibrary(nameLibrary);
        em.persist(le);

        accLib.setAccountnumber(id*1234);
        accLib.setBalance(1000);
        accLib.setOwner(id);
        em.persist(accLib);
        System.out.println("add Library " + le);
        System.out.println("add library account " + accLib);
        commitTransaction();
    }

    // 4 add
    public void addNewPenalty(int readerPenaltyID, int penalize){
        beginTransaction();
        PenaltyEntity pe = new PenaltyEntity();
        pe.setReaderpenalty(readerPenaltyID);
        pe.setPenalize(penalize);
        em.persist(pe);
        System.out.println("add Penalty " + pe);
        commitTransaction();
    }

    // 5 transaction
    @Transactional//(isolation = Isolation.SERIALIZABLE)
    public boolean pay(int readerID, int readerAccount ,int libraryAccount){
        beginTransaction();
        int p1;
        int b1;
        int b2;
        PenaltyEntity pe = em.find(PenaltyEntity.class, readerID);
        AccountlibraryandUserEntity accUser = em.find(AccountlibraryandUserEntity.class,readerAccount);
        AccountlibraryandUserEntity accLibrary = em.find(AccountlibraryandUserEntity.class, libraryAccount);
        p1 = em.find(PenaltyEntity.class, readerID).getPenalize();
        b1 = em.find(AccountlibraryandUserEntity.class, readerAccount).getBalance();
        b2 = em.find(AccountlibraryandUserEntity.class,libraryAccount).getBalance();
        if(p1 < 0 || b1 < 0 || b2 < 0) return false;
        //update count of penalize
        pe.setPenalize(p1 - 1);
        em.merge(pe);

        //update balance account reader
        accUser.setBalance(b1 - 100);
        em.merge(accUser);

        //update balance account library
        accLibrary.setBalance(b2 + 100);
        em.merge(accLibrary);
        commitTransaction();
        return true;
    }
}
