package gms;
/**
 /*
 * @author USER
 */
public class Person {
     protected int id;
       protected String name;
       protected String phnNo;
       
       public Person(int i,String n,String p)
       {
           id=i;
           name=n;
           phnNo=p;
       }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhnNo() {
        return phnNo;
    }

    public void setPhnNo(String phnNo) {
        this.phnNo = phnNo;
    }

    
}