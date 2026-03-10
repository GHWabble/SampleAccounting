package lab_5.service;

import lab_5.domain.CustodyEvent;

import java.util.*;

public class CustodyEventService {

    Set<CustodyEvent> custodyEventSet = new HashSet<>();

    public void addCustodyEvent(CustodyEvent custodyEvent){
        custodyEventSet.add(custodyEvent);
        }

    public CustodyEvent getByCustodyEventId(long id){
        for(CustodyEvent custodyEvent : custodyEventSet) {
            if(custodyEvent.getId() == id){
                return custodyEvent;
            }
        }
        return null;
    }

    public String getAll(){
        return custodyEventSet.toString();
    }

    public void updateCustodyEvent(long id){
        for(CustodyEvent custodyEvent : custodyEventSet) {
            if(custodyEvent.getId() == id){
                custodyEventSet.remove(custodyEvent);
                addCustodyEvent(custodyEvent);
            }
        }
    }

    public void removeCustodyEvent(long id){
        for(CustodyEvent custodyEvent : custodyEventSet) {
            if(custodyEvent.getId() == id){
                custodyEventSet.remove(custodyEvent);
            }
        }
    }

    public void custAdd(long sampleId){
        for(CustodyEvent custodyEvent : custodyEventSet){
            if(custodyEvent.getSampleId() == sampleId){
                System.out.println("От кого: " + custodyEvent.getFromUser() + "\n" +
                "Кому: " + custodyEvent.getToUser() + "\n" +
                "Место: " + custodyEvent.getLocation() + "\n" +
                "Комментарий: " + custodyEvent.getComment() + "\n" +
                "OK event_id=" + custodyEvent.getId());
            }
        }
    }

    public void custList(int N){
        System.out.println("ID   From   To       Location         Time     ");
        ArrayList<Long> ids = new ArrayList<>();
        for(CustodyEvent custodyEvent : custodyEventSet){
            ids.add(custodyEvent.getId());
        }
        Collections.sort(ids);
        long max = ids.getLast();
        SortedMap<Long, CustodyEvent> map = Collections.emptySortedMap();
        for(CustodyEvent event : custodyEventSet){
            if(event.getId() > max - N && max - N > 0){
                map.put(event.getId(), event);
            } else {
                throw new IllegalArgumentException();
            }
        }

        for(long id : map.keySet()){
            CustodyEvent event = getByCustodyEventId(id);
            String from = event.getFromUser();
            String to = event.getToUser();
            String location = event.getLocation();
            String time = event.getCreatedAt().toString();
            System.out.println(id + "   " + from + "   " + to +  "       " + location + "         " + time);
        }
    }

    public void custShow(long eventId){
        for(CustodyEvent custodyEvent : custodyEventSet){
            if(custodyEvent.getId() == eventId){
               System.out.println("CustodyEvent #" + custodyEvent.getId() + "\n" +
                                  "sample_id: " + custodyEvent.getSampleId() + "\n" +
                                  "from: " + custodyEvent.getFromUser() + "\n" +
                                  "to: " + custodyEvent.getToUser() + "\n" +
                                  "location: " + custodyEvent.getLocation() + "\n" +
                                  "comment: " + custodyEvent.getComment());
            }
        }
    }


    public void custCheck(long sampleId){
        if (custodyEventSet.isEmpty()) {
            throw new IllegalArgumentException("Warning: no custody events");
        }
        for(CustodyEvent custodyEvent : custodyEventSet) {
                if (custodyEvent.getSampleId() == sampleId) {
                    System.out.println("OK current owner: " + custodyEvent.getOwnerUsername());
                }
        }
    }


    public void custExport(long sampleId){
        for(CustodyEvent custodyEvent : custodyEventSet){
            if(custodyEvent.getId() == (sampleId)){
                System.out.println("Sample " + custodyEvent.getSampleId() + " custody chain exported");
                    }
    }
    }
}
