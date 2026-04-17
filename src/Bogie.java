public class Bogie {

    String id;
    String type;

    public Bogie(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public void display() {
        System.out.println("Bogie ID: " + id + ", Type: " + type);
    }
}