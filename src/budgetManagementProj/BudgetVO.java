package budgetManagementProj;

import java.util.Date;

public class BudgetVO {
  //저장될 데이터: 항목번호(int), 지출수입(int), 수입/치출 토탈(int), 기입날짜(Date), 항목(String)
  
  //항목 번호-출력되지 않고 내부적으로 사용됨 
  private int contentNum;
  //기록당시 잔고 저장
  //private int balance;
  //항목
  private String desc;
  //money (수입/지출 토탈)
  private int money;
  //메모
  private String memo;
  //기입일
  private Date addDate;
  
  
  public BudgetVO(int contentNum, String desc, int money, String memo, Date addDate) {
    this.contentNum = contentNum;
    this.desc = desc;
    this.money = money;
    this.memo = memo;
    this.addDate = addDate;
  }
  
  @Override
  public String toString() {
    return "BudgetVO [ desc="+ desc +",  money="+money+", memo="+ memo +"]";
  }
  
  //Getter and Setter
  public int getMoney() {
    return money;
  }
  public void setMoney(int money) {
    this.money = money;
  }
  
  public String getMemo() {
    return memo;
  }
  public void setMemo(String memo) {
    this.memo = memo;
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
