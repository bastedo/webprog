package core.services;


import core.entites.Account;
import core.services.util.AccountList;
import org.springframework.stereotype.Service;


public interface AccountService {
    public Account findAccount(Long id);
    public Account createAccount(Account data);
    // TODO public Blog createBlog(Long accountId, Blog data);
   // TODO public BlogList findBlogsByAccount(Long accountId);
    public AccountList findAllAccounts();
    public Account findByAccountName(String name);
}
