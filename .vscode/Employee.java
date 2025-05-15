/**
 * Employee class to store employee information in files
 * @author Vella and Ameya
 * @version 1.0
*/
public class Employee {
    private String username;
    private String password;
    private String role;
    private String name;
    private String lastName;
    private String date;
    private String time;
/**
 * Employee object constructor
 * @param username - previously entered username
 * @param password - previously entered password
 * @param role -role of the employee
 * @param name - first name of the employee
 * @param lastName - last name of the employee
 * @param date - date of scheduled work
 * @param time - time of scheduled work
 */
    public Employee(String username, String password, String role, String name, String lastName, String date, String time) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.lastName = lastName;
        this.date = date;
        this.time = time;
    }
/**
 * Getter for employee username
 * @return - username of employee
 */
    public String getUsername() {
        return username;
    }
/**
 * Getter for employee password
 * @return - password of employee
 */
    public String getPassword(){
        return password;
    }
/**
 * Getter for employee role
 * @return - role of employee
 */
    public String getRole(){
        return role;
    }
/**
 * Getter for employee first name
 * @return - first name of employee
 */
    public String getName(){
        return name;
    }
/**
 * Getter for employee last name
 * @return - last name of employee
 */
    public String getLastName(){
        return lastName;
    }
/**
 * Getter for date of scheduled work
 * @return - date of scheduled work
 */
    public String getDate(){
        return date;
    }
/**
 * Getter for time of scheduled work
 * @return - time of scheduled work
 */
    public String getTime(){
        return time;
    }
}
