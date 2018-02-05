package core.repositories;

import core.entites.Account;
import core.entites.Komentar;
import core.entites.Ocena;
import core.entites.Tema;

import java.util.List;

public interface OcenaRepo {
    public List<Ocena> findAllOcenas();
    public Ocena findOcena(Long id);
    public List<Ocena> findOcenaByAccount(Account account);
    public List<Ocena> findOcenaByKomentar(Komentar komentar);
    public List<Ocena> findOcenaByTema(Tema tema);
    public Ocena createOcena(Ocena data);
    public Ocena findOcenaByOcena(Ocena data);
}