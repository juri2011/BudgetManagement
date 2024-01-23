package budgetManagementProj;

import java.util.Date;

public class RequestDTO {
  
  //사용자로부터 전달받은 데이터 저장클래스 
  //저장될 데이터: 잔액(int), 수입(int), 지출수입(int), 기입날짜(Date), 항목(String)
  private int balance;
  private int income;
  private int expense;
  private Date date;
  private String desc;
  
  //생성자 함수 작성.
  public RequestDTO(int balance, int income, int expense, Date date, String desc) {
    this.balance = balance;
    this.income = income ;
    this.expense = expense;
    this.date = date;
    this.desc = desc ;
    
  }
}
