package core.repositories;

import core.entites.Account;
import core.entites.Podforum;
import core.entites.Zalba;

import java.util.List;

public interface ZalbaRepo {
    public List<Zalba> findAllZalbas();
    public Zalba findZalba(Long id);
    public List<Zalba> findPraviloByModerator(Account account);
    public Zalba createZalba(Zalba data);
}
