import java.util.Random;
interface IChatRoom{
    void sendMessage(String msg,ChatUser user);
    void addUser(ChatUser user,ChatUser agent);
}
public class ChatRoom implements IChatRoom{
    public Integer id;
    public ChatUser agent,user;
    public Chat chat;
    public ChatItem item;
    public ChatRoom() {id= new Random().nextInt(999);}
    @Override
    public void sendMessage(String msg,ChatUser user) {
        if(this.agent.id==user.id){
            user.receive(msg);
        }else if(this.user.id==user.id){
            agent.receive(msg);
        }else System.out.println("no id");
        item=new ChatItem(user.role,msg);
        chat.addItems(item);
        System.out.println(chat);
    }
    @Override
    public void addUser(ChatUser user,ChatUser agent) {
        this.agent=agent;
        this.user=user;
        chat=new Chat(id, user.id, agent.id);
    }
}
class ChatUser extends User{
    public IChatRoom mediator;
    public ChatUser(IChatRoom room, User user) {
        super(user.id, user.name,user.role);
        this.mediator=room;
    }
    public void send(String msg) {
        System.out.println(this.name+" send Msg: "+msg);
        mediator.sendMessage(msg,this);
    }
    public void receive(String msg) {
        System.out.println(this.name+" received message :"+msg);
    }
}
class MainChat{
    public static void main(String[] args) {
        IChatRoom chatroom = new ChatRoom();
        User user=new User(1,"Alex","user");
        User agent=new User(2,"Brian","agent");
        ChatUser chatUser = new ChatUser(chatroom,user);
        ChatUser chatAgent = new ChatUser(chatroom,agent);
        chatroom.addUser(chatUser,chatAgent);
        chatUser.send("Hello brian");
        chatAgent.send("Hey Alex");
        chatUser.send("Hello brian");
    }
}
