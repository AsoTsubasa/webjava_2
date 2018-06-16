package jp.co.systena.tigerscave.PetShop.application.model;

public class ListForm {

   //動物ID
   private String selectedAnimalId;

   public String getAnimalId()
   {
     return selectedAnimalId;
   }

   public void setSelectedAnimalId(String animalId)
   {
     this.selectedAnimalId = animalId;
   }

}
