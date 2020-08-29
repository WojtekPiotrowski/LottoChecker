
package pl.witkows.models;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Games {

    @SerializedName("Lotto")
    @Expose
    private Lotto lotto;
    @SerializedName("LottoPlus")
    @Expose
    private LottoPlus lottoPlus;
    @SerializedName("Mini")
    @Expose
    private Mini mini;
    @SerializedName("Joker")
    @Expose
    private Joker joker;
    @SerializedName("Kaskada1")
    @Expose
    private Kaskada1 kaskada1;
    @SerializedName("Superszansa")
    @Expose
    private List<Superszansa> superszansa = new ArrayList<Superszansa>();
    @SerializedName("Kaskada2")
    @Expose
    private Kaskada2 kaskada2;
    @SerializedName("MM1")
    @Expose
    private MM1 mM1;
    @SerializedName("MM2")
    @Expose
    private MM2 mM2;
    @SerializedName("EkstraPensja")
    @Expose
    private EkstraPensja ekstraPensja;
    @SerializedName("SS1")
    @Expose
    private SS1 sS1;
    @SerializedName("SS2")
    @Expose
    private SS2 sS2;
    @SerializedName("EJ")
    @Expose
    private EJ eJ;

    public Lotto getLotto() {
        return lotto;
    }

    public void setLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public LottoPlus getLottoPlus() {
        return lottoPlus;
    }

    public void setLottoPlus(LottoPlus lottoPlus) {
        this.lottoPlus = lottoPlus;
    }

    public Mini getMini() {
        return mini;
    }

    public void setMini(Mini mini) {
        this.mini = mini;
    }

    public Joker getJoker() {
        return joker;
    }

    public void setJoker(Joker joker) {
        this.joker = joker;
    }

    public Kaskada1 getKaskada1() {
        return kaskada1;
    }

    public void setKaskada1(Kaskada1 kaskada1) {
        this.kaskada1 = kaskada1;
    }

    public List<Superszansa> getSuperszansa() {
        return superszansa;
    }

    public void setSuperszansa(List<Superszansa> superszansa) {
        this.superszansa = superszansa;
    }

    public Kaskada2 getKaskada2() {
        return kaskada2;
    }

    public void setKaskada2(Kaskada2 kaskada2) {
        this.kaskada2 = kaskada2;
    }

    public MM1 getMM1() {
        return mM1;
    }

    public void setMM1(MM1 mM1) {
        this.mM1 = mM1;
    }

    public MM2 getMM2() {
        return mM2;
    }

    public void setMM2(MM2 mM2) {
        this.mM2 = mM2;
    }

    public EkstraPensja getEkstraPensja() {
        return ekstraPensja;
    }

    public void setEkstraPensja(EkstraPensja ekstraPensja) {
        this.ekstraPensja = ekstraPensja;
    }

    public SS1 getSS1() {
        return sS1;
    }

    public void setSS1(SS1 sS1) {
        this.sS1 = sS1;
    }

    public SS2 getSS2() {
        return sS2;
    }

    public void setSS2(SS2 sS2) {
        this.sS2 = sS2;
    }

    public EJ getEJ() {
        return eJ;
    }

    public void setEJ(EJ eJ) {
        this.eJ = eJ;
    }

}
