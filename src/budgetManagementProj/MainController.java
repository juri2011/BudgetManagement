package budgetManagementProj;

import java.util.Scanner;

public class MainController {
  public static void help() {
    //도움말 출력
    System.out.println("1. 추가 : add 잔액");
    System.out.println("2. 수입 : income 수입금액 항목");
    System.out.println("3. 지출 : expense 지출금액 항목");
    System.out.println("4. 내용 변경 : edit");
    System.out.println("5. 전체 내역 출력 : list");
    System.out.println("6. 항목별 출력 : info 항목명");
    System.out.println("7. 도움말 : help");
    System.out.println("8. 종료 : exit");
    System.out.println();
  }
  public static void main(String[] args) {
    //main
    System.out.println("가계부 프로그램입니다.");
    Scanner sc = new Scanner(System.in);
    while(true) {
      String userInput = sc.nextLine();
      
    }
    
  }//end of main
}
