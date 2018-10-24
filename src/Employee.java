/**
 * Created by Валентин on 02.10.2018.
 */
public class Employee {

    public String lastname;
    public String firstname;
    public String patronymic;
    public String post;
    public String email;
    public String telephone;
    public int pay;
    public int age;

    public Employee(String lastname, String firstname, String patronymic, String post, String email, String telephone, int pay, int age){
        this.lastname = lastname;
        this.firstname = firstname;
        this.patronymic = patronymic;
        this.post = post;
        this.email = email;
        this.telephone = telephone;
        this.pay = pay;
        this.age = age;
    }
    public  void printEmployee(){
        System.out.println("The associate "+ this.lastname + " " + this.firstname + " " + this.patronymic +". His age is " + this.age+".His post is "+ this.post + ". Have pay " + this.pay  + ". His email and Telephone is " + this.email + " and " + this.telephone);
    }
}

