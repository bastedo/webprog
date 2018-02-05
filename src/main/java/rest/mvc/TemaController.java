package rest.mvc;


import core.entites.Account;
import core.entites.Podforum;
import core.entites.Tema;
import core.services.AccountService;
import core.services.PodforumService;
import core.services.TemaService;
import core.services.util.TemaList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rest.resources.TemaResource;
import rest.resources.asm.TemaResourceAsm;
import rest.resources.asm.list.TemaListResourceAsm;
import rest.resources.list.TemaListResource;

@Controller
@RequestMapping("/rest/temas")
public class TemaController {

    private TemaService temaService;
    private AccountService accountService;
    private PodforumService podforumService;

    @Autowired
    public TemaController(TemaService temaService, AccountService accountService) {
        this.temaService = temaService ;
        this.accountService = accountService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<TemaListResource> findAllTemas() {
        TemaList list = temaService.findAllTemas();

        TemaListResource res = new TemaListResourceAsm().toResource(list);
        return new ResponseEntity<TemaListResource>(res, HttpStatus.OK);
    }
    
    @RequestMapping( value="/{temaId}", method = RequestMethod.GET)
    public ResponseEntity<TemaResource> getTema(@PathVariable Long temaId) {
        Tema tema = temaService.findTema(temaId);
        if(tema != null)
        {
            TemaResource res = new TemaResourceAsm().toResource(tema);
            return new ResponseEntity<TemaResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<TemaResource>(HttpStatus.NOT_FOUND);
        }
    }

}
