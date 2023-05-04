package com.huaxiti.kafka;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class ProducerCallbackDemo {
    public static void main(String[] args) throws InterruptedException {
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
            producer.send(new ProducerRecord<String, String>("first", "Message" + i), new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if (e == null){
                        System.out.println("主题："+recordMetadata.topic()+"-> 分区："+recordMetadata.partition());
                    }else {
                        e.printStackTrace();
                    }
                }
            });
            //延迟两秒
            Thread.sleep(2);
        }
        //关闭资源
        producer.close();
    }
}
