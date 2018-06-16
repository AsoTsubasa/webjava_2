package jp.co.systena.tigerscave.PetShop.application.model;

import java.util.ArrayList;
import java.util.List;

public class AccountFactory extends Factory{

  private List<Animal> petList = new ArrayList<Animal>();

  protected Animal createPet(String name) {
    return new Dog(1, name);
  }

  protected void registerPet(Animal pet) {
    petList.add(pet);
  }

  public List<Animal> getPetList() {
    return petList;
  }

}
