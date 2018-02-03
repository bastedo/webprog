package core.services.impl;

import core.entites.Account;
import core.repositories.AccountRepo;
import core.services.AccountService;
import core.services.exceptions.AccountExistsException;
import core.services.util.AccountList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional


public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepo;



    @Override
    public Account findAccount(Long id) {
        return accountRepo.findAccount(id);
    }

    @Override
    public Account createAccount(Account data) {
        Account account = accountRepo.findAccountByName(data.getKorisnickoIme());
        if(account != null)
        {
            throw new AccountExistsException();
        }
        return accountRepo.createAccount(data);
    }




    @Override
    public AccountList findAllAccounts() {
        return new AccountList(accountRepo.findAllAccounts());
    }

    @Override
    public Account findByAccountName(String name) {
        return accountRepo.findAccountByName(name);
    }
}