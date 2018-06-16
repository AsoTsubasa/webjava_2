package jp.co.systena.tigerscave.PetShop.application.model;

public abstract class Factory {

  public final Animal create(String name) {

    Animal pet = createPet(name);
    registerPet(pet);
    return pet;
  }

  protected abstract Animal createPet(String name);

  protected abstract void registerPet(Animal pet);

}
