
package pl.witkows.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import pl.witkows.checkResult.NumberConverter;

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

    public String getNumLosowania() {
        return numLosowania;
    }

    public LocalDateTime getDataLosowania() {
        return dataLosowania;
    }

    public Object getSuperszansaId() {
        return superszansaId;
    }

    public int[] getSortedNumbers() {
        return NumberConverter.parseToIntTab(numerki);
    }
}
