package com.wei.netty.server;

import com.wei.netty.handler.DiscardServerHandler;
import com.wei.netty.handler.ResponseServerHandler;
import com.wei.netty.handler.TimeServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "server.netty")
public class DiscardServer {
    private String host;
    private int port;

    public DiscardServer(int port) {
        this.port = port;
    }
    public DiscardServer() {

    }
    public void run() throws InterruptedException {
        EventLoopGroup eventGroup = null;
        EventLoopGroup workerGroup = null;
        try{
            eventGroup= new NioEventLoopGroup();
            workerGroup = new NioEventLoopGroup();

            ServerBootstrap serverBootstrap=new ServerBootstrap();
            serverBootstrap.group(eventGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new TimeServerHandler());
                        }
                    }).option(ChannelOption.SO_BACKLOG,128)
                    .childOption(ChannelOption.SO_KEEPALIVE,true);
            ChannelFuture cf = serverBootstrap.bind(port);

            cf.channel().closeFuture().sync();
        }finally {
            workerGroup.shutdownGracefully();
            eventGroup.shutdownGracefully();

        }

    }


}
