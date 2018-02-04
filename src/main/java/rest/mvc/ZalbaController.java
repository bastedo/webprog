package rest.mvc;

import core.entites.Zalba;
import core.services.AccountService;
import core.services.ZalbaService;
import core.services.exceptions.ZalbaExistsException;
import core.services.util.ZalbaList;
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
import rest.resources.ZalbaResource;
import rest.resources.asm.ZalbaResourceAsm;
import rest.resources.asm.list.ZalbaListResourceAsm;
import rest.resources.list.ZalbaListResource;

import java.net.URI;

@Controller
@RequestMapping("/rest/zalbas")
public class ZalbaController {

    private ZalbaService zalbaService;
    private AccountService accountService;

    @Autowired
    public ZalbaController(ZalbaService zalbaService, AccountService accountService) {
        this.zalbaService = zalbaService ;
        this.accountService = accountService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ZalbaListResource> findAllZalbas() {
        ZalbaList list = zalbaService.findAllZalbas();

        ZalbaListResource res = new ZalbaListResourceAsm().toResource(list);
        return new ResponseEntity<ZalbaListResource>(res, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ZalbaResource> createZalba (@RequestBody ZalbaResource sentZalba) {
        try {
            Zalba createdPodforum = zalbaService.createZalba(sentZalba.toZalba());
            ZalbaResource res = new ZalbaResourceAsm().toResource(createdPodforum);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(res.getLink("self").getHref()));
            return new ResponseEntity<ZalbaResource>(res, headers, HttpStatus.CREATED);
        } catch(ZalbaExistsException exception) {
            throw new ConflictException(exception);
        }
    }


    @RequestMapping( value="/{zalbaId}", method = RequestMethod.GET)
    public ResponseEntity<ZalbaResource> getZalba(@PathVariable Long zalbaId) {
        Zalba zalba = zalbaService.findZalba(zalbaId);
        if(zalba != null)
        {
            ZalbaResource res = new ZalbaResourceAsm().toResource(zalba);
            return new ResponseEntity<ZalbaResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<ZalbaResource>(HttpStatus.NOT_FOUND);
        }
    }

}
