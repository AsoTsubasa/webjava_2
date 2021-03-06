package jp.co.systena.tigerscave.ShoppingSite.application.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.ShoppingSite.application.model.Cart;
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
    String message = (String) session.getAttribute("message");
    session.removeAttribute("message");

    Cart cart = (Cart)session.getAttribute("cart");
    if(cart == null) {
        cart = new Cart();
        session.setAttribute("cart", cart);
    }

    if(message != null && !message.isEmpty())
    {
      mav.addObject("message", message);
    }

    List<Item> itemList = new ListService().getItemList();
    mav.addObject("items", itemList);

    ListForm listForm = new ListForm();
    mav.addObject("listForm", listForm);
    return mav;

  }


  @RequestMapping(value="/ListView", method = RequestMethod.POST)
  public ModelAndView order(ModelAndView mav, @Valid ListForm listForm, BindingResult bindingResult, HttpServletRequest request)
  {

    boolean isError = false;
    Item item = null;
    if (bindingResult.getAllErrors().size() > 0) {
        isError = true;
    } else {
        item = new ListService().findItemById(listForm.getItemId());
    }

    if (isError == true || item == null) {
      // エラー(動作未確認)
      String msgerr = "エラーが発生しました。";
      session.setAttribute("message", msgerr);

      // リダイレクト
      return new ModelAndView("redirect:/ListView");
    }

    Order order = new Order(item, listForm.getNum());

    Cart cart = (Cart)session.getAttribute("cart");
    if(cart == null) {
        cart = new Cart();
        session.setAttribute("cart", cart);
    }
    cart.add(order);

    StringBuilder messageBuf = new StringBuilder();
    messageBuf.append(item.getName());
    messageBuf.append("を");
    messageBuf.append(listForm.getNum());
    messageBuf.append("点カートに追加しました。");

    // データをセッションへ保存
    session.setAttribute("message", messageBuf.toString());
    session.setAttribute("cart", cart);

    // リダイレクト
    return new ModelAndView("redirect:/ListView");
  }
}
