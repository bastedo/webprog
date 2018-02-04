package core.services;

import core.entites.Account;
import core.entites.Poruka;
import core.services.util.PorukaList;

import java.util.List;

public interface PorukaService {
    public PorukaList findAllPorukas();
    public Poruka findPoruka(Long id);
    public PorukaList findPorukaByPosiljalac(Account account);
    public PorukaList findPorukaByPrimalac(Account account);
    public Poruka createPoruka(Poruka data);
}
