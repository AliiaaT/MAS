import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    final static String extentFilePath = "/home/aliia/Desktop/MP1_EN_TemirbekKyzy_s21366/src/data";   // TODO update the file name

    public static void main(String[] args) {

//        Animal l1 = new Lion(LocalDate.of(2005,2,13),30,"male");
//        System.out.println(l1.getAge());

        //test lion extent
        Animal lion1 = new Lion(LocalDate.of(2005, 2, 13), 30, "male");
        Animal lion2 = new Lion(LocalDate.of(2010, 2, 13), 60, "female");
        Animal lion3 = new Lion(LocalDate.of(2011, 2, 13), 60, "female");
        Lion.showExtent();
        // example create zoo multivalue
//        List<Animal> animals = new ArrayList<>();
//        animals.add(lion1);
//        animals.add(lion2);
//        animals.add(lion3);
//        Zoo zoo = new Zoo("Adres1", animals);


        // write/read to/from file created

        try {
            // Serialize extent to the file
            var out = new ObjectOutputStream(new FileOutputStream(extentFilePath));
            System.out.println("Serialized to file");
            Lion.writeExtent(out);
            // Write any other extents
            out.close();


            // Desirialize extent from the file
            var in = new ObjectInputStream(new FileInputStream(extentFilePath));
            System.out.println("Desirialized from file");

            Lion.readExtent(in);
            for (Animal animal: Lion.getExtent()) {
                System.out.println(animal);
            }
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}