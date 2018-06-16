package jp.co.systena.tigerscave.PetShop.application.model;

import java.util.ArrayList;
import java.util.List;

public class ListService {

  //商品動物リスト
  private List<Animal> animalList;

  public ListService()
  {
    this.animalList = new ArrayList<Animal>();

    // 商品を定義
    Animal dog1 = new Dog(1, "柴犬");
    animalList.add(dog1);

    Animal dog2 = new Dog(2, "チワワ");
    animalList.add(dog2);

    Animal dog3 = new Dog(3, "ブルドッグ");
    animalList.add(dog3);
   }

  public List<Animal> getAnimalList()
  {
    return animalList;
  }

  // 動物IDから動物情報を取得
  public Animal findItemById(int id)
  {
    for (Animal animal : animalList)
    {
      if(id == animal.getId())
      {
        return animal;
      }
    }

    return null;
  }
}
