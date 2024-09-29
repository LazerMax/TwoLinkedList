public class Minion {
    private String name;
    private int age;

    public Minion(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Minion{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}