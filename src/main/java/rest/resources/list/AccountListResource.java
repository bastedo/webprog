package rest.resources.list;

import org.springframework.hateoas.ResourceSupport;
import rest.resources.AccountResource;

import java.util.ArrayList;
import java.util.List;

public class AccountListResource extends ResourceSupport {
    private List<AccountResource> accounts = new ArrayList<AccountResource>();

    public List<AccountResource> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountResource> accounts) {
        this.accounts = accounts;
    }
}
