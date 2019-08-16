package gms;
/**
 *
 * @author USER
 */
public class Trainer extends Person{
     protected float salary;

    public Trainer(int i, String n, String p,float sl) {
        super(i, n, p);
        salary=sl;
        
    }

    public double getSalary() {
        return salary;
    }
public void setSalary(float salary) {
        this.salary = salary;
    }
}
