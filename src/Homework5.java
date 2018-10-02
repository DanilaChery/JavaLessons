/**
 * Created by Валентин on 02.10.2018.
 */
public class Homework5 {
    public static void main(String[] args) {


    Employee[] employees = new Employee[5];
    employees[0] = new Employee("Черёмухин","Данил","Романыч","God","email@email.com","+79780212680",1,100);
    employees[1] = new Employee("Черёмухин","Даниил","Романыч","preGod","email@email.com","+79780212680",1,1);
    employees[2] = new Employee("Черёмухин","Данила","Романыч","Human","email@email.com","+79780212680",1,32);
    employees[3] = new Employee("Черёмухин","Дань","Романыч","somebody","email@email.com","+79780212680",1,48);
    employees[4] = new Employee("Черёмухин","Сергей","Романыч","bodysome","email@email.com","+79780212680",1,65);

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].age >= 40){
                employees[i].printEmployee();
            }
        }
    }
}
