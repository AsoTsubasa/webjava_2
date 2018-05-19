package jp.co.systena.tigerscave.ShoppingSite.application.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ListService {

  // 商品リスト
  private List<Item> itemList;

  public List<Item> getItemList() {

    this.itemList = new ArrayList<Item>();

    // 商品を定義
    Item item1 = new Item();
    item1.setName("商品A");
    item1.setPrice(100);
    itemList.add(item1);

    Item item2 = new Item();
    item2.setName("商品B");
    item2.setPrice(200);
    itemList.add(item2);

    Item item3 = new Item();
    item3.setName("商品C");
    item3.setPrice(1000);
    itemList.add(item3);

    return itemList;
  }
}
