package core.services;

import core.entites.Account;
import core.entites.Zalba;
import core.services.util.ZalbaList;

public interface ZalbaService {
    public ZalbaList findAllZalbas();
    public Zalba findZalba(Long id);
    public ZalbaList findPraviloByModerator(Account account);
    public Zalba createZalba(Zalba data);
}
