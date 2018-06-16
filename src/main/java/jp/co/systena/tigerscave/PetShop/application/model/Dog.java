package jp.co.systena.tigerscave.PetShop.application.model;

public class Dog extends Animal{

  // ID
  private int animalId;

  // 名前
  private String name;

  // 種族
  private String species;

  // 鳴き声

  // 動き

  // 好きな餌
  private String favoriteFood;

  // 嫌いな餌
  private String badFood;

  Dog(int id, String name){
    System.out.println("Create accont: " + name);
    this.animalId = id;
    this.name = name;
  }

  public void use() {
    System.out.println("Use account: " + name);

  }

  public String getName() {
    return name;
  }

  public int getId() {
    return animalId;
  }

}
