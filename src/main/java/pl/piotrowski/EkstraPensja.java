
package pl.piotrowski;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EkstraPensja {

    @SerializedName("extra")
    @Expose
    private String extra;
    @SerializedName("numerki")
    @Expose
    private String numerki;
    @SerializedName("num_losowania")
    @Expose
    private String numLosowania;
    @SerializedName("data_losowania")
    @Expose
    private String dataLosowania;
    @SerializedName("superszansa_id")
    @Expose
    private Object superszansaId;

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

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

    public String getDataLosowania() {
        return dataLosowania;
    }

    public void setDataLosowania(String dataLosowania) {
        this.dataLosowania = dataLosowania;
    }

    public Object getSuperszansaId() {
        return superszansaId;
    }

    public void setSuperszansaId(Object superszansaId) {
        this.superszansaId = superszansaId;
    }

}
