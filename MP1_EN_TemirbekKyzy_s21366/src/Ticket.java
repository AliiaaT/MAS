import java.time.LocalDate;
import java.util.Optional;

public class Ticket {

    //mandatory attr. example
    private Integer id;
    //example of complex attribute, could be null
    private LocalDate date;

    //example of Optional attribute
    private Optional<Integer> discount = Optional.empty();

    private int price;

    public Ticket(Integer id, LocalDate date, Optional<Integer> discount, int price) {
        if(id==null) {
            throw new IllegalArgumentException();
        } this.id=id;
        this.date = date;
        this.discount = discount;
        this.price = price;
    }

    //method overloading
    public Ticket(Integer id, LocalDate date, int price) {
        if(id==null) {
            throw new IllegalArgumentException();
        } this.id=id;
        this.date = date;
        this.price = price;
    }

    //optional attribute implementation
    public int getFinalPrice(){
        int finalPrice  = getPrice()-getDiscount().orElse(0);
        if(finalPrice<0){
            return 0;
        }else {
            return finalPrice;
        }
    }
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Optional<Integer> getDiscount() {
        return discount;
    }

    public void setDiscount(Optional<Integer> discount) {
        this.discount = discount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if(id==null) {
            throw new IllegalArgumentException();
        } this.id=id;
    }
}
