
package pl.witkows.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Games {
    @SerializedName("Lotto")
    @Expose
    private Game lotto;

    @SerializedName("LottoPlus")
    @Expose
    private Game lottoPlus;

    @SerializedName("Mini")
    @Expose
    private Game mini;

    @SerializedName("Superszansa")
    @Expose
    private List<Game> superszansa = new ArrayList<Game>();


    public Game getLotto() {
        return lotto;
    }

    public Game getLottoPlus() {
        return lottoPlus;
    }

    public Game getMini() {
        return mini;
    }

    public List<Game> getSuperszansa() {
        return superszansa;
    }
}
