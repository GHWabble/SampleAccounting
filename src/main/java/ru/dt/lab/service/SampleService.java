package ru.dt.lab.service;

import ru.dt.lab.domain.Sample;
import ru.dt.lab.domain.SampleHoldStatus;

import java.util.HashSet;
import java.util.Set;

public class SampleService {

    Set<Sample> sampleSet = new HashSet<>();

    public void addSample(Sample sample){
        sampleSet.add(sample);
    }

    public Sample getBySampleId(long id){
        for(Sample sample : sampleSet) {
            if(sample.getId() == id){
                return sample;
            }
        }
        return null;
    }

    public String getAll(){
        return sampleSet.toString();
    }

    public void updateSample(long id){
        for(Sample sample : sampleSet) {
            if(sample.getId() == id){
                sampleSet.remove(sample);
                sampleSet.add(sample);
            }
        }
    }

    public void removeSample(long id){
        for(Sample sample : sampleSet) {
            if(sample.getId() == id){
                sampleSet.remove(sample);
            }
        }
    }

    public void sampleHold(long sampleId){
        for (Sample sample : sampleSet){
            if(sample.getId() == sampleId){
                sample.setStatus(SampleHoldStatus.ON_HOLD);
                System.out.println("OK sample " + sampleId +" is " + sample.getStatus());
            }
        }
    }

    public void sampleRelease(long sampleId){
        for (Sample sample : sampleSet){
            if(sample.getId() == sampleId){
                sample.setStatus(SampleHoldStatus.ACTIVE);
                System.out.println("OK sample " + sampleId + " is " + sample.getStatus());
            }
        }
    }


}
