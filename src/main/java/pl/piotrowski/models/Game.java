
package pl.piotrowski.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

public class Game {

    @SerializedName("numerki")
    @Expose
    private String numerki;
    @SerializedName("num_losowania")
    @Expose
    private long numLosowania;
    @SerializedName("data_losowania")
    @Expose
    private LocalDateTime dataLosowania;
    @SerializedName("superszansa_id")
    @Expose
    private double superszansaId;

    public String getNumerki() {
        return numerki;
    }

    public void setNumerki(String numerki) {
        this.numerki = numerki;
    }

    public long getNumLosowania() {
        return numLosowania;
    }

    public void setNumLosowania(long numLosowania) {
        this.numLosowania = numLosowania;
    }

    public LocalDateTime getDataLosowania() {
        return dataLosowania;
    }

    public void setDataLosowania(String dataLosowania) {
        this.dataLosowania = LocalDateTime.parse(dataLosowania);
    }

    public double getSuperszansaId() {
        return superszansaId;
    }

    public void setSuperszansaId(double superszansaId) {
        this.superszansaId = superszansaId;
    }

}
