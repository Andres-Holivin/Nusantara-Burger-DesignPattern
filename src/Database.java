import java.util.Vector;

public class Database {
    public Vector<Burger> burgers;
    public Database(Vector<Burger> burgers) {
        this.burgers = burgers;
        System.out.println("init database");
    }
    public Vector<Burger> getAllBurgers(){
        for (Burger b:burgers) {
            System.out.println(b.toString());
        }
        return burgers;
    }
}
class DatabaseProxy{
    private Vector<Burger> burgers;
    private Database database=null;
    public DatabaseProxy(Vector<Burger> burgers) {this.burgers = burgers;}
    public Vector<Burger> getAllBurger(){
        if(database==null){
            database=new Database(burgers);
        }
        return database.getAllBurgers();
    }
}
class MainDatabase{
    public static void main(String[] args) {
        Vector<Burger> burgers=new Vector<>();
        burgers.add(new Burger(1,"chicken"));
        burgers.add(new Burger(2,"beef"));
        DatabaseProxy burgerDb1=new DatabaseProxy(burgers);
        DatabaseProxy burgerDb2=new DatabaseProxy(burgers);
        burgerDb1.getAllBurger();
        burgerDb2.getAllBurger();
    }
}