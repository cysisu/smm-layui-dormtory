package cn.wmyskxz.entity;


import java.util.Date;

public class Order {
    private int orderId;
    private String roomNumber;
    private String identityId;
    private String workId;
    private String status;
    private Date inTime;
    private Date predictTime;
    private int days;
    private int price;
    private int totalMoney;
    private String label;
    private Date outTime;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public void setPredictTime(Date predictTime) {
        this.predictTime = predictTime;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getIdentityId() {
        return identityId;
    }

    public String getWorkId() {
        return workId;
    }

    public String getStatus() {
        return status;
    }

    public Date getInTime() {
        return inTime;
    }

    public Date getPredictTime() {
        return predictTime;
    }

    public int getDays() {
        return days;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public String getLabel() {
        return label;
    }

    public Date getOutTime() {
        return outTime;
    }

    @Override
    public String toString(){
        return "orderId="+orderId+" roomNumber="+roomNumber+" identityId="+identityId+
                " workId="+workId+" status="+status+" inTime="+inTime+" predictTime="+predictTime+
                " days="+days+" price="+price+" totalMoney="+totalMoney+
                " label="+label+" outTime="+outTime;
    }
}
