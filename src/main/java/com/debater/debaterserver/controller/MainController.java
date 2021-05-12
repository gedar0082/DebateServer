package com.debater.debaterserver.controller;

import com.debater.debaterserver.entity.*;
import com.debater.debaterserver.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class MainController {

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

    @Autowired
    private RightsService rightsService;



    /*
    person block
     */

    @GetMapping("/getPersonById")
    @ResponseBody Person getPersonById(@RequestParam Long id){
        return personService.getPersonById(id);
    }

    @GetMapping("/getPersonByEmail")
    @ResponseBody Person getPersonByEmail(@RequestParam String email){
        return personService.getPersonByEmail(email);
    }

    @GetMapping("/getAllPersons")
    @ResponseBody List<Person> getPersons(){
        return personService.getAllPersons();
    }

    @DeleteMapping("/deletePersonById")
    ResponseEntity<Void> deletePersonById(@RequestParam Long id) {
        personService.deletePersonById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updatePerson")
    @ResponseBody Person updatePerson(@RequestBody Person person){
        return personService.updatePerson(person);

    }

    @PostMapping("/checkRegistration")
    ResponseEntity<BodyMessageJson> checkRegistration(@RequestBody PersonAuthenticationJson personAuthenticationJson){
        if (!personService.existPersonByEmail(personAuthenticationJson.getEmail())){
            return ResponseEntity.ok().body(new BodyMessageJson("OK"));
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BodyMessageJson("This person already exist"));
        }
    }

    @PostMapping("/checkAuthentication")
    ResponseEntity<BodyMessageJson> checkAuthentication(@RequestBody PersonAuthenticationJson personAuthenticationJson){
        if (personService.existPersonByEmail(personAuthenticationJson.getEmail())){
            Person currentPerson = personService.getPersonByEmail(personAuthenticationJson.getEmail());
            if (currentPerson.getPassword().equals(personAuthenticationJson.getPassword())){
                return ResponseEntity.ok().body(new BodyMessageJson("OK"));
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BodyMessageJson("Incorrect password"));
            }
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BodyMessageJson("person does not exist"));
        }
    }

    @PostMapping("/insertPerson")
    @ResponseBody Person insertPerson(@RequestBody PersonAuthenticationJson person) {
        Person registrationPerson = new Person(0L, person.getNickname(), person.getEmail(), person.getPassword());
        return personService.insertPerson(registrationPerson);
    }

    /*
    debate block
     */

    @GetMapping("/getDebateById")
    @ResponseBody Debate getDebateById(@RequestParam Long id){
        return debateService.getDebateById(id);
    }

    @GetMapping("/getAllDebates")
    @ResponseBody List<Debate> getAllDebates(){
        return debateService.getAllDebates();
    }

    @DeleteMapping("/deleteDebateById")
    ResponseEntity<Void> deleteDebateById(@RequestParam Long id){
        debateService.deleteDebateById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateDebate")
    ResponseEntity<Void> updateDebate(@RequestBody Debate debate){
        debateService.updateDebate(debate);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/insertDebate")
    @ResponseBody Debate insertDebate(@RequestBody Debate debate){
        System.out.println("insert debate " + debate.toString());
        return debateService.insertDebate(debate);
    }

    /*
    person-debate block
     */

    @GetMapping("/getPersonDebateByDebateIdAndPersonId")
    @ResponseBody PersonDebate getPersonDebateByDebateIdAndPersonId(@RequestParam Long debate_id, Long person_id){
        return personDebateService.getPersonDebateByDebate_IdAndPerson_Id(debate_id, person_id);
    }

    @GetMapping("/getPersonDebateByDebateId")
    @ResponseBody List<PersonDebate> getPersonDebateByDebateId(@RequestParam Long debate_id){
        return personDebateService.getPersonDebateByDebate_Id(debate_id);
    }

    @GetMapping("/getPersonDebateByPersonId")
    @ResponseBody List<PersonDebate> getPersonDebateByPersonId(@RequestParam Long person_id){
        return personDebateService.getPersonDebateByPerson_Id(person_id);
    }

    @GetMapping("/getPersonDebate")
    @ResponseBody List<PersonDebate> getPersonDebate(){
        return personDebateService.getPersonDebate();
    }

    @Deprecated
    @DeleteMapping("/deletePersonDebate")
    ResponseEntity<Void> deletePersonDebate(@RequestBody PersonDebateRaw pdr){
        System.out.println("deleting person_debate = " + pdr.toString());
        personDebateService.deletePersonDebate(pdr);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updatePersonDebate")
    ResponseEntity<Void> updatePersonDebate(@RequestBody PersonDebate personDebate){
        personDebateService.updatePersonDebate(personDebate);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/insertRawPersonDebate")
    ResponseEntity<Void> insertRawPersonDebate(@RequestBody PersonDebateRaw personDebateRaw){
        System.out.println("insert person_debate raw = " + personDebateRaw.toString());
        personDebateService.insertRawPersonDebate(personDebateRaw);
        return ResponseEntity.ok().build();
    }

    /*
    thesis block
     */

    @GetMapping("/getThesesByDebateId")
    @ResponseBody List<Thesis> getThesesByDebateId(@RequestParam Long id){
        //System.out.println("get theses");
        List<Thesis> list = thesisService.getThesesByDebateId(id);
        //System.out.println("theses = " + list.toString());
        return list;
    }

    @PostMapping("/insertThesis")
    @ResponseBody Thesis insertThesis(@RequestBody Thesis thesis){
        System.out.println("insert thesis : " + thesis.toString());
        return thesisService.insertThesis(thesis);
    }

    @PostMapping("/insertThesisRaw")
    @ResponseBody Long insertThesisRaw(@RequestBody ThesisRaw thesisRaw){
        //System.out.println(thesisRaw.toString());
        return thesisService.insertThesisRaw(thesisRaw);
    }

    @PostMapping("/insertThesisRaw2")
    @ResponseBody Long insertThesisRaw2(@RequestBody ThesisRaw thesisRaw){
        //System.out.println(thesisRaw.toString());
        return thesisService.insertThesisRaw2(thesisRaw);
    }

    @GetMapping("/getArgumentsByDebateId")
    @ResponseBody List<Argument> getArgumentsByDebateId(@RequestParam Long id){
        return argumentService.getArgumentsByDebateId(id);
    }

    @PostMapping("/insertArgumentRaw")
    @ResponseBody Long insertArgumentRaw(@RequestBody ArgumentRaw argument){
        return argumentService.insertArgumentRaw(argument);
    }

    @PostMapping("/insertArgumentWithoutAnswerRaw")
    @ResponseBody Long insertArgumentWithoutAnswerRaw(@RequestBody ArgumentRaw argument){
        System.out.println(argument.toString());
        return argumentService.insertArgumentWithoutAnswerRaw(argument);
    }

    @DeleteMapping("/deleteRightById")
    ResponseEntity<Void> deleteRightById(@RequestParam Long id){
        rightsService.deleteRightById(id);
        return ResponseEntity.ok().build();
    }









}
