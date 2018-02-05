package rest.mvc;

import core.entites.Account;
import core.entites.Komentar;
import core.entites.Ocena;
import core.entites.Podforum;
import core.enumeration.VrstaOcene;
import core.services.AccountService;
import core.services.KomentarService;
import core.services.OcenaService;
import core.services.PodforumService;
import core.services.util.OcenaList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rest.resources.OcenaResource;
import rest.resources.asm.OcenaResourceAsm;
import rest.resources.asm.list.OcenaListResourceAsm;
import rest.resources.list.OcenaListResource;

@Controller
@RequestMapping("/rest/ocenas")
public class OcenaController {

    private OcenaService ocenaService;
    private AccountService accountService;
    private PodforumService podforumService;
    private KomentarService komentarService;
    @Autowired
    public OcenaController(OcenaService ocenaService, AccountService accountService) {
        this.ocenaService = ocenaService ;
        this.accountService = accountService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<OcenaListResource> findAllOcenas() {
        OcenaList list = ocenaService.findAllOcenas();

        OcenaListResource res = new OcenaListResourceAsm().toResource(list);
        return new ResponseEntity<OcenaListResource>(res, HttpStatus.OK);
    }
    @RequestMapping(value = "/oceni",method = RequestMethod.GET)
    public ResponseEntity<OcenaResource> oceni() {
        Account account = accountService.findAccount(1L);
        Komentar komentar= komentarService.findKomentar(1L);
        Ocena ocena = new Ocena();
        ocena.setVrstaOcene(VrstaOcene.POZITIVNA);
        ocena.setAccount(account);
        ocena.setKomentar(komentar);
        if(account != null)
        {
            OcenaResource res = new OcenaResourceAsm().toResource(ocena);

            return new ResponseEntity<OcenaResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<OcenaResource>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping( value="/{ocenaId}", method = RequestMethod.GET)
    public ResponseEntity<OcenaResource> getOcena(@PathVariable Long ocenaId) {
        Ocena ocena = ocenaService.findOcena(ocenaId);
        if(ocena != null)
        {
            OcenaResource res = new OcenaResourceAsm().toResource(ocena);
            return new ResponseEntity<OcenaResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<OcenaResource>(HttpStatus.NOT_FOUND);
        }
    }


}