package jp.co.systena.tigerscave.ShoppingSite.application.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ListService {

  // 商品リスト
  private List<Item> itemList;

  public ListService()
  {
    this.itemList = new ArrayList<Item>();

    // 商品を定義
    Item item1 = new Item(1, "商品A", 100);
    itemList.add(item1);

    Item item2 = new Item(2, "商品B", 200);
    itemList.add(item2);

    Item item3 = new Item(3, "商品C", 1000);
    itemList.add(item3);
  }

  public List<Item> getItemList()
  {
    return itemList;
  }

  // 商品IDから商品情報を取得
  public Item findItemById(int id)
  {
    for (Item item : itemList)
    {
      if(id == item.getId())
      {
        return item;
      }
    }

    return null;
  }
}
