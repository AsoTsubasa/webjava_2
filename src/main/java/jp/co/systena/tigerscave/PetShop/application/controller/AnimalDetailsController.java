package jp.co.systena.tigerscave.PetShop.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.PetShop.application.model.ListForm;

@Controller
public class AnimalDetailsController {

  @RequestMapping(value = "/AnimalDetailsView", method = RequestMethod.GET)
  public ModelAndView details(@ModelAttribute ListForm listForm, ModelAndView mav)
  {
    mav.addObject("listForm", listForm);

    return mav;
  }

}
