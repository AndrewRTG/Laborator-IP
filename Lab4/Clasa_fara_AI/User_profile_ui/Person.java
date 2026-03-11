public class Person {

    private Long id;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String bio;
    private String location;

    public Person(String username, String email) {
        this.username = username;
        this.email = email;
    }
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBio() {
        return bio;
    }

    public String getLocation() {
        return location;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    void updateProfile(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    void changePassword(String newPassword){
        this.password = newPassword;
    }
    public void displayProfile() {
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
        System.out.println("Bio: " + bio);
        System.out.println("Location: " + location);
    }
}