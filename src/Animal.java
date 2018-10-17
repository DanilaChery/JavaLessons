/**
 * Created by Валентин on 16.10.2018.
 */
public abstract class Animal {
     double maxSwim;
     double maxRun;
     double maxJump;


     Animal(double maxSwim,double maxRun,double maxJump){
         this.maxJump = maxJump;
         this.maxRun = maxRun;
         this.maxSwim = maxSwim;
     }
    public void jump(double distance){
        if (distance > this.maxJump){
            System.out.println( "jump:false");
        }else {
        System.out.println( "jump:true");}
    }
    public void run(double distance){

        if (distance > this.maxRun){
            System.out.println("run:false");

        }else {
        System.out.println("run:true");}
    }
    public void swim(double distance){
        if (distance > this.maxSwim){
            System.out.println( "swim:false");

        }else {
        System.out.println("swim:true");}
    }
}
