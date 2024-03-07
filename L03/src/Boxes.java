public class Boxes {
    private static class Box{

        private Object obj;
        public Box(Object obj){this.obj = obj;}

        public Object getObj() {
            return obj;
        }

        public void setObj(Object obj) {
            this.obj = obj;
        }

        public void printInfo(){
            System.out.printf("Boxes (%s): %s", obj.getClass().getSimpleName(), obj.toString());
        }

    }
    public static void main(String[] args) {

        Box b1 = new Box(20);
        Box b2 = new Box("30");
        if(b1.getObj() instanceof Integer && b2.getObj() instanceof Integer){
            int sum = (Integer) b1.getObj() + (Integer) b2.getObj();
            System.out.println("sum = " + sum);
        } else{
            System.out.println("Arguments differ in type!");
        }

        Box b3 = new Box("Hello, ");
        Box b4 = new Box("World!");
        System.out.println((String)b3.getObj() + (String)b4.getObj());
    }
}