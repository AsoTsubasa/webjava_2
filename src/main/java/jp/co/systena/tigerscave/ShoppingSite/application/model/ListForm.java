package jp.co.systena.tigerscave.ShoppingSite.application.model;

import java.util.List;

public class ListForm {

  // 商品一覧
  private List<Item> itemList;

  // カート情報
  private List<Order> orderList;

  private String message;

  public List<Item> getItemList()
  {
    return itemList;
  }

  public List<Order> getOrderList()
  {
    return orderList;
  }

  public String getMessage()
  {

    return message;
  }

  public void setItemList(List<Item> itemList)
  {
    this.itemList = itemList;
  }

  public void setOrderList(List<Order> orderList)
  {
    this.orderList = orderList;
  }

  public void setMessage(String message)
  {
    this.message = message;
  }

}
