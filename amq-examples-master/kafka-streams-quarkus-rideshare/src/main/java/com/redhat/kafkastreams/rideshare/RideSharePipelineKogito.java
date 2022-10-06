package com.redhat.kafkastreams.rideshare;

import java.time.Duration;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.TimeWindows;
import org.apache.kafka.streams.kstream.ValueJoiner;
import org.apache.kafka.streams.kstream.Windowed;
import org.drools.core.ClassObjectFilter;
import org.kie.api.runtime.KieSession;
import org.kie.kogito.rules.KieRuntimeBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class RideSharePipelineKogito {
    private static final Logger log = LoggerFactory.getLogger(RideSharePipelineKogito.class);

    final Serde<Transport> transportSerde = new Transport();

    @Inject
    KieRuntimeBuilder krb;

    // @Produces
    public Topology buildTopology() {
        StreamsBuilder builder = new StreamsBuilder();

        KStream<String, String> uber = builder.stream("uber", Consumed.with(Serdes.String(), Serdes.String()));

        KTable<Windowed<Integer>, Transport> uberCost = uber.map((key, value) -> {
            Transport transport = Transport.parse(value);
            transport.setCompany("uber");
            return KeyValue.pair(transport.getAvailableSpace(), transport);
        }).groupByKey(Grouped.with(Serdes.Integer(), transportSerde)).windowedBy(TimeWindows.of(Duration.ofMinutes(1)))
                .reduce((aggValue, newValue) -> newValue);

        KStream<String, String> lyft = builder.stream("lyft", Consumed.with(Serdes.String(), Serdes.String()));

        KTable<Windowed<Integer>, Transport> lyftCost = lyft.map((key, value) -> {
            Transport transport = Transport.parse(value);
            transport.setCompany("lyft");
            return KeyValue.pair(transport.getAvailableSpace(), transport);
        }).groupByKey(Grouped.with(Serdes.Integer(), transportSerde)).windowedBy(TimeWindows.of(Duration.ofMinutes(1)))
                .reduce((aggValue, newValue) -> newValue);

        KTable<Windowed<Integer>, Transport> rides = uberCost.leftJoin(lyftCost,
                new ValueJoiner<Transport, Transport, Transport>() {
                    @Override
                    public Transport apply(Transport leftValue, Transport rightValue) {
                        KieSession kSession = krb.newKieSession();
                        kSession.insert(leftValue);
                        kSession.insert(rightValue);
                        kSession.fireAllRules();
                        Transport selectedTransport = (Transport) kSession
                                .getObjects(
                                    new ClassObjectFilter(Transport.class)
                                ).stream()
                                .findFirst()
                                .orElse(null);
                        kSession.dispose();
                        return selectedTransport;
                    }
                });
        rides.toStream().peek((key, value) -> log.info("Cheapest Ride => Spaces:" + key.key() + " Company: "
                + value.getCompany() + " Cost: " + String.format("$ %3d", value.getCost()) + " USD"));

        return builder.build();
    }

}
