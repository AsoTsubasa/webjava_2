package jp.co.systena.tigerscave.ShoppingSite.application.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

  // 注文リスト
  private List<Order> orderList = new ArrayList<Order>();

  public List<Order> getOrderList()
  {
    return orderList;
  }

  public void setOrderList(List<Order> orderList)
  {
    this.orderList = orderList;
  }

  public void add(Order order)
  {
    Order existOrder = findOrderByItemId(order.getItem().getId());

    if(existOrder == null)
    {
      orderList.add(order);
    }
    else
    {
      existOrder.setNum(existOrder.getNum() + order.getNum());
    }
  }

  public Order findOrderByItemId(int itemId)
  {
    for(Order order : orderList)
    {
      if(order.getItem().getId() == itemId)
      {
        return order;
      }
    }

    // アイテムが見つからなかった場合、NULLを返す
    return null;
  }

}
