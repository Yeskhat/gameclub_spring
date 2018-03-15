package kz.kaznitu.mysrs.controllers;

import kz.kaznitu.mysrs.models.Computer;
import kz.kaznitu.mysrs.models.Gameclub;
import kz.kaznitu.mysrs.models.Playstation;
import kz.kaznitu.mysrs.repositories.ComputerRepository;
import kz.kaznitu.mysrs.repositories.GameclubRepository;
import kz.kaznitu.mysrs.repositories.PlaystationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GameclubsController {
    @Autowired
    private GameclubRepository gameclubRepository;
    @Autowired
    private ComputerRepository computerRepository;
    @Autowired
    private PlaystationRepository playstationRepository;

    @RequestMapping("/gameclub/{id}")
    public String car(@PathVariable("id")int id, Model model){
        model.addAttribute("gameclub",gameclubRepository.findById(id).get());
        model.addAttribute("computers",computerRepository.findAll());
        model.addAttribute("playstations",playstationRepository.findAll());
        return "gameclub";
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String carsList(Model model){
        model.addAttribute("gameclubs",gameclubRepository.findAll());
        return "gameclubs";
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String carsAdd(@RequestParam String gameclubName, @RequestParam String address, Model model){
        Gameclub newGameclub = new Gameclub();
        newGameclub.setGameclubName(gameclubName);
        newGameclub.setAddress(address);
        gameclubRepository.save(newGameclub);

        model.addAttribute("gameclub",newGameclub);
        model.addAttribute("computers",computerRepository.findAll());
        model.addAttribute("playstations",playstationRepository.findAll());
        return "redirect:/gameclub/"+newGameclub.getId();
    }

    @RequestMapping(value = "gameclub/{id}/info", method = RequestMethod.POST)
    public String carsAddInfo(@PathVariable Integer id,@RequestParam Integer compId,
                              @RequestParam Integer plId, Model model){
        Computer computer = computerRepository.findById(compId).get();
        Playstation playstation = playstationRepository.findById(plId).get();
        Gameclub gameclub = gameclubRepository.findById(id).get();

        if(gameclub!=null){
            if(!gameclub.hasComputer(computer) & !gameclub.hasPlaystation(playstation)){
                gameclub.getPlaystations().add(playstation);
                gameclub.getComputers().add(computer);
            }
            gameclubRepository.save(gameclub);
            model.addAttribute("gameclub",gameclubRepository.findById(id).get());
            model.addAttribute("playstations",playstationRepository.findAll());
            model.addAttribute("computers",computerRepository.findAll());
            return "redirect:/gameclub/"+gameclub.getId();
        }
        model.addAttribute("gameclub",gameclubRepository.findAll());
        return "redirect:/";
    }

    @RequestMapping(value = "/computers",method = RequestMethod.GET)
    public String companiesAdd(Model model){
        model.addAttribute("computer", new Computer());
        return "computers";
    }

    @RequestMapping(value = "/computers",method = RequestMethod.POST)
    public String companiesAdd(@ModelAttribute Computer computer){
        computerRepository.save(computer);
        return "computers";
    }

    @RequestMapping(value = "/playstations",method = RequestMethod.GET)
    public String enginesAdd(Model model){
        model.addAttribute("playstation", new Playstation());
        return "playstations";
    }

    @RequestMapping(value = "/playstations",method = RequestMethod.POST)
    public String enginesAdd(@ModelAttribute Playstation playstation){
        playstationRepository.save(playstation);
        return "playstations";
    }

}
