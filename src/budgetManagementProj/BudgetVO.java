package budgetManagementProj;

import java.util.Date;

public class BudgetVO {
  //저장될 데이터: 항목번호(int), 지출수입(int), 수입/치출 토탈(int), 기입날짜(Date), 항목(String)
  
  //항목 번호-출력되지 않고 내부적으로 사용됨 
  private int contentNum;
  //기록당시 잔고 저장
  private int balance;
  //money (수입/지출 토탈)
  private int money;
  //기입일
  private Date addDate;
  //항목
  private String desc;
  
  //Getter and Setter
  public int getBalance() {
    return balance;
  }
  public void setBalance(int balance) {
    this.balance = balance;
  } 
  public int getMoney() {
    return money;
  }
  public void setMoney(int money) {
    this.money = money;
  }
  public Date getAddDate() {
    return addDate;
  }
  public void setAddDate(Date addDate) {
    this.addDate = addDate;
  }
  public String getDesc() {
    return desc;
  }
  public void setDesc(String desc) {
    this.desc = desc;
  }
  public int getContentNum() {
    return contentNum;
  }
  public void setContentNum(int contentNum) {
    this.contentNum = contentNum;
  }
  
  
}
