package l_javaPatterns;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String news);
}

interface Actions {
    void subscribe(Observer o);

    void unsubscribe(Observer o);

    void nofifySubscribers(String news);
}

class Subscriber implements Observer {

    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " has received news :: " + news);
    }

}

public class VTube implements Actions{

    private List<Observer> observerList = new ArrayList<>();

    @Override
    public void subscribe(Observer o) {
        observerList.add(o);
    }

    @Override
    public void unsubscribe(Observer o) {
        observerList.remove(o);
    }

    @Override
    public void nofifySubscribers(String news) {
        for (Observer obs : observerList){
            obs.update(news);
        }
    }
}