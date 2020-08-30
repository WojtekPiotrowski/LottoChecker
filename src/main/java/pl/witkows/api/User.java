package pl.witkows.api;

public class User {
    String fistName;
    String lastName;
    int age;
    float height;
    float weight;
    String street;
    String city;
    String postCode;
    int homeNmber;
    String phone;

    private User(String fistName, String lastName, int age, float height, float weight, String street, String city, String postCode, int homeNmber, String phone) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.street = street;
        this.city = city;
        this.postCode = postCode;
        this.homeNmber = homeNmber;
        this.phone = phone;
    }

    public static class Builder {
        String fistName;
        String lastName;
        int age;
        float height;
        float weight;
        String street = "Warszawa";
        String city;
        String postCode;
        int homeNmber;
        String phone;

        public Builder setFistName(String fistName) {
            this.fistName = fistName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setHeight(float height) {
            this.height = height;
            return this;
        }

        public Builder setWeight(float weight) {
            this.weight = weight;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setPostCode(String postCode) {
            this.postCode = postCode;
            return this;
        }

        public Builder setHomeNmber(int homeNmber) {
            this.homeNmber = homeNmber;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public User build() {
            return new User(fistName, lastName, age, height, weight, street, city, postCode, homeNmber, phone);
        }
    }
}
