package budgetManagementProj;

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
    for(BudgetVO vo : list) {
      System.out.println();
    }
  }
  //vo.desc.equals("지출")에 해당하는 vo만 출력
  public void infoExpense() {}
  //vo.memo.equals(memo)에 해당하는 vo만 출력
  //해당하는 vo가 없을 시 메시지 호출 필요
  public void infoMemo(String memo) {}
}
