package rest.mvc;


import core.services.AccountService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.*;


@Controller

@ContextConfiguration("classpath:spring/business-config.xml")
@RequestMapping("/home")
public class IndexController {

    private AccountService accountService;

    @Autowired
    public IndexController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String test( ) {
        return "view";
    }



}
