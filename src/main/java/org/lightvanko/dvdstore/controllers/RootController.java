package org.lightvanko.dvdstore.controllers;

import org.lightvanko.dvdstore.data.Disk;
import org.lightvanko.dvdstore.data.TakenItem;
import org.lightvanko.dvdstore.data.User;
import org.lightvanko.dvdstore.persistences.DiskDao;
import org.lightvanko.dvdstore.persistences.TakenItemDao;
import org.lightvanko.dvdstore.persistences.UserDao;
import org.lightvanko.dvdstore.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class RootController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private DiskDao diskDao;

    @Autowired
    private TakenItemDao takenItemDao;

    @Autowired
    private UserRepository userRepository;

    @ModelAttribute("auth")
    public Authentication auth() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @ModelAttribute("authUser")
    public User authUser() {
        return userRepository.findByUsername(auth().getName());
    }

    @RequestMapping(value={"/"}, method = RequestMethod.GET)
    public String root(Model model) {
        return "pages/index";
    }

    @RequestMapping(value={"/login"}, method = RequestMethod.GET)
    public String login(Model model) {
        if (authUser() == null) {
            return "pages/login";
        }else{
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/login/success", method = RequestMethod.GET)
    public String loginSubmit(Model model) {
        model.addAttribute("type", "alert-success");
        model.addAttribute("topic", "Успех!");
        model.addAttribute("message", "Привет, " + authUser().getUsername() +"!");
        return "pages/done";
    }

    @RequestMapping(value = "/login/failed", method = RequestMethod.GET)
    public String loginFailed(Model model) {
        if (authUser() == null) {
            model.addAttribute("type", "alert-danger");
            model.addAttribute("topic", "Ошибка");
            model.addAttribute("message", "Неверные имя пользователя или пароль!");
            return "pages/done";
        }else{
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/free", method = RequestMethod.GET)
    public String freeDisks(Model model) {
        model.addAttribute("notTakenItems", diskDao.getNotTakenItems());
        return "pages/free";
    }

    @RequestMapping(value = "/free", method = RequestMethod.POST)
    public String freeDisksSubmit(@RequestParam long diskId, Model model) {
        if (diskDao.getById(diskId).getUser().getId() == authUser().getId()) {
            model.addAttribute("type", "alert-danger");
            model.addAttribute("topic", "Ошибка");
            model.addAttribute("message", "Нельзя взять диск у самого себя!");
        } else {
            model.addAttribute("type", "alert-success");
            model.addAttribute("topic", "Успех!");
            model.addAttribute("message", "Диск с названием \"" + diskDao.getById(diskId).getCapture() + "\" взят у пользователя " + diskDao.getById(diskId).getUser().getUsername() + ".");
            takenItemDao.create(new TakenItem(userDao.getById(authUser().getId()), diskDao.getById(diskId)));
        }
        return "pages/done";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createDisk(Model model) {
        model.addAttribute("disk", new Disk());
        return "pages/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createDiskSubmit(@RequestParam String capture, Model model) {
        model.addAttribute("type", "alert-success");
        model.addAttribute("topic", "Успех!");
        model.addAttribute("message", "Диск с названием \"" + capture +"\" успешно создан!");
        diskDao.create(new Disk(capture, userDao.getById(authUser().getId())));
        return "pages/done";
    }

    @RequestMapping(value = "/taken", method = RequestMethod.GET)
    public String takenDisks(Model model) {
        model.addAttribute("takenByUserItems", takenItemDao.getTakenByUserItems(authUser().getId()));
        return "pages/taken";
    }

    @RequestMapping(value = "/taken", method = RequestMethod.POST)
    public String takenDisksSubmit(@RequestParam long itemId, Model model) {
        model.addAttribute("type", "alert-success");
        model.addAttribute("topic", "Успех!");
        model.addAttribute("message", "Диск с названием \"" + takenItemDao.getById(itemId).getDisk().getCapture() +"\" отдан обратно пользователю " + takenItemDao.getById(itemId).getDisk().getUser().getUsername() + ".");
        takenItemDao.delete(takenItemDao.getById(itemId));
        return "pages/done";
    }

    @RequestMapping(value = "/given", method = RequestMethod.GET)
    public String givenDisks(Model model) {
        model.addAttribute("givenByUserItems", takenItemDao.getGivenByUserItems(authUser().getId()));
        return "pages/given";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about (Model model) {
        return "pages/about";
    }
}
