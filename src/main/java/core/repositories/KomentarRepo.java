package core.repositories;

import core.entites.Account;
import core.entites.Komentar;
import core.entites.Podforum;
import core.entites.Tema;

import java.util.List;

public interface KomentarRepo {
    public List<Komentar> findAllKomentars();
    public Komentar findKomentar(Long id);
    public List<Komentar> findKomentarByAutor(Account account);
    public List<Komentar> findKomentarByPodforum(Podforum podforum);
    public List<Komentar> findKomentarByRKomentar(Komentar komentar);
    public Komentar createKomentar(Komentar data);

    public List<Komentar> findKomentarByTema(Tema tema);
}
