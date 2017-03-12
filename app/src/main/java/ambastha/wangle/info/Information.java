package ambastha.wangle.info;

/**
 * Created by shubham on 3/11/2017.
 */

public class Information {
    private String empid;
    private String password;
    private String emailid;

    private String phone_no;
    public Information(String empid,String password,String emailid,String phone_no)
    {
this.empid=empid;
        this.password=password;
        this.emailid=emailid;
        this.phone_no=phone_no;

    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

}
