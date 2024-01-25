package budgetManagementProj;

import java.text.SimpleDateFormat;
import java.util.Collection;

public class BudgetListService {
  private BudgetDAO dao;
  public BudgetListService() {
    dao = new BudgetDAO();
  }
  //List에서는 contentNum을 출력하지 않습니다.
  public void list() {
    Collection<BudgetVO> list = dao.selectList();
    System.out.println("잔액 : "+dao.getTotBalance());
    
    if(dao.isMapEmpty()) System.out.println("항목이 존재하지 않습니다.");
    
    int listNum = 1;
    
    System.out.println(String.format("%s %10s\t%6s %-20s\t%-20s", "[번호]", "[등록일자]", " [구분]", "  [금액]", "[메모]"));
    for(BudgetVO vo : list) {
      //vo에 toString 있으면 좋을듯
      //System.out.println(vo.toString());
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      String voDate = sdf.format(vo.getAddDate());
      
      System.out.printf("[%d]\t%s\t%s\n",listNum,voDate,vo.toString());
      
      listNum++;
    }
  }
}
