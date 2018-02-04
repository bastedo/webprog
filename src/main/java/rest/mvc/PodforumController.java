package rest.mvc;


import core.entites.Account;
import core.entites.Podforum;
import core.entites.Pravilo;
import core.services.AccountService;
import core.services.PodforumService;
import core.services.PraviloService;
import core.services.exceptions.PodforumExistsException;
import core.services.util.PodforumList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rest.exceptions.ConflictException;
import rest.resources.AccountResource;
import rest.resources.PodforumResource;
import rest.resources.asm.AccountResourceAsm;
import rest.resources.asm.PodforumResourceAsm;
import rest.resources.asm.list.PodforumListResourceAsm;
import rest.resources.list.PodforumListResource;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/rest/podforum")
public class PodforumController {

    private PraviloService praviloService ;
    private  AccountService accountService ;
    private PodforumService podforumService;
    @Autowired


    public PodforumController(PodforumService podforumService, AccountService accountService, PraviloService praviloService ) {
        this.podforumService = podforumService;
        this.accountService = accountService ;
        this.praviloService = praviloService ;

    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<PodforumListResource> findAllPodforums(@RequestParam(value="name", required = false) String name) {
        PodforumList list = null;
        if(name == null) {
            list = podforumService.findAllPodforums();
        } else {
            Podforum account = podforumService.findPodforumByName(name);
            if(account == null) {
                list = new PodforumList(new ArrayList<Podforum>());
            } else {
                list = new PodforumList(Arrays.asList(account));
            }
        }
        PodforumListResource res = new PodforumListResourceAsm().toResource(list);
        return new ResponseEntity<PodforumListResource>(res, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<PodforumResource> createPodforum(@RequestBody PodforumResource sentPodforum) {
        try {
            Podforum createdPodforum = podforumService.createPodforum(sentPodforum.toPodforum());
            PodforumResource res = new PodforumResourceAsm().toResource(createdPodforum);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(res.getLink("self").getHref()));
            return new ResponseEntity<PodforumResource>(res, headers, HttpStatus.CREATED);
        } catch(PodforumExistsException exception) {
            throw new ConflictException(exception);
        }
    }



    @RequestMapping( value="/{podforumId}", method = RequestMethod.GET)
    public ResponseEntity<PodforumResource> getPodforum(@PathVariable Long podforumId) {
        Podforum podforum = podforumService.findPodforum(podforumId);
        if(podforum != null)
        {
            PodforumResource res = new PodforumResourceAsm().toResource(podforum);
            return new ResponseEntity<PodforumResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<PodforumResource>(HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping( value="/createp", method = RequestMethod.GET)
    public ResponseEntity<PodforumResource> createPodforumStatic() {
        Account account = accountService.findAccount(1L);
        Pravilo pravilo1 = praviloService.findPravilo(1L);
        Pravilo pravilo2 = praviloService.findPravilo(2L);
        if(account != null)
        {
            Podforum tempPodforum = new Podforum();
            tempPodforum.setAutor(account);
            tempPodforum.setOpis("Ovo je opis");
            tempPodforum.setOdgovorniModerator(account);
            tempPodforum.setNaziv("Ovo je naziv");
            Set<Pravilo> spisakPravilas = new HashSet<>();
            spisakPravilas.add(pravilo1);
            spisakPravilas.add(pravilo2);
            tempPodforum.setSpisakPravilas(spisakPravilas);

            Podforum createdPodforum = podforumService.createPodforum(tempPodforum);
            PodforumResource res = new PodforumResourceAsm().toResource(createdPodforum);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(res.getLink("self").getHref()));

            return new ResponseEntity<PodforumResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<PodforumResource>(HttpStatus.NOT_FOUND);
        }


    }


}
