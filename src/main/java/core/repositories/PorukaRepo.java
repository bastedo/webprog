package core.repositories;

import core.entites.Account;
import core.entites.Poruka;

import java.util.List;

public interface PorukaRepo {
    public List<Poruka> findAllPorukas();
    public Poruka findPoruka(Long id);
    public List<Poruka> findPorukaByPosiljalac(Account account);
    public List<Poruka> findPorukaByPrimalac(Account account);
    public Poruka createPoruka(Poruka data);
}