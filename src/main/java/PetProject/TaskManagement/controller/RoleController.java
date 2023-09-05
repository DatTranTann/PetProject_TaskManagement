package PetProject.TaskManagement.controller;
import PetProject.TaskManagement.entity.Role;
import PetProject.TaskManagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping("/role")
    public String viewHomePage(Model model) {
        List<Role> listRoles = roleService.getAll();
        model.addAttribute("listRoles", listRoles);
        return "listRoles";
    }

    @RequestMapping("/new")
    public String CreateRole() {
        roleService.save();
        return "ok";
    }
}
