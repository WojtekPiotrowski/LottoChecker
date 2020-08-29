package pl.piotrowski;

import com.google.gson.Gson;

public class Main {
        public static void main(String[] args) {
            Gson gson = new Gson();
            String json = "{\"imie\": \"Jacek\",\"wiek\": 10, \"adres\": {\"ulica\": \"xxxx\",\"numerDomu\": 1 }, \"dzieci\": null,\"czyMaDzieci\": false,\"tagi\": [\"developer\", \"cos\", \"cos2\"]}";
            Uzytkownik jacek = gson.fromJson(json, Uzytkownik.class);
            System.out.println(jacek.imie);
            System.out.println(jacek.wiek);
            System.out.println(jacek.adres.ulica);
        }
}
