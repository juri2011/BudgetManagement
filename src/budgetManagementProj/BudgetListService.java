package budgetManagementProj;

public class BudgetListService {
  private BudgetDAO dao;
  public BudgetListService() {
    dao = new BudgetDAO();
  }
  //List에서는 contentNum을 출력하지 않습니다.
}
