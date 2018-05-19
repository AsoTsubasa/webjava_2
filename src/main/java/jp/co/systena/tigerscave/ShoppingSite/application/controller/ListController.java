package jp.co.systena.tigerscave.ShoppingSite.application.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.ShoppingSite.application.model.Item;
import jp.co.systena.tigerscave.ShoppingSite.application.model.ListForm;
import jp.co.systena.tigerscave.ShoppingSite.application.model.ListService;
import jp.co.systena.tigerscave.ShoppingSite.application.model.Order;

@Controller
public class ListController {

  @Autowired
  HttpSession session;

  @RequestMapping(value="/ListView", method = RequestMethod.GET)
  public ModelAndView show(ModelAndView mav)
  {
    ListService listService = new ListService();

    // Viewに渡すデータを設定
    // セッション情報から保存したデータを取得してメッセージを生成
    ListForm listForm = (ListForm) session.getAttribute("form");
    session.removeAttribute("form");
    if (listForm != null) {
      if (listForm.getMessage() != null) {
        mav.addObject("message", listForm.getMessage());
      }
    }

    listForm = new ListForm();
    // 商品一覧を取得
    List<Item> itemList = listService.getItemList();
    listForm.setItemList(itemList);

    mav.addObject("listForm", listForm);  // 新規クラスを設定

    List<Order> orderList = (List<Order>) session.getAttribute("orderList");
    if( orderList == null) {
        orderList = new ArrayList<Order>();
        session.setAttribute("orderList", orderList);
    }

    //Cart cart = new Cart();
    //cart.setOrderList(orderList);
    mav.addObject("orders", orderList);

    BindingResult bindingResult = (BindingResult) session.getAttribute("result");
    if (bindingResult != null) {
      mav.addObject("bindingResult", bindingResult);
    }
    // Viewのテンプレート名を設定
    mav.setViewName("ListView");
    return mav;

  }


  @RequestMapping(value="/ListView", method = RequestMethod.POST)
  public ModelAndView order(ModelAndView mav, @ModelAttribute ListForm listForm, HttpServletRequest request)
  {

    ListService listService = new ListService();

    //Cart cart = (Cart)session.getAttribute("cart");
    //session.setAttribute("cart", cart);

    List<Order> orderList = (List<Order>)session.getAttribute("OrderList");
    if(orderList == null)
    {
      orderList = new ArrayList<Order>();
      session.setAttribute("orderList", orderList);
    }

    String select = request.getParameter("select");
    String numStr = request.getParameter("num");

    if (select != null && numStr != null) {
      int id = Integer.parseInt(select);
      int num = Integer.parseInt(numStr);

      List<Item> itemList = listService.getItemList();
      //List<Item> itemList = listForm.getItemList();

      Order order = new Order();
      order.setItem(itemList.get(id));
      order.setNum(num);
      orderList.add(order);
      listForm.setOrderList(orderList);

      String message = order.getItem().getName() + "を" + order.getNum() + "個、カートに追加しました。";
      listForm.setMessage(message);
    }

    // データをセッションへ保存
    session.setAttribute("form", listForm);
    return new ModelAndView("redirect:/ListView");
  }
}
