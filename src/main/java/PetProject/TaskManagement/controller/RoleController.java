package PetProject.TaskManagement.controller;
import PetProject.TaskManagement.entity.Role;
import PetProject.TaskManagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/role")
@CrossOrigin("http://localhost:8080")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping("/")
    public List<Role> getAllRole(Model model) {
        List<Role> listRoles = roleService.getAll();
        return listRoles;
    }
    @GetMapping("/name/{name}")
    public List<Role> getRoleByName(@PathVariable("name") String nameRole) {
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss a", Locale.ENGLISH);
//        formatter.setTimeZone(TimeZone.getTimeZone("America/New_York"));
//
//        String dateInString = "22-01-2015 10:15:55 AM";
//        Date date = formatter.parse(dateInString);
//        String formattedDateString = formatter.format(date);

        List<Role> listRoles = roleService.getRoleByName(nameRole);
        return listRoles;
    }

    @GetMapping("/id/{id}")
    public Optional<Role> getRoleById(@PathVariable("id") UUID id) {
        Optional<Role> listRoles = roleService.getRoleById(id);
        return listRoles;
    }

    @RequestMapping("/new")
    public String CreateRole() {
        roleService.save();
        return "ok";
    }
}
