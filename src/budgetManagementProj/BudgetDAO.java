package budgetManagementProj;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BudgetDAO {
  //저장될 데이터: 잔액(int), 수입(int), 지출수입(int), 기입날짜(Date), 항목(String)
  //데이터베이스 저장소 역할을 대행하는 Map 객체  
  private static int totBalance = 0;
  private static Map<Integer, BudgetVO> budMap = new HashMap<Integer, BudgetVO>();
  
  //desc값을 더하는 수입 메소드
  public void balanceIncome(int money) {
    totBalance += money;
  }
  
  //desc값을 빼는 지출 메소드
  public void balanceExpense(int money) {
    totBalance -= money;
  }
  
  //MemberVO 타입의 데이터를 받아 DB에 저장하는 함수 
  public void insert(BudgetVO vo) {
    budMap.put(vo.getContentNum(), vo);
  }
  
  //MemberVO 의 총잔액을 받아와서 리턴하는 함수
  public int getTotBalance() {
    return totBalance;
  }
  
  //전달받은 항목 
  public BudgetVO selectOne(int contentNum) {
    return budMap.get(contentNum);
  }
  
  //전체 가게부작성 목록
  public Collection<BudgetVO> selectList(){
    return budMap.values();
  }
  
  //가게부 정보 수정
  public void update(BudgetVO vo) {
    budMap.put(vo.getContentNum(), vo);
  }
  
  //budMap
  public boolean isMapEmpty() {
    return budMap.isEmpty();
  }
  
  public void remove(int contentNum){
    budMap.remove(contentNum);
  }
  
}
