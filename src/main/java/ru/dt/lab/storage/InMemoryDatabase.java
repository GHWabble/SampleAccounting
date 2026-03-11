package ru.dt.lab.storage;

import ru.dt.lab.domain.CustodyEvent;
import ru.dt.lab.domain.Sample;
import ru.dt.lab.domain.Seal;

import java.util.*;

public class InMemoryDatabase {

    private final Set<Sample> samples = new HashSet<>();
    private final Set<Seal> seals = new HashSet<>();
    private final Set<CustodyEvent> events = new HashSet<>();

    public void saveSample(Sample sample) {
        samples.add(sample);
    }

    public Optional<Sample> findSampleById(long id) {
        return samples.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
    }

    public Set<Sample> findAllSamples() {
        return Collections.unmodifiableSet(samples);
    }

    public void saveSeal(Seal seal) {
        seals.add(seal);
    }

    public Optional<Seal> findSealById(long id) {
        return seals.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
    }

    public void saveEvent(CustodyEvent event) {
        events.add(event);
    }

    public Optional<CustodyEvent> findEventById(long id) {
        return events.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
    }

    public List<CustodyEvent> findEventsBySampleId(long sampleId) {
        return events.stream()
                .filter(e -> e.getSampleId() == sampleId)
                .toList();
    }
}