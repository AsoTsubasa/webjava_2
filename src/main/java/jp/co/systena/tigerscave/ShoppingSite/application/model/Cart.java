package jp.co.systena.tigerscave.ShoppingSite.application.model;

import java.util.List;

public class Cart {

  // 注文リスト
  private List<Order> orderList;

  public List<Order> getOrderList(){

    return orderList;
  }

  public void setOrderList(Order order) {

    this.orderList.add(order);
  }

}
