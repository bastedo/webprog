package core.services;

import core.entites.Account;
import core.entites.Podforum;
import core.entites.Tema;
import core.services.util.TemaList;

public interface TemaService {
    public TemaList findAllTemas();
    public Tema findTema(Long id);
    public TemaList findTemaByAutor(Account account);
    public TemaList findTemaByPodforum(Podforum podforum);
    public Tema createTema(Tema data);
}
