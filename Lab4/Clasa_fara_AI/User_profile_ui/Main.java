public class Main {

    public static void main(String[] args) {
        Person user = new Person("alex123", "alex@email.com");

        user.setFirstName("Alex");
        user.setLastName("Popescu");
        user.setBio("Smart home enthusiast");
        user.setLocation("Bucharest");

        user.displayProfile();

    }
}