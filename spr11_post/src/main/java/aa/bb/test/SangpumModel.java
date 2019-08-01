package aa.bb.test;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Repository
@Component
public class SangpumModel {
	public String compute(SangpumBean bean){
		String data = "품명:" + bean.getSang() + " " +
				  ", 금액:" + (bean.getSu() * bean.getDan());
		return data;
	}
}
