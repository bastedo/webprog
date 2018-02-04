package rest.mvc;

import core.entites.Pravilo;
import core.entites.Pravilo;
import core.services.PodforumService;
import core.services.PraviloService;
import core.services.exceptions.PraviloExistsException;
import core.services.util.PraviloList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rest.exceptions.ConflictException;
import rest.resources.PraviloResource;
import rest.resources.PraviloResource;
import rest.resources.asm.PraviloResourceAsm;
import rest.resources.asm.PraviloResourceAsm;
import rest.resources.asm.list.PraviloListResourceAsm;
import rest.resources.list.PraviloListResource;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
@RequestMapping("/rest/pravilos")
public class PraviloController {

    private PraviloService praviloService ;
    private PodforumService podforumService;
    @Autowired
    
    

    public PraviloController(PodforumService podforumService, PraviloService praviloService) {
        this.podforumService = podforumService;
        this.praviloService = praviloService ;

    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<PraviloListResource> findAllPravilos(@RequestParam(value="name", required = false) String name) {
        PraviloList list = null;
        if(name == null) {
            list = praviloService.findAllPravilos();
        } else {
            Pravilo pravilo = praviloService.findPraviloByName(name);
            if(pravilo == null) {
                list = new PraviloList(new ArrayList<Pravilo>());
            } else {
                list = new PraviloList(Arrays.asList(pravilo));
            }
        }
        PraviloListResource res = new PraviloListResourceAsm().toResource(list);
        return new ResponseEntity<PraviloListResource>(res, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<PraviloResource> createPravilo(@RequestBody PraviloResource sentPravilo) {
        try {
            Pravilo createdPravilo = praviloService.createPravilo(sentPravilo.toPravilo());
            PraviloResource res = new PraviloResourceAsm().toResource(createdPravilo);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(res.getLink("self").getHref()));
            return new ResponseEntity<PraviloResource>(res, headers, HttpStatus.CREATED);
        } catch(PraviloExistsException exception) {
            throw new ConflictException(exception);
        }
    }

    @RequestMapping( value="/create", method = RequestMethod.GET)
    public ResponseEntity<PraviloResource> createPraviloStatic() {

        try {

            for (int i= 0 ; i<5; i++) {

                Pravilo tempPravilo = new Pravilo();
                tempPravilo.setNazivPravila("naziv pravila " + i);
                tempPravilo.setSadrzajPravila("sadrzaj pravila je "+ i);
                Pravilo createdPravilo = praviloService.createPravilo(tempPravilo);
            }
            Pravilo tempPravilo = new Pravilo();
            tempPravilo.setNazivPravila("naziv pravila 99" );
            tempPravilo.setSadrzajPravila("sadrzaj pravila je 99");

            Pravilo createdPravilo = praviloService.createPravilo(tempPravilo);
            PraviloResource res = new PraviloResourceAsm().toResource(createdPravilo);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(res.getLink("self").getHref()));
            return new ResponseEntity<PraviloResource>(res, headers, HttpStatus.CREATED);
        } catch(PraviloExistsException exception) {
            throw new ConflictException(exception);
        }

    }



    @RequestMapping( value="/{praviloId}", method = RequestMethod.GET)
    public ResponseEntity<PraviloResource> getPravilo(@PathVariable Long praviloId) {
        Pravilo pravilo = praviloService.findPravilo(praviloId);
        if(pravilo != null)
        {
            PraviloResource res = new PraviloResourceAsm().toResource(pravilo);
            return new ResponseEntity<PraviloResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<PraviloResource>(HttpStatus.NOT_FOUND);
        }
    }
}
