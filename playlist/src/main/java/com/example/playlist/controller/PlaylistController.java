package com.example.playlist.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.playlist.domain.Playlist;
import com.example.playlist.service.PlaylistService;


@Controller
public class PlaylistController {
	
	@Autowired
    private PlaylistService service;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Playlist> listplaylist = service.listAll();
        model.addAttribute("listplaylist", listplaylist);
        System.out.print("Get / "); 
        return "index";
    }

    @GetMapping("/addplaylist")
    public String add(Model model) {
        model.addAttribute("playlist", new Playlist());
        return "addplaylist";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveplaylist(@ModelAttribute("playlist") Playlist playlist) {
        service.save(playlist);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditplaylistPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("addplaylist");
        Playlist playlist = service.get(id);
        mav.addObject("playlist", playlist);
        return mav;
        
    }
    @RequestMapping("/delete/{id}")
    public String deleteplaylist(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
	    }

