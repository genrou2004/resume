package com.resume.controller;

import com.resume.model.Education;
import com.resume.model.Person;
import com.resume.repository.EducationRepository;
import com.resume.repository.ExperienceRepository;
import com.resume.repository.PersonRepository;
import com.resume.repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

/**
 * Created by student on 6/29/17.
 */
@Controller
public class ResumeController {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private EducationRepository educationRepository;
    @Autowired
    private ExperienceRepository experienceRepository;
    @Autowired
    private SkillsRepository skillsRepository;


    @RequestMapping("/display")
    public String displayProfile(Model model){
        model.addAttribute("persons", personRepository.findAll());
        return "display";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {

        model.addAttribute("person", new Person());
        return "signup";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String processRegistrationForm(@ModelAttribute Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }
        personRepository.save(person);
        return "redirect:/display";
    }

    @RequestMapping(value = "/education", method = RequestMethod.GET)
    public String getEducationForm(Model model) {

        model.addAttribute("education", new Education());
        return "education";
    }

    @RequestMapping(value = "/education", method = RequestMethod.POST)
    public String processEducationForm(@ModelAttribute Education education, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "education";
        }
        educationRepository.save(education);
        return "redirect:/display";
    }
}
