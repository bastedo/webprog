package rest.mvc;

import core.entites.Poruka;
import core.services.AccountService;
import core.services.PorukaService;
import core.services.exceptions.PorukaExistsException;
import core.services.util.PorukaList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rest.exceptions.ConflictException;
import rest.resources.PorukaResource;
import rest.resources.asm.PorukaResourceAsm;
import rest.resources.asm.list.PorukaListResourceAsm;
import rest.resources.list.PorukaListResource;

import java.net.URI;


@Controller
@RequestMapping("/rest/porukas")
public class PorukaController {

    private PorukaService porukaService;
    private AccountService accountService;

    @Autowired
    public PorukaController(PorukaService porukaService, AccountService accountService) {
        this.porukaService = porukaService ;
        this.accountService = accountService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<PorukaListResource> findAllPorukas() {
        PorukaList list = porukaService.findAllPorukas();

        PorukaListResource res = new PorukaListResourceAsm().toResource(list);
        return new ResponseEntity<PorukaListResource>(res, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<PorukaResource> createPoruka (@RequestBody PorukaResource sentPoruka) {
        try {
            Poruka createdPodforum = porukaService.createPoruka(sentPoruka.toPoruka());
            PorukaResource res = new PorukaResourceAsm().toResource(createdPodforum);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(res.getLink("self").getHref()));
            return new ResponseEntity<PorukaResource>(res, headers, HttpStatus.CREATED);
        } catch(PorukaExistsException exception) {
            throw new ConflictException(exception);
        }
    }


    @RequestMapping( value="/{porukaId}", method = RequestMethod.GET)
    public ResponseEntity<PorukaResource> getPoruka(@PathVariable Long porukaId) {
        Poruka poruka = porukaService.findPoruka(porukaId);
        if(poruka != null)
        {
            PorukaResource res = new PorukaResourceAsm().toResource(poruka);
            return new ResponseEntity<PorukaResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<PorukaResource>(HttpStatus.NOT_FOUND);
        }
    }
}
