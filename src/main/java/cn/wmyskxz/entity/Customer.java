package cn.wmyskxz.entity;

public class Customer {
    public String identityId;
    public String name;
    public String sex;
    public String phone;

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString(){
        return "identityId="+identityId+" name="+name+" phone="+phone+" sex="+sex;
    }
}
