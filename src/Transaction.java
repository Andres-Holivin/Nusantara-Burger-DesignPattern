import java.util.Random;

abstract class Stages{
    protected UserTransaction userTransaction;
    public Stages(UserTransaction userTransaction) {
        this.userTransaction = userTransaction;
    }
    public abstract boolean ChangeStages();
}
class NoTransaction extends Stages{
    public NoTransaction(UserTransaction UserTransaction) {
        super(UserTransaction);
        System.out.println("No Data in this stages");
    }
    @Override
    public boolean ChangeStages() {userTransaction.setState(new PaymentInput(userTransaction)); return true;}
}
class PaymentInput extends Stages{
    public PaymentInput(UserTransaction UserTransaction) {
        super(UserTransaction);
        System.out.println("Show payment method");
    }
    @Override
    public boolean ChangeStages() {userTransaction.setState(new PaymentValidation(userTransaction)); return true;}
}
class PaymentValidation extends Stages{
    public PaymentValidation(UserTransaction UserTransaction) {
        super(UserTransaction);
        System.out.println("Your payment on validation");
    }
    @Override
    public boolean ChangeStages() {userTransaction.setState(new OrderConfirmation(userTransaction));return true;}
}
class OrderConfirmation extends Stages{
    public OrderConfirmation(UserTransaction UserTransaction) {
        super(UserTransaction);
        System.out.println("Your order already confirm");
    }
    @Override
    public boolean ChangeStages() {userTransaction.setState(new PaymentStart(userTransaction));return true;}
}
class PaymentStart extends Stages{
    public PaymentStart(UserTransaction UserTransaction) {
        super(UserTransaction);
        System.out.println("Your payment on progress");
    }
    @Override
    public boolean ChangeStages() {userTransaction.setState(new PaymentStatus(userTransaction));return true;}
}
class PaymentStatus extends Stages{
    public PaymentStatus(UserTransaction UserTransaction) {super(UserTransaction);}
    @Override
    public boolean ChangeStages() {
        System.out.println("Your payment success");
        return false;
    }
}
class MainTransaction {
    public static void main(String[] args) {
        UserTransaction UserTransaction= new UserTransaction(new Random().nextInt(999),
                new User(1,"Alex","user"),
                new Order(1,null));
        do{
            boolean cek=UserTransaction.getState().ChangeStages();
            if(!cek)break;
        }while (true);
    }
}
