package budgetManagementProj;

import java.util.Scanner;

public class MainController {
  public static void help() {
    //도움말 출력
    System.out.println("1. 수입 추가 : income 수입금액 항목");
    System.out.println("2. 지출 추가 : expense 지출금액 항목");
    System.out.println("3. 내용 변경 : edit");
    System.out.println("4. 내용 삭제 : delete");
    System.out.println("5. 전체 내역 출력 : list");
    System.out.println("6. 항목별 출력 : info");
    System.out.println("7. 도움말 : help");
    System.out.println("8. 종료 : exit");
    System.out.println();
  }
  public static void main(String[] args) {
    //main
    System.out.println("가계부 프로그램입니다.");
    help();
    Scanner sc = new Scanner(System.in);
   
    //contentNum은 항목의 id와 같은 역할로, 항목이 새로 추가될 때마다 1씩 더하여 저장됩니다.
    //맨 처음 만들어지는 항목의 contentNum은 1이 될 것입니다.
    //항목의 contentNum은 항목을 삭제, 수정, 변경하기 위해 내부적으로 사용됩니다.
    //사용자는 contentNum을 직접 이용하지 않고, 프로그램이 제시하는 선택지를 통해 간접적으로 이용합니다.
    int contentNum = 1;
    
    while(true) {
    	
      System.out.println("명령문을 입력해주세요.");
      String userInput = sc.nextLine();
      String[] userInputs = userInput.split(" ");
      
      //1. 수입추가
      if(userInput.startsWith("income")) {
    	  
    	  //수입금액의 값을 받아올 int형 변수입니다.
    	  int income;
    	  
    	  //유효성 검사(income 수입금액 항목)
    	  if(userInputs.length!=3) {
    	    System.out.println("입력 형식이 올바르지 않습니다.");
    		  continue;
    	  }
    	  
    	  //예외처리(수입금액이 정수로 입력되지 않았을 경우)
    	  try {
    		  income = Integer.parseInt(userInputs[1]);
    	  }catch(NumberFormatException e) {
    		  System.out.println("수입금액이 올바른 형식으로 입력되지 않았습니다. 0 이상의 정수를 적어주십시오.");
    		  continue;
    	  }
    	  //예외처리(수입금액은 0 이상이어야함)
    	  try {
    	    RequestDTO dto = new RequestDTO(contentNum, "수입", income, userInputs[2]);
    	    BudgetAddService addSrv = new BudgetAddService();
    	  
    	    //BudgetAddService에 addIncome 메소드가 필요합니다.
    	    addSrv.addItem(dto);
    	  
    	    //명령이 추가되었으므로 다음 항목의 아이디가 될 contentNum의 값을 1 더합니다.
    	    contentNum++;
    	    System.out.println("성공적으로 등록되었습니다.");
    	  }catch(MinusMoneyException e) {
    	    System.out.println("에러가 발생했습니다! 원인: "+e.getMessage());
    	    continue;
    	  }
    	  
      }
      //2. 지출추가
      else if(userInput.startsWith("expense")) {
    	  int expense;
    	  
    	  //아래 들어갈 내용은 기본적으로 income 명령어와 같습니다.
    	  //수입금액의 값을 받아올 int형 변수입니다.
        
        //유효성 검사(income 수입금액 항목)
        if(userInputs.length!=3) {
          System.out.println("입력 형식이 올바르지 않습니다.");
          continue;
        }
        
        //예외처리(수입금액이 정수로 입력되지 않았을 경우)
        try {
          expense = Integer.parseInt(userInputs[1]);
        }catch(NumberFormatException e) {
          System.out.println("지출금액이 올바른 형식으로 입력되지 않았습니다. 0 이상의 정수를 적어주십시오.");
          continue;
        }
        //예외처리(수입금액은 0 이상이어야함)
        try {
          RequestDTO dto = new RequestDTO(contentNum, "지출", expense, userInputs[2]);
    	    BudgetAddService addSrv = new BudgetAddService();
    	    addSrv.addItem(dto);
    	    //명령이 추가되었으므로 다음 항목의 아이디가 될 contentNum의 값을 1 더합니다.
    	    contentNum++;
    	    System.out.println("성공적으로 등록되었습니다.");
        }catch(MinusMoneyException e) {
          System.out.println("에러가 발생했습니다! 원인: "+e.getMessage());
        }
    	 
      }
      //3. 내용변경
      else if(userInput.trim().compareToIgnoreCase("edit")==0) {
    	  //클래스 생성 필요
    	  BudgetEditService edtSrv = new BudgetEditService();
    	  //리스트가 하나라도 있는지 확인
    	  if(edtSrv.isItemEmpty()) {
          System.out.println("변경할 아이템이 존재하지 않습니다.");
          continue;
        }
    	  //리스트를 보여준다
    	  int[] contentNums = edtSrv.showAllItemsWithNum();
    	  userInput = sc.nextLine();
        userInputs = userInput.split(" ");
    	  int userInputNum;
    	  int money;
    	  if(userInputs.length!=4) {
    	    System.out.println("올바른 형식으로 입력되지 않았습니다.");
    	    continue;
    	  }
        try {
          userInputNum = Integer.parseInt(userInputs[0]);
        }
        catch(NumberFormatException e) {
          
          System.out.println("숫자가 입력되지 않았습니다.");
          continue;
        }
        if(!userInputs[1].equals("수입")&&!userInputs[1].equals("지출")) {
          System.out.println("구분 항목은 수입/지출 하나만 입력할 수 있습니다.");
        }
        try {
          money = Integer.parseInt(userInputs[2]);
        }catch(NumberFormatException e) {
          System.out.println("금액이 올바른 형식으로 입력되지 않았습니다. 0 이상의 정수를 적어주십시오.");
          continue;
        }
        
        try {
          RequestDTO dto = new RequestDTO(contentNums[userInputNum-1],userInputs[1],money,userInputs[3]);
          edtSrv.editItem(dto);
          System.out.println("성공적으로 수정되었습니다.");
        }catch(ArrayIndexOutOfBoundsException e) {
          System.out.println("항목에 없는 숫자를 입력하셨습니다.");
        }catch(MinusMoneyException e) {
          System.out.println("에러가 발생했습니다! 원인: "+e.getMessage());
        }
        //end of try-catch
        
      }//end of else if
      
      //5. 전체내역출력
      else if(userInput.trim().compareToIgnoreCase("list")==0) {
        BudgetListService lstSrv = new BudgetListService();
        //메소드 필요
        lstSrv.list();
      }
      //4. 내용삭제
      else if(userInput.trim().compareToIgnoreCase("delete")==0) {
    	  BudgetDeleteService dltSrv = new BudgetDeleteService();
    	  
    	  //리스트가 하나라도 있는지 확인
    	  if(dltSrv.isItemEmpty()) {
    		  System.out.println("삭제할 아이템이 존재하지 않습니다.");
    		  continue;
    	  }
    	  //전체 리스트에 번호를 주어 선택하게 하는 메소드 필요
    	  //이 메소드는 각 아이템의 contentNum이 담겨있는 int형 배열을 반환한다.
    	  int[] contentNums = dltSrv.showAllItemsWithNum();
    	  
    	  userInput = sc.nextLine();
    	  int userInputNum;
    	  
    	  try {
    		  userInputNum = Integer.parseInt(userInput);
    	  }
    	  catch(NumberFormatException e) {
    		  System.out.println("숫자가 입력되지 않았습니다.");
    		  continue;
    	  }
    	  try {
    		  dltSrv.deleteItem(contentNums[userInputNum-1]);
    	  }catch(ArrayIndexOutOfBoundsException e) {
    		  System.out.println("항목에 없는 숫자를 입력하셨습니다.");
    		  continue;
    	  }//end of try-catch
    	  
    	  System.out.println("정상적으로 삭제되었습니다.");
    	  
      }//end of else if
      //5. 전체내역출력
      else if(userInput.trim().compareToIgnoreCase("list")==0) {
    	  BudgetListService lstSrv = new BudgetListService();
    	  //메소드 필요
    	  lstSrv.list();
      }
      //6. 항목별출력
      else if(userInput.startsWith("info")) {
    	  System.out.println("출력하고 싶은 그룹을 입력해주세요. 수입/지출/항목");
    	  userInput = sc.nextLine();
    	  BudgetInfoService infoSrv = new BudgetInfoService();
    	  
    	  if(userInput.equals("수입")) {
    		  infoSrv.infoIncome();
    	  }
    	  else if(userInput.equals("지출")) {
    		  infoSrv.infoExpense();
    	  }
    	  else if(userInput.equals("항목")) {
    		  System.out.println("출력하고 싶은 항목을 입력해주세요.");
    		  userInput = sc.nextLine();
    		  infoSrv.infoMemo(userInput);
    	  }
    	  else {
    		  System.out.println("잘못 입력하셨습니다.");
    		  continue;
    	  }
      }
      //7. 도움말
      else if(userInput.trim().compareToIgnoreCase("help")==0) {
    	  help();
    	  continue;
      }
      //8. 종료
      else if(userInput.trim().compareToIgnoreCase("exit")==0) {
    	  System.out.println("프로그램을 종료합니다.");
    	  break;
      }
      //명령어 잘 못 입력되었을 때
      else {
    	  //사용자가 명령어를 몰라서 잘 못 입력했을 수도 있으므로 help를 띄워주는 게 좋을 것 같습니다
    	  help();
    	  continue;
      }//end of if
    }//end of while
    sc.close();
  }//end of main
}
