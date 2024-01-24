package budgetManagementProj;

import java.util.Date;

public class RequestDTO {
  
  //사용자로부터 전달받은 데이터 저장클래스 
  //저장될 데이터: 잔액(int), 수입(int), 지출수입(int), 기입날짜(Date), 항목(String)
  private int contentNum;
  private int balance;
  private String desc;
  private int money;
  private Date adddate;
  private String memo;

  
  
  //생성자 함수 작성.
  public RequestDTO(int contentNum, String desc, int money,String memo, Date addDate) {
    this.contentNum = contentNum;
    this.desc = desc;
    this.money = money;
    this.memo = memo;
    this.adddate = addDate;    
  }
}
