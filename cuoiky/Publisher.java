import java.util.LinkedList;
import java.util.List;

public class Publisher<Subcriber> {

    private List<Subcriber> subcribers = new LinkedList<>();
    public void subcribe(Subcriber subcriber){
       subcribers.add(subcriber);
    }

    public void unsubcribe(Subcriber subcriber){
       subcribers.remove(subcriber);
    }

    public void notifysubcribers(){
        for (Subcriber subcriber : subcribers){
            subcriber.update(SachDAO);
        }
    }
}