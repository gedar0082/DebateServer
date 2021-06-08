package com.debater.debaterserver.controller;

import com.debater.debaterserver.entity.*;

import static org.assertj.core.api.Assertions.assertThat;

import com.debater.debaterserver.util.Utility;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MainControllerTest {

    @Autowired
    private MainController controller;

    private boolean equalsWithoutPassword(Person p1, Person p2){
        return p1.getId().equals(p2.getId()) && p1.getEmail().equals(p2.getEmail()) && p1.getNickname().equals(p2.getNickname());
    }

    @Test
    public void contextLoads(){
        assertThat(controller).isNotNull();
    }

    @Test
    public void getPersons() {
        List<Person> personList = controller.getPersons();
        assertThat(personList).isNotNull();
    }

    @Test
    public void getPersonById(){
        List<Person> personList = controller.getPersons();
        Long id = personList.get(2).getId();
        Person p = controller.getPersonById(id);
        assertThat(p.getNickname()).isEqualTo(personList.get(2).getNickname());
    }

    @Test
    public void getPersonByEmail(){
        String email = "gedar0082@gmail.com";
        Person person = controller.getPersonByEmail(email);
        List<Person> personList = controller.getPersons();
        Person p2 = null;
        for (Person p : personList){
            if (p.getEmail().equals(email)){
                p2 = p;
            }
        }

        assert p2 != null;
        assertThat(equalsWithoutPassword(person, p2)).isTrue();
    }

    @Test
    public void deleteInsertPersonById(){
        Person p = controller.insertPerson(new PersonAuthenticationJson("a", "b", "c"));
        List<Person> pl = controller.getPersons();
        controller.deletePersonById(p.getId());
        List<Person> pl2 = controller.getPersons();
        assertThat(pl).isNotEqualTo(pl2);
    }

    @Test
    public void getAllDebates(){
        List<Debate> debates = controller.getAllDebates();
        assertThat(debates).isNotNull();
    }

    @Test
    public void getDebateById(){
        List<Debate> debates = controller.getAllDebates();
        Long id = debates.get(0).getId();
        Debate debate = controller.getDebateById(id);
        assertThat(debate.toString().equals(debates.get(0).toString())).isTrue();
    }

    @Test
    public void deleteInsertDebate(){
        Debate debate = new Debate();
        debate.setId(0L);
        debate.setName("");
        debate.setDescription("");
        debate.setDateStart(Utility.getCurrentTimeGMT());
        Regulations regulations = new Regulations();
        regulations.setId(0);
        regulations.setRuleType(1);
        debate.setRegulations(regulations);

        Debate debate1 = controller.insertDebate(debate);
        List<Debate> debates = controller.getAllDebates();
        controller.deleteDebateById(debate1.getId());
        List<Debate> debates2 = controller.getAllDebates();
        assertThat(debates).isNotEqualTo(debates2);
    }

    @Test
    public void getPersonDebate(){
        List<PersonDebate> pdl = controller.getPersonDebate();
        PersonDebate pd = pdl.get(0);
        List<PersonDebate> d = controller.getPersonDebateByDebateId(pd.getDebate().getId());
        List<PersonDebate> p = controller.getPersonDebateByPersonId(pd.getPerson().getId());
        PersonDebate pd1 = controller.getPersonDebateByDebateIdAndPersonId(pd.getDebate().getId(), pd.getPerson().getId());
        assertThat(pd1.getDebate().toString().equals(d.get(0).getDebate().toString())).isTrue();
        assertThat(pd1.getPerson().toString().equals(p.get(0).getPerson().toString())).isTrue();

    }

    @Test
    public void getThesesByDebateId(){
        List<Thesis> theses = controller.getThesesByDebateId(108L);
        assertThat(theses).isNotNull();
    }

    @Test void getArgumentsByDebateId(){
        List<Argument> arguments = controller.getArgumentsByDebateId(108L);
        assertThat(arguments).isNotNull();
    }

}