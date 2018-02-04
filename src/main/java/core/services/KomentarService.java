package core.services;

import core.entites.Account;
import core.entites.Komentar;
import core.entites.Podforum;
import core.entites.Tema;
import core.services.util.KomentarList;

public interface KomentarService {
    public KomentarList findAllKomentars();
    public Komentar findKomentar(Long id);
    public KomentarList findKomentarByAutor(Account account);
    public KomentarList findKomentarByPodforum(Podforum podforum);
    public KomentarList findKomentarByRKomentar(Komentar komentar);
    public KomentarList findKomentarByTema(Tema tema);
    public Komentar createKomentar(Komentar data);
}
