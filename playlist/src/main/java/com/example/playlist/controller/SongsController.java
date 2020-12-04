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
import com.example.playlist.domain.Songs;
import com.example.playlist.service.SongsService;

@Controller
public class SongsController {
	@Autowired
    private SongsService service;

    @GetMapping("/viewsong/{id}")
    public String viewHomePage(Model model,@PathVariable(name = "id") int id) {
    	long no = id;
        List<Songs> listsongs = service.listById(no);
        model.addAttribute("listsongs", listsongs);
        return "viewsong";
    }

    @GetMapping("/addsong")
    public String add(Model model) {
        model.addAttribute("Songs", new Songs());
        return "addsong";
    }

    @RequestMapping(value = "/savesong", method = RequestMethod.POST)
    public String saveSong(@ModelAttribute("Songs")Songs songs) {
        service.save(songs);
        return "redirect:/";
    }

    @RequestMapping("/editsong/{id}")
    public ModelAndView showEditSongPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("addsong");
        Songs songs = service.get(id);
        mav.addObject("songs",songs);
        return mav;
        
    }
    @RequestMapping("/deletesong/{id}")
    public String deletesong(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }

}
