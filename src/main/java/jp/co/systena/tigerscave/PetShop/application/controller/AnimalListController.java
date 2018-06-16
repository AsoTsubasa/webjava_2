package jp.co.systena.tigerscave.PetShop.application.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.PetShop.application.model.Animal;
import jp.co.systena.tigerscave.PetShop.application.model.ListForm;
import jp.co.systena.tigerscave.PetShop.application.model.ListService;

@Controller
public class AnimalListController {

  @Autowired
  HttpSession session;

  @RequestMapping(value="/AnimalListView", method = RequestMethod.GET)
  public ModelAndView show(ModelAndView mav)
  {

    String message = (String) session.getAttribute("message");
    session.removeAttribute("message");

    Animal selectedAnimal = (Animal)session.getAttribute("selectedAnimal");
    if(selectedAnimal == null) {
      selectedAnimal = null;
      session.setAttribute("selectedAnimal", selectedAnimal);
    }

    if(message != null && !message.isEmpty())
    {
      mav.addObject("message", message);
    }

    List<Animal> animalList = new ListService().getAnimalList();
    mav.addObject("animals", animalList);

    ListForm listForm = new ListForm();
    mav.addObject("listForm", listForm);
    return mav;

  }


  @RequestMapping(value="/AnimalListView", method = RequestMethod.POST)
  public ModelAndView order(ModelAndView mav, @Valid ListForm listForm, BindingResult bindingResult, HttpServletRequest request)
  {

    // リダイレクト
    return new ModelAndView("redirect:/AnimalListView");
  }
}