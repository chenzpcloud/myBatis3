package chenzpMybatis.BaseTest.OurExtend;

public abstract class ParentClass {

    private  String name;

    private  String sex;

    private  String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ParentClass(String names,String sexs){
        name=names;
        sex=sexs;
    }


    @Override
    public String toString() {
        return "ParentClass{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
