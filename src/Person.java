import java.util.List;


public class Person {
    String name;
    boolean isSafe;
    boolean peutInfecter;
    boolean isDead;
    int age;
    List<String> variants;
    List<Person> relation;
    Person amiConnexe;

    public Person(String name, boolean isSafe, boolean peutInfecter, boolean isDead, int age, List<String> variants, List<Person> relation) {
        this.name = name;
        this.isSafe = isSafe;
        this.peutInfecter = peutInfecter;
        this.isDead = isDead;
        this.age = age;
        this.variants = variants;
        this.relation = relation;
    }
}
