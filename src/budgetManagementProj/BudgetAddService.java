package budgetManagementProj;

import java.util.Collection;
import java.util.Date;

public class BudgetAddService {
  private BudgetDAO dao;
  public BudgetAddService() {
    dao = new BudgetDAO();
  }
  
  //dto에서 값을 받아와서 새 vo 객체를 생성하고, dao에 저장
  public void addItem(RequestDTO dto) {
	  //dto의 모든 값을 vo 객체의 생성자에 넘깁니다.
    BudgetVO vo = new BudgetVO(dto.getContentNum(), dto.getDesc(), dto.getMoney(),dto.getMemo(),new Date());
	  //주의!!! vo의 balance에 값을 저장 할 때는 우선 dao의 static 변수인 balance를 가져와야 한다.
	  //그러기 위해서 dao에 getBalance 메소드를 작성할 필요가 있습니다.
    dao.insert(vo);    
    if(vo.getDesc().equals("수입")) {
     dao.balanceIncome(vo.getMoney());
    }else {
      dao.balanceExpense(vo.getMoney());
    }
  }
}
