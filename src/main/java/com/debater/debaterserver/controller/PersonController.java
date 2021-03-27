package com.debater.debaterserver.controller;

import com.debater.debaterserver.entity.*;
import com.debater.debaterserver.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonDebateService personDebateService;

    @Autowired
    private DebateService debateService;

    @Autowired
    private ThesisService thesisService;

    @Autowired
    private ArgumentService argumentService;

//    получить всех персон
    @GetMapping("/persons")
    List<Person> getAllPersons() { return personService.findAllPerson(); }

//  получить конкретную персону по имени
    @GetMapping("/personNickname")
    @ResponseBody List<Person> findAllPersonByNickname(@RequestParam String nickname) {return personService.findAllPersonByNickname(nickname);}

//    получить конкретную персону по id
    @GetMapping("/personId")
    @ResponseBody Person findPersonById(@RequestParam Integer id) {return personService.findPersonById(id);}

//    получить дебаты с правилами конкретной песоны по имени
    @GetMapping("/debateByPersonNickname")
    @ResponseBody List<Debate> findDebateFromPersonNickname (@RequestParam String nickname) {
        List<PersonDebate> pd =  personDebateService.findPersonDebateByPersonNickname(nickname);
        List<Debate> d = new ArrayList<>();
        pd.forEach(it -> d.add(it.getDebate()));
        return d;
    }

//    получить дебаты с правилами конкретной персоны по id
    @GetMapping("debateByPersonId")
    @ResponseBody List<Debate> findDebateFromPersonId(@RequestParam Integer id){
        List<PersonDebate> pd = personDebateService.findPersonDebateByPersonId(id);
        List<Debate> d = new ArrayList<>();
        pd.forEach(it -> d.add(it.getDebate()));
        return d;
    }

//    получить дебаты, правила, права персоны по имени
    @GetMapping("/personDebateByPersonNickname")
    @ResponseBody List<PersonDebate> getAllAboutDebateByPersonNickname (@RequestParam String nickname) {
        return   personDebateService.findPersonDebateByPersonNickname(nickname);
    }

//    получить дебаты, правила, права персоны по id
    @GetMapping("/personDebateByPersonId")
    @ResponseBody List<PersonDebate> getAllAboutDebateByPersonId (@RequestParam Integer id) {
        return   personDebateService.findPersonDebateByPersonId(id);
    }

//    получить все идущие дебаты
    @GetMapping("/debates")
    List<Debate> getAllDebates() { return debateService.findAllDebate();}

//    получить персон конкретных дебатах по id
    @GetMapping("personsByDebateId")
    @ResponseBody List<Person> getPersonsByDebateId(@RequestParam Integer id){
        List<PersonDebate> pd = personDebateService.findPersonDebateByDebateId(id);
        List<Person> p = new ArrayList<>();
        pd.forEach(it -> p.add(it.getPerson()));
        return p;
    }

    @GetMapping("/thesesByDebateId")
    @ResponseBody List<Thesis> findAllThesisByDebateId(@RequestParam Integer id){
        return thesisService.findAllByDebateId(id);
    }

    @GetMapping("/thesisById")
    @ResponseBody Thesis findThesisById(@RequestParam Integer id){
        return thesisService.findThesisById(id);
    }

    @GetMapping("/argumentsByThesisId")
    @ResponseBody List<Argument> getArgumentByThesisId(@RequestParam Integer id){
        return argumentService.getArgumentByThesis_Id(id);
    }

    @GetMapping("/argumentsByDebateId")
    @ResponseBody List<Argument> getArgumentByDebateId(@RequestParam Integer id){
        return argumentService.getArgumentByDebate_id(id);
    }

    @GetMapping("/argumentById")
    @ResponseBody Argument getArgumentById(@RequestParam Integer id){
        return argumentService.getArgumentById(id);
    }

    /**
     * post
     */

    @PostMapping("/savePerson")
    ResponseEntity<Void> savePerson(@RequestBody Person person){
        personService.createPerson(person);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/savePersonDebate")
    ResponseEntity<Void> savePersonDebate(@RequestBody PersonDebate personDebate){
        personDebateService.createPersonDebate(personDebate);
        return ResponseEntity.ok().build();
    }



}
