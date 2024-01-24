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
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    list.stream().forEach(vo->{
      String addDate = sdf.format(vo.getAddDate());
      System.out.println(addDate+ " | " +vo.getDesc()+ " | " +vo.getMoney()+ " | " +vo.getMemo());
    });
  }
}
