package core.entites;

import core.enumeration.StatusZalbe;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "zalba")

public class Zalba{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "tekst_zalbe")
    private String tekstZalbe;

    @Column(name = "datum_zalbe")
    private LocalDate datumZalbe;

    @Enumerated(EnumType.STRING)
    @Column(name = "regulisana")
    private StatusZalbe regulisana;

    @ManyToOne
    private Account autor;

    @ManyToOne
    private Account odgovorniModerator;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTekstZalbe() {
        return tekstZalbe;
    }

    public void setTekstZalbe(String tekstZalbe) {
        this.tekstZalbe = tekstZalbe;
    }

    public LocalDate getDatumZalbe() {
        return datumZalbe;
    }

    public void setDatumZalbe(LocalDate datumZalbe) {
        this.datumZalbe = datumZalbe;
    }

    public StatusZalbe getRegulisana() {
        return regulisana;
    }

    public void setRegulisana(StatusZalbe regulisana) {
        this.regulisana = regulisana;
    }

    public Account getAutor() {
        return autor;
    }

    public void setAutor(Account autor) {
        this.autor = autor;
    }

    public Account getOdgovorniModerator() {
        return odgovorniModerator;
    }

    public void setOdgovorniModerator(Account odgovorniModerator) {
        this.odgovorniModerator = odgovorniModerator;
    }
}
