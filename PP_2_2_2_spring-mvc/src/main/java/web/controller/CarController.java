package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String getCount(@RequestParam(name = "count", required = false) String count, Model model) {
        if (count != null) {
            int countCar = Integer.parseInt(count);
            model.addAttribute("cars", carService.getCarCount(carService.getListCar(), countCar));
        } else {
            model.addAttribute("cars", carService.getListCar());
        }
        return "cars";
    }


}
