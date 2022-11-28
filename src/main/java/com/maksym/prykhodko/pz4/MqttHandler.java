package com.maksym.prykhodko.pz4;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.MessageHandler;
import org.springframework.stereotype.Component;

@Component
public class MqttHandler {

    private static final String DISTANCE_TOPIC = "distance";
    private static final String HEAT_TOPIC = "heat";

    private final MqttGateway mqtGateway;

    public MqttHandler(MqttGateway mqtGateway) {
        this.mqtGateway = mqtGateway;
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler() {
        return message -> {
            String topic = message.getHeaders().get(MqttHeaders.RECEIVED_TOPIC).toString();
            int distance = Integer.parseInt((String) message.getPayload());
            if(topic.equals(DISTANCE_TOPIC)) {
                switchOnOffHeat(distance);
            }
        };
    }

    private void switchOnOffHeat(Integer distance) {
        if(distance<0){
            throw new IllegalArgumentException("Invalid distance value");
        }

        if (distance >= 1000) {
            mqtGateway.sendToMqtt("ON", HEAT_TOPIC);
        } else {
            mqtGateway.sendToMqtt("OFF", HEAT_TOPIC);
        }
    }

}
