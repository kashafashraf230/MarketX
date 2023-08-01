package marketX;

public class Customer {

        private String name;
        private int age;
        private String city;
        private Gender gender;
        private double purchaseAmount;

        public Customer(String name, int age, String city, Gender gender, double purchaseAmount) {
            this.name = name;
            this.age = age;
            this.city = city;
            this.gender = gender;
            this.purchaseAmount = purchaseAmount;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }
}
