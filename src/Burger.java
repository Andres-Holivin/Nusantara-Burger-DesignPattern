class BurgerComplementary extends Burger{
    public String topping;
    public String cookingMethod;
    public String sauce;
    public BurgerComplementary(Burger burger) {
        super(burger.id, burger.name);
    }
    public void setTopping(String topping) {this.topping = topping;}
    public void setCookingMethod(String cookingMethod) {this.cookingMethod = cookingMethod;}
    public void setSauce(String sauce) {this.sauce = sauce;}

    @Override
    public String toString() {
        return "BurgerComplementary{" +
                "topping='" + topping + '\'' +
                ", cookingMethod='" + cookingMethod + '\'' +
                ", sauce='" + sauce + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
class Main{
    public static void main(String[] args) {
        Burger burger=new Burger(1,"Burger Whopper");
        BurgerComplementary bc=new BurgerComplementary(burger);
        bc.setCookingMethod("kering");
        bc.setTopping("keju");
        bc.setSauce("tomat");
        System.out.println(bc.toString());
    }
}



