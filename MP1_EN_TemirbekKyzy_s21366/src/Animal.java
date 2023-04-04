import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public abstract class  Animal implements Serializable {

    //example of derived attribute
    private LocalDate birthDate;
    private int weight;
    private String gender;


    public Animal(LocalDate birthDate, int weight, String gender) {
        this.birthDate = birthDate;
        this.weight = weight;
        this.gender = gender;
    }

    //derived attribute implementation
    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }


    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    //method overriding
    @Override
    public String toString() {
        return "Animal{" +
                "birthDate=" + birthDate +
                ", weight=" + weight +
                ", gender='" + gender + '\'' +
                '}';
    }
}
