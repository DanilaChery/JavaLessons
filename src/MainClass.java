public class MainClass {
    public static void main(String[] args) {
        Cat[] cats = new Cat[5];
        cats[0] = new Cat("FoodEater",140);
        cats[1] = new Cat("FoodEater",20);
        cats[2] = new Cat("FoodEater",50);
        cats[3] = new Cat("FoodEater",5);
        cats[4] = new Cat("FoodEater",10);

        Plate plate = new Plate(140);
        plate.info();
        cats[0].eat(plate);
        plate.addFood(130);
        cats[1].eat(plate);
        cats[2].eat(plate);
        cats[3].eat(plate);
        cats[4].eat(plate);

        plate.info();
    }

    public static class Plate {
        private int food;

        public Plate(int food) {
            this.food = food;
        }

        public boolean deleteFood(int n) {
            if(food-n < 0){
                return false;
            }else {
                food = food - n;
                return true;
            }
        }
        public void addFood(int n){
            food = food + n;
        }
        public void info() {
            System.out.println("plate: " + food);
        }
    }

    public static class Cat {
        private String name;
        private int appetite;
        private boolean fullness = false;
        public Cat(String name, int appetite) {
            this.name = name;
            this.appetite = appetite;
        }

        public void eat(Plate p) {
            if (p.deleteFood(appetite)){
                fullness = true;
            }



        }
    }
}
