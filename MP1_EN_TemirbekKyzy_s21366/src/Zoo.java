import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Zoo {

    //class attribute with extent implementation in the same business class
    private static String name = "Warsaw Zoo";
    private String address;

    //example of multi-value attribute not mandatory
    private List<Animal> animals = new ArrayList<>();

    public Zoo(String address, List<Animal> animals) {
        this.address = address;
        if (animals.size() < 3) {
            throw new IllegalArgumentException();
        }
        for (Animal animal : animals) {
            if (animal == null) {
                throw new IllegalArgumentException();
            }
        }
        this.animals = animals;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Zoo.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public void addAnimal(Animal animal) {
        if(animal == null) {
            throw new IllegalArgumentException();
        }
        this.animals.add(animal);
    }

    public void removeAnimal(Animal animal) {
        if (this.animals.size() < 3) { //must have at least 3
            throw new IllegalArgumentException();
        }
        this.animals.remove(animal);
    }

    public List<Animal> getAnimals() {
        return Collections.unmodifiableList(animals);
    }


}
