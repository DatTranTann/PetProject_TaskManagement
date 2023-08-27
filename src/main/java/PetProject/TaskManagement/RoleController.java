package PetProject.TaskManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RoleController {
    @Autowired
    private RoleService service;
    @RequestMapping("/role")
    public String viewHomePage(Model model) {
        List<Role> listRoles = service.listAll();
        model.addAttribute("listRoles", listRoles);

        return "index";
    }
}
