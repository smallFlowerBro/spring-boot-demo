package com.wei.netty.client;


import com.wei.netty.handler.TimeClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */

@Slf4j
@Configuration
public class TimeClient {

    @Value("${server.netty.host}")
    private String host;
    @Value("${server.netty.port}")
    private int port;


    public void run() throws InterruptedException {
        EventLoopGroup workGroup=null;
        try {
            workGroup=new NioEventLoopGroup();
            Bootstrap b= new Bootstrap();
            b.group(workGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE,true);
            b.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new TimeClientHandler());
            }
        });

            ChannelFuture sync = b.connect(host, port).sync();
            sync.channel().closeFuture().sync();
        } finally {
            workGroup.shutdownGracefully();
        }


    }




}
