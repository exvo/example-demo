package netty.test.server;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Date: 2019/9/17$
 * @Author: wy
 * @Description: netty服务端入门
 */
public class Server {

    public static void main(String[] args) {
        // 服务类
        ServerBootstrap bootstrap = new ServerBootstrap();

        // boss线程监听端口
        ExecutorService boss = Executors.newCachedThreadPool();
        // worker线程负责数据读写操作
        ExecutorService worker = Executors.newCachedThreadPool();

        // 设置nioSocket工厂
        bootstrap.setFactory(new NioServerSocketChannelFactory(boss, worker));

        // 设置管道的工厂
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            public ChannelPipeline getPipeline() throws Exception {
                ChannelPipeline pipeline = Channels.pipeline();
                pipeline.addLast("decoder", new StringDecoder());
                pipeline.addLast("encoder", new StringEncoder());
                pipeline.addLast("serverHandler", new ServerHandler());
                return pipeline;
            }
        });

        bootstrap.bind(new InetSocketAddress(10101));
        System.out.println("start!!!");

    }

}