package com.tk.rocketmq.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Description：describe this class function
 * Author；JinHuatao
 * Date: 2019/2/21 17:28
 */
public class Consumer {

    public static void main(String[] args) throws Exception {
//        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("tk_sync_group");
//        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("tk_async_group");
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("tk_one_way_group");
        consumer.setNamesrvAddr("172.30.154.245:9876");
        //订阅1个或多个主题消费
        consumer.subscribe("TopicTest", "*");
        //注册回调函数去执行从broker获取的消息
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                //System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), list);
                try {
                    String msg = new String(list.get(0).getBody(), RemotingHelper.DEFAULT_CHARSET);
                    System.out.println(msg);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        System.out.printf("Consumer Started.%n");
    }
}
