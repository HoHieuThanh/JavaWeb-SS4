package com.restaurant.btth.controller;

import com.restaurant.btth.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/tables")
public class TableController {

    private final TableService service;

    @Autowired
    public TableController(TableService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String listTables(
            @RequestParam(value = "cap", required = false, defaultValue = "0") int cap,
            ModelMap model) {

        model.addAttribute("tables", service.filterByCapacity(cap));
        return "table-list";
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewTable(@PathVariable("id") String id) {
        ModelAndView mv = new ModelAndView("table-detail");
        try {
            int tableId = Integer.parseInt(id);
            mv.addObject("table", service.getById(tableId));
        } catch (NumberFormatException e) {
            mv.addObject("error", "ID phải là số");
        }
        return mv;
    }

    @PostMapping("/update-status")
    public String updateStatus(@RequestParam int id,
                               @RequestParam String status) {

        service.updateStatus(id, status);
        return "redirect:/admin/tables/list";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id, ModelMap model) {

        String msg = service.delete(id);
        model.addAttribute("message", msg);

        return "redirect:/admin/tables/list";
    }
}
