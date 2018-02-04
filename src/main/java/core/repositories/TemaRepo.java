package core.repositories;

import core.entites.Account;
import core.entites.Podforum;
import core.entites.Tema;

import java.util.List;

public interface TemaRepo {
    public List<Tema> findAllTemas();
    public Tema findTema(Long id);
    public List<Tema> findTemaByAutor(Account account);
    public List<Tema> findTemaByPodforum(Podforum podforum);
    public Tema createTema(Tema data);
}
