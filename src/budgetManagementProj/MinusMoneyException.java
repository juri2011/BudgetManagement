package budgetManagementProj;

public class MinusMoneyException extends RuntimeException{
  @Override
  public String getMessage() {
    return "입력값은 음수가 될 수 없습니다.";
  }
}
