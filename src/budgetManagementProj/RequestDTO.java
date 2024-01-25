package budgetManagementProj;

import java.util.Date;

public class RequestDTO {
  
  //사용자로부터 전달받은 데이터 저장클래스 
  //저장될 데이터: 잔액(int), 수입(int), 지출수입(int), 기입날짜(Date), 항목(String)
  private int contentNum;
  private int balance;
  private String desc;
  private long money;
  private String memo;

  
  
  //생성자 함수 작성.
  public RequestDTO(int contentNum, String desc, long money,String memo) throws MinusMoneyException{
    if(money<0) throw new MinusMoneyException();
    this.contentNum = contentNum;
    this.desc = desc;
    this.money = money;
    this.memo = memo;
       
  }



  public int getContentNum() {
    return contentNum;
  }



  public void setContentNum(int contentNum) {
    this.contentNum = contentNum;
  }



  public int getBalance() {
    return balance;
  }



  public void setBalance(int balance) {
    this.balance = balance;
  }



  public String getDesc() {
    return desc;
  }



  public void setDesc(String desc) {
    this.desc = desc;
  }



  public long getMoney() {
    return money;
  }



  public void setMoney(long money) {
    this.money = money;
  }




  public String getMemo() {
    return memo;
  }



  public void setMemo(String memo) {
    this.memo = memo;
  }
  
  //getter 와 setter
  
}
