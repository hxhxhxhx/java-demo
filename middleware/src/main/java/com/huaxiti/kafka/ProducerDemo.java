package com.huaxiti.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class ProducerDemo {
    public static void main(String[] args) {
        Properties pro = new Properties();
        //配置server地址
        pro.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.0.109:23");
        //配置key/value序列化
        pro.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        pro.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        //创建生产者实例
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(pro);
        //发送消息
        for (int i = 0; i < 5; i++) {
            producer.send(new ProducerRecord<String,String>("first","Message"+i));
        }
        //关闭资源
        producer.close();
    }
}
