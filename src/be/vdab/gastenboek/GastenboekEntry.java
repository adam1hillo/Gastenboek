package be.vdab.gastenboek;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class GastenboekEntry implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private final LocalDateTime datum;
    private String schrijver;
    private String boodschap;


    public GastenboekEntry(String schrijver, String boodschap) {
        datum = LocalDateTime.now();
        setSchrijver(schrijver);
        setBoodschap(boodschap);
    }

    public String getSchrijver() {
        return schrijver;
    }

    private final void setSchrijver(String schrijver) {
        if (schrijver.isBlank()) {
            throw new IllegalArgumentException("schrijver moet ingevuld zijn");
        }
        this.schrijver = schrijver;
    }

    public String getBoodschap() {
        return boodschap;
    }

    private final void setBoodschap(String boodschap) {
        if (boodschap.isBlank()) {
            throw new IllegalArgumentException("Boodschap mag niet leeg zijn");
        }
        this.boodschap = boodschap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LocalDateTime date)) {
            return false;
        }
        return datum.equals(date);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(datum);
    }

    @Override
    public String toString() {
        return schrijver + "; " + datum.format(FORMATTER) + "; " + boodschap;
    }
}
