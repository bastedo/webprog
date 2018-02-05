package rest.resources.asm;


import core.entites.Account;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import rest.mvc.AccountController;
import rest.resources.AccountResource;
import sun.misc.Resource;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import sun.misc.Resource;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

public class AccountResourceAsm extends ResourceAssemblerSupport<Account, AccountResource>{
    public AccountResourceAsm() {
        super(AccountController.class, AccountResource.class);
    }

    @Override
    public AccountResource toResource(Account account) {
        AccountResource res = new AccountResource();
        res.setIme(account.getIme());
        res.setKorisnickoIme(account.getKorisnickoIme());
        res.setDatumRegistracije(account.getDatumRegistracije());
        res.setLozinka(account.getLozinka());
        res.setPrezime(account.getPrezime());
        res.setUloga(account.getUloga());
        res.setEmail(account.getEmail());
        Link link = linkTo(methodOn(AccountController.class).getAccount(account.getId())).withSelfRel();
        res.add(link.withSelfRel());
        return res;
    }
}
