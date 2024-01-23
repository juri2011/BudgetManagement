package budgetManagementProj;

import java.util.Date;

public class BudgetVO {
  //저장될 데이터: 항목번호(int) 잔액(int), 수입(int), 지출수입(int), 기입날짜(Date), 항목(String)
  
  //항목 번호-출력되지 않고 내부적으로 사용됨 
  private int contentNum;
  //잔액
  private int balance;
  //수입
  private int income;
  //지출
  private int expense;
  //기입일
  private Date date;
  //항목
  private String desc;
  
  //Getter and Setter
  public int getBalance() {
    return balance;
  }
  public void setBalance(int balance) {
    this.balance = balance;
  }
  public int getIncome() {
    return income;
  }
  public void setIncome(int income) {
    this.income = income;
  }
  public int getExpense() {
    return expense;
  }
  public void setExpense(int expense) {
    this.expense = expense;
  }
  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
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
