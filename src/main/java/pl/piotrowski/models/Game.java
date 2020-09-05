
package pl.piotrowski.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import pl.piotrowski.checkResult.NumberConverter;
import pl.piotrowski.checkResult.NumberValidationException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Game {

    @Id
    @Column(unique = true, nullable = false)
    @SerializedName("num_losowania")
    @Expose
    private String numLosowania;

    @SerializedName("numerki")
    @Expose
    private String numerki;

    @SerializedName("data_losowania")
    @Expose
    private LocalDateTime dataLosowania;

    @SerializedName("superszansa_id")
    @Expose
    private String superszansaId;


    public Game() {
    }

    public Game(String numLosowania, String numerki, LocalDateTime dataLosowania, String superszansaId) {
        this.numLosowania = numLosowania;
        this.numerki = numerki;
        this.dataLosowania = dataLosowania;
        this.superszansaId = superszansaId;
    }

    public String getNumerki() {
        return numerki;
    }

    public String getNumLosowania() {
        return numLosowania;
    }

    public LocalDateTime getDataLosowania() {
        return dataLosowania;
    }

    public String getSuperszansaId() {
        return superszansaId;
    }

    public int[] getSortedNumbers() throws NumberValidationException {
        return NumberConverter.parseToIntTab(numerki);
    }

    @Override
    public String toString() {
        return "Game{" +
                "numLosowania='" + numLosowania + '\'' +
                ", numerki='" + numerki + '\'' +
                ", dataLosowania=" + dataLosowania +
                ", superszansaId='" + superszansaId + '\'' +
                '}';
    }
}
