public class Main {
    public static void main(String[] args) {
        VTube vTube = new VTube();
        Observer use1 = new Subscriber("Sudarshan");
        Observer use2 = new Subscriber("dhiraj");

        vTube.subscribe(use1);
        vTube.subscribe(use2);
        vTube.nofifySubscribers("java 23 launched");
        vTube.nofifySubscribers("opeAI has launched new model");
    }
}