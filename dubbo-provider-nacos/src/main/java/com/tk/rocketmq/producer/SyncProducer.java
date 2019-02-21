package com.tk.rocketmq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * Description：同步消息发送，重要的通知消息，短信通知，短信营销系统等。
 * Author；JinHuatao
 * Date: 2019/2/21 16:56
 */
public class SyncProducer {

    public static void main(String[] args) throws Exception {
        //示例分组
        DefaultMQProducer producer = new DefaultMQProducer("tk_sync_group");
        //指明name server服务地址
        producer.setNamesrvAddr("172.30.154.245:9876");
        producer.start();
        for(int i = 0; i < 100; i++){
            //创建一个消息实例，并指明topic、tag、消息体
            String msgBody = "Hello RocketMQ" + i;
            Message msg = new Message("TopicTest", "TagA", msgBody.getBytes(RemotingHelper.DEFAULT_CHARSET));
            //调用发送消息方法给其中一个borker转发消息
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }
        //关闭producer
        producer.shutdown();
    }
}
