package chenzpMybatis.BaseTest.OurExtend;

public class ChildClass extends  ParentClass {

    private  String faver;

    private  String email;

    public String getFaver() {
        return faver;
    }

    public void setFaver(String faver) {
        this.faver = faver;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public  ChildClass (String faver, String email){
        super("chenzp","male");
        this.faver=faver;
        this.email=email;
    }


    @Override
    public String toString() {
        return "ChildClass{" +
                "faver='" + faver + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
