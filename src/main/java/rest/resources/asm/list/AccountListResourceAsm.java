package rest.resources.asm.list;

import core.services.util.AccountList;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import rest.mvc.AccountController;
import rest.resources.asm.AccountResourceAsm;
import rest.resources.list.AccountListResource;
import rest.resources.AccountResource;

import java.util.List;

public class AccountListResourceAsm extends ResourceAssemblerSupport<AccountList, AccountListResource> {


    public AccountListResourceAsm() {
        super(AccountController.class, AccountListResource.class);
    }

    @Override
    public AccountListResource toResource(AccountList accountList) {
        List<AccountResource> resList = new AccountResourceAsm().toResources(accountList.getAccounts());
        AccountListResource finalRes = new AccountListResource();
        finalRes.setAccounts(resList);
        return finalRes;
    }
}
