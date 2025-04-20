package l_javaInterview;

public class Singleton {
    private Singleton() {
        System.out.println("javaInterview.Singleton instance created."); // To see when it's created
    }

    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }

}

