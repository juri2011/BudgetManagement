package budgetManagementProj;

public class BudgetEditService {
  private BudgetDAO dao;
  public BudgetEditService() {
    dao = new BudgetDAO();
  }
  //기존에 등록된 항목을 수정하는 메소드입니다.
  public void editItem(RequestDTO dto) {}
  //등록된 항목이 있는지 확인하는 메소드입니다. (기본적으로 delete에 있는 그것과 동일)
  public boolean isItemExists() {
    return false;
  }
}
