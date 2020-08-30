
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
    private String numLosowania;
    @SerializedName("data_losowania")
    @Expose
    private LocalDateTime dataLosowania;
    @SerializedName("superszansa_id")
    @Expose
    private Object superszansaId;

    public String getNumerki() {
        return numerki;
    }

    public void setNumerki(String numerki) {
        this.numerki = numerki;
    }

    public String getNumLosowania() {
        return numLosowania;
    }

    public void setNumLosowania(String numLosowania) {
        this.numLosowania = numLosowania;
    }

    public LocalDateTime getDataLosowania() {
        return dataLosowania;
    }

    public void setDataLosowania(LocalDateTime dataLosowania) {
        this.dataLosowania = dataLosowania;
    }

    public Object getSuperszansaId() {
        return superszansaId;
    }

    public void setSuperszansaId(Object superszansaId) {
        this.superszansaId = superszansaId;
    }
}
