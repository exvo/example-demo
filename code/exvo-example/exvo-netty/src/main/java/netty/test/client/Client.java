package netty.test.client;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Date: 2019/9/17$
 * @Author: wy
 * @Description:
 */
public class Client {

    public static void main(String[] args) {

        // 创建一个客户端
        ClientBootstrap bootstrap = new ClientBootstrap();

        // 线程池
        ExecutorService boss = Executors.newCachedThreadPool();
        ExecutorService worker = Executors.newCachedThreadPool();

        // 设置工厂
        bootstrap.setFactory(new NioClientSocketChannelFactory(boss, worker));

        // 设置通道
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            public ChannelPipeline getPipeline() throws Exception {
                ChannelPipeline pipeline = Channels.pipeline();
                pipeline.addLast("encoder", new StringEncoder());
                pipeline.addLast("decoder", new StringDecoder());
                pipeline.addLast("clientHandler", new ClientHandler());
                return pipeline;
            }
        });

        ChannelFuture connect = bootstrap.connect(new InetSocketAddress("127.0.0.1", 10101));

        Channel channel = connect.getChannel();

        System.out.println("client start");

        // 发送消息
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("请输入");
            channel.write(scanner.next());
        }
    }

}
