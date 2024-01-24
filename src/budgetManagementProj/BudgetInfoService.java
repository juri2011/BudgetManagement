package budgetManagementProj;

import java.text.SimpleDateFormat;
import java.util.Collection;

public class BudgetInfoService {
  private BudgetDAO dao;
  public BudgetInfoService() {
    dao = new BudgetDAO();
  }
  //Info에서는 contentNum을 출력하지 않습니다.
  
  //vo.desc.equals("수입")에 해당하는 vo만 출력
  public void infoIncome() {
    Collection<BudgetVO> list = dao.selectList();
    if(list.isEmpty()) System.out.println("해당 항목이 존재하지 않습니다.");
    
    //총 수입금액을 출력하기 위해 값을 담을 변수
    int totIncome = 0;
    int listNum = 1;
    System.out.println("[번호]\t[등록일자]\t\t[구분]\t[금액]\t[메모]");
    
    for(BudgetVO vo : list) {
      //vo에 toString 있으면 좋을듯
      //System.out.println(vo.toString());
      if(vo.getDesc().equals("지출")) continue;
      totIncome+=vo.getMoney();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      String voDate = sdf.format(vo.getAddDate());
      System.out.printf("[%d]\t%s\t%s\t%d\t%s\n",listNum,voDate, vo.getDesc(), vo.getMoney(), vo.getMemo());
      
      listNum++;
    }
    System.out.println("총 수입 금액 : "+totIncome);
  }
  //vo.desc.equals("지출")에 해당하는 vo만 출력
  public void infoExpense() {
	  Collection<BudgetVO> list = dao.selectList();
	    if(list.isEmpty()) System.out.println("해당 항목이 존재하지 않습니다.");
	    
	    //총 수입금액을 출력하기 위해 값을 담을 변수
	    int totExpense = 0;
	    int listNum = 1;
	    System.out.println("[번호]\t[등록일자]\t\t[구분]\t[금액]\t[메모]");
	    
	    for(BudgetVO vo : list) {
	      //vo에 toString 있으면 좋을듯
	      //System.out.println(vo.toString());
	      if(vo.getDesc().equals("수입")) continue;
	      totExpense+=vo.getMoney();
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	      String voDate = sdf.format(vo.getAddDate());
	      
	      System.out.printf("[%d]\t%s\t%s\t%d\t%s\n",listNum,voDate, vo.getDesc(), vo.getMoney(), vo.getMemo());
	      
	      listNum++;
	    }
	    
	    System.out.println("총 지출 금액 : "+totExpense);
  }
  //vo.memo.equals(memo)에 해당하는 vo만 출력
  //해당하는 vo가 없을 시 메시지 호출 필요
  public void infoMemo(String memo) {
	  Collection<BudgetVO> list = dao.selectList();
	    if(list.isEmpty()) System.out.println("해당 항목이 존재하지 않습니다.");
	    
	    //총 수입금액을 출력하기 위해 값을 담을 변수
	    int totIncome = 0;
	    int totExpense = 0;
	    int listNum = 1;
	    System.out.println("총 수입 금액 : "+totIncome+"\t 총 지출 금액 : "+totExpense);
	    System.out.println("[번호]\t[등록일자]\t\t[구분]\t[금액]\t[메모]");
	    
	    for(BudgetVO vo : list) {
	      //vo에 toString 있으면 좋을듯
	      //System.out.println(vo.toString());
	      if(!vo.getMemo().equals(memo)) continue;
	      if(vo.getDesc().equals("수입")) totIncome+=vo.getMoney();
	      if(vo.getDesc().equals("지출")) totExpense+=vo.getMoney();
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	      String voDate = sdf.format(vo.getAddDate());
	      
	      System.out.printf("[%d]\t%s\t%s\t%d\t%s\n",listNum,voDate, vo.getDesc(), vo.getMoney(), vo.getMemo());
	      
	      listNum++;
	    }
	    System.out.println("총 수입 금액 : "+totIncome);
	    System.out.println("총 지출 금액 : "+totExpense);
  }
}
