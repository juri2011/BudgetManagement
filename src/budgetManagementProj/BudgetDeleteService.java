package budgetManagementProj;

public class BudgetDeleteService {
  private BudgetDAO dao;
  public BudgetDeleteService() {
    dao = new BudgetDAO();
  }
//Delete에서는 contentNum을 출력하지 않습니다.
  
  //항목을 삭제하는 메소드입니다.
  public void deleteItem(int contentNum) {}

  //등록된 항목이 있는지 확인하는 메소드입니다. (기본적으로 delete에 있는 그것과 동일)
  public boolean isItemExists() {
    return false;
  }
  
  //vo 리스트를 출력하고, 각 아이템에 해당하는 contentNum 배열 값을 리턴합니다.
  public int[] showAllItemsWithNum() {
    return new int[] {0};
  }
}
