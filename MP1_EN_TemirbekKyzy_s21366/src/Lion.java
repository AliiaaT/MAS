import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Lion extends Animal {
    public Lion(LocalDate birthDate, int weight, String gender) {
        super(birthDate, weight, gender);
        addLion(this);
    }

    private static List<Lion> extent = new ArrayList<>();

    //add lion to the extent
    private static void addLion(Lion lion){
        extent.add(lion);
    }

    private static void removeLion(Lion lion){
        extent.remove(lion);
    }

    //class method
    public static void showExtent(){
        System.out.println("Extent of the class: " + Lion.class.getName());
        for(Lion lion: extent){
            System.out.println(lion);
        }
    }

    public static List<Lion> getExtent() {
        return Collections.unmodifiableList(extent);
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }
    public static void readExtent(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        extent = (ArrayList<Lion>) stream.readObject();
    }


}
