package gms;

import java.sql.Date;

/**
 *
 * @author USER
 */
public class Member extends Person{
    protected Date start_date;
    protected float fee;

    

    public Member(int i, String n, String p,Date s,float f) {
        super(i, n, p);
        start_date=s;
        fee=f;
    }

    public Date getStart_date() {
        
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }
   
 }