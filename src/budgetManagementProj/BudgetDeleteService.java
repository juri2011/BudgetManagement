package budgetManagementProj;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BudgetDeleteService {
  private BudgetDAO dao;
  public BudgetDeleteService() {
    dao = new BudgetDAO();
  }
//Delete에서는 contentNum을 출력하지 않습니다.
  
  //항목을 삭제하는 메소드입니다.
  public void deleteItem(int contentNum) {
    BudgetVO vo = dao.selectOne(contentNum);
    if(vo.getDesc().equals("수입")) dao.balanceExpense(vo.getMoney());
    else dao.balanceIncome(vo.getMoney());
	dao.remove(contentNum);
  }

  //등록된 항목이 있는지 확인하는 메소드입니다. (기본적으로 delete에 있는 그것과 동일)
  public boolean isItemEmpty() {
    return dao.isMapEmpty();
  }
  
  //vo 리스트를 출력하고, 각 아이템에 해당하는 contentNum 배열 값을 리턴합니다.
  public int[] showAllItemsWithNum() {
    
    Collection<BudgetVO> list = dao.selectList();
    List<BudgetVO> budList = new ArrayList<BudgetVO>();
    
    //항목의 크기대로 배열을 생성함
    int [] contentNumArr = new int[list.size()];
    
    //출력은 1부터 한다. 
    int listNum = 1;
    
    System.out.println("삭제할 항목의 번호를 입력해주세요.");
    System.out.println("[번호]\t[등록일자]\t\t[구분]\t[금액]\t[메모]");
    //list 안에 있는 아이템을 순회
    for(BudgetVO vo : list) {
      //vo에 toString 있으면 좋을듯
      //System.out.println(vo.toString());
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      String voDate = sdf.format(vo.getAddDate());
      
      System.out.printf("[%d]\t%s\t%s\t%d\t%s\n",listNum,voDate, vo.getDesc(), vo.getMoney(), vo.getMemo());
      
      //MainController에 넘겨줄 contentNumArr에 해당 vo의 contentNum 저장
      contentNumArr[listNum-1] = vo.getContentNum();
      listNum++;
    }
    
    return contentNumArr;
  }
}
