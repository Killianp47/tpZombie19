import java.util.List;

public class Person {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSafe() {
        return isSafe;
    }

    public void setSafe(boolean safe) {
        isSafe = safe;
    }

    public boolean isPeutInfecter() {
        return peutInfecter;
    }

    public void setPeutInfecter(boolean peutInfecter) {
        this.peutInfecter = peutInfecter;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getVariants() {
        return variants;
    }

    public void setVariants(List<String> variants) {
        this.variants = variants;
    }

    public List<Person> getRelation() {
        return relation;
    }

    public void setRelation(List<Person> relation) {
        this.relation = relation;
    }

    public Person getAmiConnexe() {
        return amiConnexe;
    }

    public void setAmiConnexe(Person amiConnexe) {
        this.amiConnexe = amiConnexe;
    }

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
