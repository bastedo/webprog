package rest.mvc;

import core.entites.Account;
import core.entites.Komentar;
import core.entites.Podforum;
import core.services.AccountService;
import core.services.KomentarService;
import core.services.PodforumService;
import core.services.util.KomentarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rest.resources.KomentarResource;
import rest.resources.asm.KomentarResourceAsm;
import rest.resources.asm.list.KomentarListResourceAsm;
import rest.resources.list.KomentarListResource;

@Controller
@RequestMapping("/rest/komentars")
public class KomentarController {

    private KomentarService komentarService;
    private AccountService accountService;
    private PodforumService podforumService;

    @Autowired
    public KomentarController(KomentarService komentarService, AccountService accountService) {
        this.komentarService = komentarService ;
        this.accountService = accountService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<KomentarListResource> findAllKomentars() {
        KomentarList list = komentarService.findAllKomentars();

        KomentarListResource res = new KomentarListResourceAsm().toResource(list);
        return new ResponseEntity<KomentarListResource>(res, HttpStatus.OK);
    }

    @RequestMapping( value="/{komentarId}", method = RequestMethod.GET)
    public ResponseEntity<KomentarResource> getKomentar(@PathVariable Long komentarId) {
        Komentar komentar = komentarService.findKomentar(komentarId);
        if(komentar != null)
        {
            KomentarResource res = new KomentarResourceAsm().toResource(komentar);
            return new ResponseEntity<KomentarResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<KomentarResource>(HttpStatus.NOT_FOUND);
        }
    }


}
