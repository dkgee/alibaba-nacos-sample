package com.tk.rocketmq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * Description：单向消息发送，用于需要中等可靠性的情况，例如日志收集。
 * Author；JinHuatao
 * Date: 2019/2/21 17:16
 */
public class OnewayProducer {

    public static void main(String[] args) throws Exception {
        //示例分组
        DefaultMQProducer producer = new DefaultMQProducer("tk_one_way_group");
        //指明name server服务地址
        producer.setNamesrvAddr("172.30.154.245:9876");
        producer.start();
        for(int i = 0; i < 100; i++){
            //创建一个消息实例，并指明topic、tag、消息体
            String msgBody = "Hello RocketMQ" + i;
            Message msg = new Message("TopicTest", "TagA", msgBody.getBytes(RemotingHelper.DEFAULT_CHARSET));
            //调用发送消息方法给其中一个borker转发消息
            producer.sendOneway(msg);
        }
        //关闭producer
        producer.shutdown();
    }
}
