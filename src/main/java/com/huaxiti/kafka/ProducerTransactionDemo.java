package com.huaxiti.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class ProducerTransactionDemo {
    public static void main(String[] args) {
        Properties pro = new Properties();
        //配置server地址
        pro.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.0.109:23");
        //配置key/value序列化
        pro.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        pro.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        //批次大小，默认16K
        pro.put(ProducerConfig.BATCH_SIZE_CONFIG,16384);
        //等待时间，默认0
        pro.put(ProducerConfig.LINGER_MS_CONFIG,1);
        //缓冲区大小，默认32M
        pro.put(ProducerConfig.BUFFER_MEMORY_CONFIG,33554432);
        //压缩，默认none，可配置gzip、snappy、lz4、zstd
        pro.put(ProducerConfig.COMPRESSION_TYPE_CONFIG,"snappy");
        //设置acks
        pro.put(ProducerConfig.ACKS_CONFIG,"all");
        //设置重试次数
        pro.put(ProducerConfig.RETRIES_CONFIG,2147483647);
        //设置事务id，任意起名
        pro.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG,"transaction_id_0");
        //创建生产者实例
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(pro);

        //初始化事务
        producer.initTransactions();
        //开始事务
        producer.beginTransaction();
        try {
            //发送消息
            for (int i = 0; i < 5; i++) {
                producer.send(new ProducerRecord<String,String>("first","Message"+i));
            }
            //提交事务
            producer.commitTransaction();
        }catch (Exception e) {
            //终止事务
            producer.abortTransaction();
        }finally {
            //关闭资源
            producer.close();
        }
    }
}
