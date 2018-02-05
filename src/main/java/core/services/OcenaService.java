package core.services;

import core.entites.Account;
import core.entites.Komentar;
import core.entites.Ocena;
import core.entites.Tema;
import core.services.util.OcenaList;

public interface OcenaService {
    public OcenaList findAllOcenas();
    public Ocena findOcena(Long id);
    public OcenaList findOcenaByAccount(Account account);
    public OcenaList findOcenaByKomentar(Komentar komentar);
    public OcenaList findOcenaByTema(Tema tema);
    public Ocena createOcena(Ocena data);
}
