package com.debater.debaterserver.controller;

import com.debater.debaterserver.entity.*;
import com.debater.debaterserver.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api")
@Api(value = "Debater api", description = "List of available operations with debater server")
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

    @ApiOperation(value = "get one person by Id", response = Person.class)
    @GetMapping("/getPersonById")
    @ResponseBody Person getPersonById(@RequestParam Long id){
        return personService.getPersonById(id);
    }

    @ApiOperation(value = "get one person by Email", response = Person.class)
    @GetMapping("/getPersonByEmail")
    @ResponseBody Person getPersonByEmail(@RequestParam String email){
        return personService.getPersonByEmail(email);
    }

    @ApiOperation(value = "get all existing persons", response = List.class)
    @GetMapping("/getAllPersons")
    @ResponseBody List<Person> getPersons(){
        List<Person> personList = personService.getAllPersons();
        personList.forEach(it -> it.setPassword(""));
        return personList;
    }

    @ApiOperation(value = "delete one person by id", response = ResponseEntity.class)
    @DeleteMapping("/deletePersonById")
    ResponseEntity<Void> deletePersonById(@RequestParam Long id) {
        personService.deletePersonById(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "update person(mapped by inner id)", response = Person.class)
    @PutMapping("/updatePerson")
    @ResponseBody Person updatePerson(@RequestBody Person person){
        return personService.updatePerson(person);

    }

    @ApiOperation(value = "post a person without id to check correct registration." +
            " Will return ResponseEntity with BodyMessageJson.Class." +
            " In BodyMessageJson.Class will be a HttpStatusCode and (optional) error message.", response = ResponseEntity.class)
    @PostMapping("/checkRegistration")
    ResponseEntity<BodyMessageJson> checkRegistration(@RequestBody PersonAuthenticationJson personAuthenticationJson){
        if (!personService.existPersonByEmail(personAuthenticationJson.getEmail())){
            return ResponseEntity.ok().body(new BodyMessageJson("OK"));
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BodyMessageJson("This person already exist"));
        }
    }

    @ApiOperation(value = "post a person without id to check correct password." +
            " Will return ResponseEntity with BodyMessageJson.Class." +
            " In BodyMessageJson.Class will be a HttpStatusCode and (optional) error message.", response = ResponseEntity.class)
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

    @ApiOperation(value = "insert a person data without id", response = Person.class)
    @PostMapping("/insertPerson")
    @ResponseBody Person insertPerson(@RequestBody PersonAuthenticationJson person) {
        Person registrationPerson = new Person(0L, person.getNickname(), person.getEmail(), person.getPassword());
        return personService.insertPerson(registrationPerson);
    }

    /*
    debate block
     */

    @ApiOperation(value = "get debate by id", response = Debate.class)
    @GetMapping("/getDebateById")
    @ResponseBody Debate getDebateById(@RequestParam Long id){
        return debateService.getDebateById(id);
    }

    @ApiOperation(value = "get all existing debates", response = List.class)
    @GetMapping("/getAllDebates")
    @ResponseBody List<Debate> getAllDebates(){
        return debateService.getAllDebates();
    }

    @ApiOperation(value = "delete debate by id", response = ResponseEntity.class)
    @DeleteMapping("/deleteDebateById")
    ResponseEntity<Void> deleteDebateById(@RequestParam Long id){
        debateService.deleteDebateById(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "update debate(mapped by inner id)", response = ResponseEntity.class)
    @PutMapping("/updateDebate")
    ResponseEntity<Void> updateDebate(@RequestBody Debate debate){
        debateService.updateDebate(debate);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "insert debate", response = Debate.class)
    @PostMapping("/insertDebate")
    @ResponseBody Debate insertDebate(@RequestBody Debate debate){
        return debateService.insertDebate(debate);
    }

    /*
    person-debate block
     */

    @ApiOperation(value = "get person_debate field by all PK", response = PersonDebate.class)
    @GetMapping("/getPersonDebateByDebateIdAndPersonId")
    @ResponseBody PersonDebate getPersonDebateByDebateIdAndPersonId(@RequestParam Long debate_id, Long person_id){
        PersonDebate personDebate = personDebateService.getPersonDebateByDebate_IdAndPerson_Id(debate_id, person_id);
        personDebate.getPerson().setPassword("");
        return personDebate;
    }

    @ApiOperation(value = "get person_debate field only by debate_id", response = List.class)
    @GetMapping("/getPersonDebateByDebateId")
    @ResponseBody List<PersonDebate> getPersonDebateByDebateId(@RequestParam Long debate_id){
        List<PersonDebate> personDebateList = personDebateService.getPersonDebateByDebate_Id(debate_id);
        personDebateList.forEach(it -> it.getPerson().setPassword(""));
        return personDebateList;
    }

    @ApiOperation(value = "get person_debate field only by person_id", response = List.class)
    @GetMapping("/getPersonDebateByPersonId")
    @ResponseBody List<PersonDebate> getPersonDebateByPersonId(@RequestParam Long person_id){
        List<PersonDebate> personDebateList = personDebateService.getPersonDebateByPerson_Id(person_id);
        personDebateList.forEach(it -> it.getPerson().setPassword(""));
        return personDebateList;
    }

    @ApiOperation(value = "get all existing person_debate fields", response = List.class)
    @GetMapping("/getPersonDebate")
    @ResponseBody List<PersonDebate> getPersonDebate(){
        List<PersonDebate> personDebateList = personDebateService.getPersonDebate();
        personDebateList.forEach(it -> it.getPerson().setPassword(""));
        return personDebateList;
    }

    @ApiOperation(value = "delete person_debate field by PersonDebateRaw.class(contains ids of 3 existing fields)",
            response = ResponseEntity.class)
    @Deprecated
    @DeleteMapping("/deletePersonDebate")
    ResponseEntity<Void> deletePersonDebate(@RequestBody PersonDebateRaw pdr){
        personDebateService.deletePersonDebate(pdr);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "update person_debate field by PersonDebateRaw.class(contains ids of 3 existing fields)." +
            "updates only right field", response = ResponseEntity.class)
    @PutMapping("/updatePersonDebate")
    ResponseEntity<Void> updatePersonDebate(@RequestBody PersonDebate personDebate){
        personDebateService.updatePersonDebate(personDebate);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "insert person_debate field by PersonDebateRaw(3 fields` ids)", response = ResponseEntity.class)
    @PostMapping("/insertRawPersonDebate")
    ResponseEntity<Void> insertRawPersonDebate(@RequestBody PersonDebateRaw personDebateRaw){
        personDebateService.insertRawPersonDebate(personDebateRaw);
        return ResponseEntity.ok().build();
    }

    /*
    thesis block
     */

    @ApiOperation(value = "get theses (List<Thesis>) by debate id", response = List.class )
    @GetMapping("/getThesesByDebateId")
    @ResponseBody List<Thesis> getThesesByDebateId(@RequestParam Long id){
        List<Thesis> thesisList = thesisService.getThesesByDebateId(id);
        thesisList.forEach(it -> it.getPerson().setPassword(""));
        return thesisList;
    }

    @ApiOperation(value = "insert raw thesis(object fields replaced to its ids)", response = Long.class)
    @PostMapping("/insertThesisRaw")
    @ResponseBody Long insertThesisRaw(@RequestBody ThesisRaw thesisRaw){
        return thesisService.insertThesisRaw(thesisRaw);
    }

    @ApiOperation(value = "get arguments by debate_id", response = List.class)
    @GetMapping("/getArgumentsByDebateId")
    @ResponseBody List<Argument> getArgumentsByDebateId(@RequestParam Long id){
        List<Argument> argumentList = argumentService.getArgumentsByDebateId(id);
        argumentList.forEach(it -> it.getPerson_id().setPassword(""));
        return argumentList;
    }

    @ApiOperation(value = "insert raw argument", response = Long.class)
    @PostMapping("/insertArgumentRaw")
    @ResponseBody Long insertArgumentRaw(@RequestBody ArgumentRaw argument){
        return argumentService.insertArgumentRaw(argument);
    }

    @ApiOperation(value = "delete Right by its id", response = ResponseEntity.class)
    @DeleteMapping("/deleteRightById")
    ResponseEntity<Void> deleteRightById(@RequestParam Long id){
        rightsService.deleteRightById(id);
        return ResponseEntity.ok().build();
    }

}
