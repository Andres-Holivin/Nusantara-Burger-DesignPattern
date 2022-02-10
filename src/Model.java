import java.util.List;
import java.util.Vector;

class User{
    public Integer id;
    public String name;
    public String role;
    public User(Integer id, String name,String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }
}
class Burger{
    public int id;
    public String name;
    public Burger(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Burger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
class Chat{
    public int roomId;
    public Integer userId;
    public Integer agentId;
    public Vector<ChatItem> items;
    public Chat(int roomId, Integer userId, Integer agentId) {
        this.roomId = roomId;
        this.userId = userId;
        this.agentId = agentId;
        items=new Vector<>();
    }
    public void addItems(ChatItem items) {
        this.items.add(items);
    }
}
class ChatItem{
    public String role;
    public String text;
    public ChatItem(String role, String text) {
        this.role = role;
        this.text = text;
    }
}
class Order{
    public Integer id;
    public List<Burger> burgers;
    public Order(Integer id, List<Burger> burgers) {
        this.id = id;
        this.burgers = burgers;
    }
    public void addBurger(Burger burger){
        burgers.add(burger);
    }
}
class UserTransaction{
    public Integer id;
    public User user;
    private Stages stages;
    public Order order;

    public UserTransaction(Integer id, User user,Order order) {
        this.order=order;
        this.id = id;
        this.user = user;
        this.stages=new NoTransaction(this);
    }
    public Stages getState() {return stages;}
    public void setState(Stages state) {this.stages = state;}
}