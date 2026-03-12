package lab_5.service;

import lab_5.domain.Seal;
import lab_5.domain.SealStatus;

import java.util.HashSet;
import java.util.Set;

public class SealService {
    Set<Seal> sealSet = new HashSet<>();

    public void addSeal(Seal seal){
        sealSet.add(seal);
    }

    public Seal getBySealId(long id){
        for(Seal seal : sealSet) {
            if(seal.getId() == id){
                return seal;
            }
        }
        return null;
    }

    public String getAll(){
        return sealSet.toString();
    }

    public void updateSeal(long id){
        for(Seal seal : sealSet) {
            if(seal.getId() == id){
                sealSet.remove(seal);
                sealSet.add(seal);
            }
        }
    }

    public void removeSeal(long id){
        for(Seal seal : sealSet) {
            if(seal.getId() == id){
                sealSet.remove(seal);
            }
        }
    }

    public void sealAdd(long sampleId){
        for (Seal seal : sealSet){
            if(seal.getSampleId() == sampleId) {
                if (!seal.getSealNumber().isEmpty() && sealSet.contains(seal)) {
                    sealSet.add(seal);
                    System.out.println("Номер пломбы: " + seal.getSealNumber() + "\n" +
                            "OK seal_id=" + seal.getId());
                }
            }
        }
    }

    public void sealShow(long sealId){
        for(Seal seal : sealSet) {
            if(seal.getId() == sealId) {
                System.out.println("Seal #" + sealId + "\n" +
                        "sample_id: " + seal.getSampleId() + "\n" +
                        "sealNumber: " + seal.getSealNumber() + "\n" +
                        "status: " + seal.getStatus());
            }
        }
    }

    public void sealBreak(long sealId){
        for(Seal seal : sealSet) {
            if(seal.getId() == sealId) {
                if(seal.getStatus() == SealStatus.BROKEN) {
                    throw new IllegalArgumentException();
                } else {
                    seal.setStatus(SealStatus.BROKEN);
                    System.out.println("Seal #" + sealId + "\n" +
                            "OK seal is " + seal.getStatus());
                }
    }
        }
    }

}
