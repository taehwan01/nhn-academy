public class Playground {
    public static void main(String[] args) {
        Marine marine1 = new Marine();
        Marine marine2 = new Marine();

        marine1.attack(marine2);
        marine2.attack(marine1);

        // for( u : units){
        // if(u instanceof Attackable)
        // ((Attackable)u).attack(marine1);
        // }
    }
}
