package com.app;

import com.aliyun.openservices.iot.api.Profile;
import com.aliyun.openservices.iot.api.message.MessageClientFactory;
import com.aliyun.openservices.iot.api.message.api.MessageClient;
import com.aliyun.openservices.iot.api.message.callback.MessageCallback;
import com.aliyun.openservices.iot.api.message.entity.Message;

public class BenApplicationTests {

    public static void main(String[] args) {
        // 身份
        String accessKey = "LTAIAusnPqip3HFZ";
        String accessSecret = "YAwgI68k2yXaXJvHNMmIJE1dwRN0SB";
        String regionId = "cn-shanghai";
        String uid = "242050040739751134";
        String endPoint = "https://" + uid + ".iot-as-http2." + regionId + ".aliyuncs.com";
        // // a1vPpwUVaRG.iot-as-mqtt.cn-shanghai.aliyuncs.com

        // 连接配置
        Profile profile = Profile.getAccessKeyProfile(endPoint, regionId, accessKey, accessSecret);
        // 构造客户端
        MessageClient client = MessageClientFactory.messageClient(profile);
        // 数据接收
        client.connect(messageToken -> {
            if (null == messageToken) {
                return MessageCallback.Action.CommitSuccess;
            }
            Message m = messageToken.getMessage();
            System.out.println("\ntopic="+m.getTopic());
            System.out.println("payload=" + new String(m.getPayload()));
            System.out.println("generateTime=" + m.getGenerateTime());
            // 此处标记CommitSuccess已消费，IoT平台会删除当前Message，否则会保留到过期时间
            return MessageCallback.Action.CommitSuccess;
        });

    }
}
