package core.entites;

import core.enumeration.VrstaOcene;

import javax.persistence.*;

@Entity
@Table(name = "ocena")
public class Ocena {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Account account;
    @ManyToOne
    private Komentar komentar ;
    @ManyToOne
    private Tema tema ;

    @Enumerated(EnumType.STRING)
    @Column(name = "vrsta_ocene")
    private VrstaOcene vrstaOcene ;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Komentar getKomentar() {
        return komentar;
    }

    public void setKomentar(Komentar komentar) {
        this.komentar = komentar;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public VrstaOcene getVrstaOcene() {
        return vrstaOcene;
    }

    public void setVrstaOcene(VrstaOcene vrstaOcene) {
        this.vrstaOcene = vrstaOcene;
    }
}
