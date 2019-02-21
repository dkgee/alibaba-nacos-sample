package com.tk.rocketmq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * Description：异步消息发送，常用于响应时间敏感的业务场景,保证每个消息都正确发送到位。
 * Author；JinHuatao
 * Date: 2019/2/21 17:09
 */
public class AsyncProducer {

    public static void main(String[] args) throws Exception {
        //示例分组
        DefaultMQProducer producer = new DefaultMQProducer("tk_async_group");
        //指明name server服务地址
        producer.setNamesrvAddr("172.30.154.245:9876");
        producer.start();
        //需要设置当异步发送失败后重试时间
        producer.setRetryTimesWhenSendAsyncFailed(0);
        for(int i = 0; i < 100; i++){
            final int index = i;
            //创建一个消息实例，并指明topic、tag、消息体
            Message msg = new Message("TopicTest", "TagA", "OrderID188", "Hello World".getBytes(RemotingHelper.DEFAULT_CHARSET));
            producer.send(msg, new SendCallback() {
                public void onSuccess(SendResult sendResult) {
                    System.out.printf("%-10d OK %s %n", index, sendResult.getMsgId());
                }
                public void onException(Throwable e) {
                    System.out.printf("%-10d Exception %s %n", index, e);
                    e.printStackTrace();
                }
            });
            //调用发送消息方法给其中一个borker转发消息
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }
        //关闭producer
        producer.shutdown();
    }
}
