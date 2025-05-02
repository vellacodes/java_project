//employee class to store employee information

public class Employee {
    private String username;
    private String password;
    private String role;
    private String name;
    private String lastName;

    public Employee(String username, String password, String role, String name, String lastName) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getRole(){
        return role;
    }
    public String getName(){
        return name;
    }
    public String getLastName(){
        return lastName;
    }
}
