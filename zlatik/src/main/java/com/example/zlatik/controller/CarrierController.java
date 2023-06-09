package com.example.zlatik.controller;

import com.example.zlatik.entity.Carrier;
import com.example.zlatik.entity.Song;
import com.example.zlatik.service.CarrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/carrier")
public class CarrierController {

    @Autowired
    CarrierService carrierService;
    @Async
    @GetMapping("")
    public String getAll(Model model) {
        model.addAttribute("carriers", carrierService.getAll());
        return "carrier";
    }
    @Async
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        Carrier carrier = carrierService.getById(id);
        model.addAttribute("carrier", carrier);
        return "carrier-details";
    }
    @Async
    @PostMapping("/create")
    public String create(@ModelAttribute Carrier carrier){
        carrierService.create(carrier);
        return "redirect:/carrier";
    }
    @Async
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        carrierService.delete(id);
        return "redirect:/carrier";
    }
    @Async
    @PostMapping("/save")
    public String save(@ModelAttribute("carrier") Carrier carrier) {
        carrierService.update(carrier);
        return "redirect:/carrier";
    }
    @Async
    @GetMapping("/edit/{id}")
    public String getCarrier(@PathVariable("id") Long id, Model model) {
        Carrier carrier = carrierService.getById(id);
        model.addAttribute("carrier", carrier);
        return "editcarrier";
    }

    @Async
    @PostMapping("/edit/{id}")
    public String editCarrier(@ModelAttribute Carrier carrier) {
        carrierService.update(carrier);
        return "redirect:/carrier";
    }
}
