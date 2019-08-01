package pack.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.CartBean;
import pack.model.CartSangBean;
import pack.model.ProgramDaoInter;

@Controller
public class CartController {
	
	@Autowired
	ProgramDaoInter daoInter;

	// 상품을 카트에 담는 것
	@RequestMapping("sangCart")
	public String cartsangproc(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			CartSangBean cartSangBean) {

		ArrayList<CartSangBean> sanglist = (ArrayList<CartSangBean>) session.getAttribute("cartSangList");
		ArrayList<CartBean> prolist = (ArrayList<CartBean>) session.getAttribute("cartList");

		// session이 새로운
		if (sanglist == null) {
			sanglist = new ArrayList<CartSangBean>();
		}

		if (prolist == null) {
			prolist = new ArrayList<CartBean>();
		}

		String sang_no = cartSangBean.getSang_no();
		int quantity = Integer.parseInt(cartSangBean.getCount());

		// 기존 상품을 찾아서 수량을 교체하는 과정
		boolean check = false;
		for (CartSangBean bean : sanglist) {
			if (bean.getSang_no().equals(sang_no)) {
				quantity += Integer.parseInt(bean.getCount());
				bean.setCount(Integer.toString(quantity));
				check = true;
			}
		}

		// 기존 상품을 못 찾았을 경우
		if (check == false) {
			sanglist.add(cartSangBean);
		}

		session.setAttribute("cartSangList", sanglist);
		session.setAttribute("cartList", prolist);
		return "redirect:/cartList";
	}
	
	@RequestMapping("sangDelete")
	public String sangDelete(@RequestParam String sang_no, HttpSession session) {
		// System.out.println(sang_no);
		ArrayList<CartSangBean> sanglist =  (ArrayList<CartSangBean>)session.getAttribute("cartSangList");
		
		for(int i=0; i < sanglist.size(); i++) {
			// System.out.println("들어오니");
			CartSangBean bean = sanglist.get(i);		// sanglist.get(i).getSang_no() 
			// System.out.println("너는 나오니" + bean.getSang_no());
			session.removeAttribute("cartSangList");
			
			if(bean.getSang_no().equals(sang_no)) {
				sanglist.remove(i);
			}
		}
		session.setAttribute("cartSangList", sanglist);

		return "redirect:/cartList";
	}
	
	@RequestMapping("proCart")
	public String cartproc(HttpSession session, HttpServletRequest request, HttpServletResponse response, CartBean cartBean) {
		// CartBean cartBean을 arg에 넣어주면 호출 정보들을 Spring이 name에 맞게 set해서 bean 안에 담아줌
		// System.out.println("cart 컨트롤러 수행");
		// System.out.println("cart 컨트롤러: "+ request.getParameter("flage"));
		
		// cartBean에 값이 잘 담아졌는지 확인 -- 잘 되는군!
		// System.out.println(cartBean.getPro_no());
		// System.out.println(cartBean.getPro_name());
		// System.out.println(cartBean.getCount());
		
		// session에 장바구니를 담아보자!
		
		//Hashtable로 시도-------
		/*Hashtable<String, CartBean> hCart = (Hashtable<String, CartBean>)session.getAttribute("cartList") ;
		
		if(hCart == null) {
			hCart = new Hashtable<String,CartBean>();
			session.setAttribute("cartList", hCart);
		}
		
		String pro_no = cartBean.getPro_no();
		int quantity = Integer.parseInt(cartBean.getCount());
		
		if(quantity > 0) {
			//동일 상품 주문 시 주문 수량만 증가
			if(hCart.containsKey(pro_no)) {
				CartBean temp = (CartBean)hCart.get(pro_no);
				quantity += Integer.parseInt(temp.getCount());
				temp.setCount(Integer.toString(quantity));
				hCart.put(pro_no, temp);
			}else {
				//새로운 상품 주문 시 제품 목록 증가
				hCart.put(pro_no, cartBean);				
			}
		}*/
		
		ArrayList<CartSangBean> sanglist = (ArrayList<CartSangBean>) session.getAttribute("cartSangList");
		ArrayList<CartBean> prolist = (ArrayList<CartBean>) session.getAttribute("cartList");
		
		//session이 새로운 
		if(prolist == null) {
			prolist = new ArrayList<CartBean>();
		}
		
		if(sanglist == null) {
			sanglist = new ArrayList<CartSangBean>();
		}
		
		String pro_no = cartBean.getPro_no();
		int quantity = cartBean.getCount();
		
		//기존 상품을 찾아서 수량을 교체하는 과정
		boolean check = false;
		for(CartBean bean:prolist) {
			if(bean.getPro_no().equals(pro_no)) {
				quantity += bean.getCount();
				bean.setCount(quantity);
				check = true;
			}
		}
		
		//기존 상품을 못 찾았을 경우
		if(check == false) {
			prolist.add(cartBean);
		}

		session.setAttribute("cartSangList", sanglist);
		session.setAttribute("cartList", prolist);
		return "redirect:/cartList";
	}
	

	@RequestMapping("cartList")
	public String cartlistdisp(HttpSession session) {
		ArrayList<CartSangBean> sanglist = (ArrayList<CartSangBean>) session.getAttribute("cartSangList");
		ArrayList<CartBean> prolist = (ArrayList<CartBean>) session.getAttribute("cartList");
		
		//session이 새로운 
		if(prolist == null) {
			prolist = new ArrayList<CartBean>();
		}
		
		if(sanglist == null) {
			sanglist = new ArrayList<CartSangBean>();
		}
		
		session.setAttribute("cartSangList", sanglist);
		session.setAttribute("cartList", prolist);
		return "cartList";
	}

	
}

