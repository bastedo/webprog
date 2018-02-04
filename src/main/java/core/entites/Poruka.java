package core.entites;

import javax.persistence.*;

@Entity
@Table(name = "poruka")
public class Poruka {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "sadrzaj_poruke")
    private String sadrzajPoruke;

    @Column(name = "komentar_izmenjen")
    private Boolean komentarIzmenjen;

    @ManyToOne
    private Account primalac;

    @ManyToOne
    private Account posiljalac;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSadrzajPoruke() {
        return sadrzajPoruke;
    }

    public void setSadrzajPoruke(String sadrzajPoruke) {
        this.sadrzajPoruke = sadrzajPoruke;
    }

    public Boolean getKomentarIzmenjen() {
        return komentarIzmenjen;
    }

    public void setKomentarIzmenjen(Boolean komentarIzmenjen) {
        this.komentarIzmenjen = komentarIzmenjen;
    }

    public Account getPrimalac() {
        return primalac;
    }

    public void setPrimalac(Account primalac) {
        this.primalac = primalac;
    }

    public Account getPosiljalac() {
        return posiljalac;
    }

    public void setPosiljalac(Account posiljalac) {
        this.posiljalac = posiljalac;
    }
}
