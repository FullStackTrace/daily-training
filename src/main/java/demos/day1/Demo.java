package demos.day1;

import common.ServerChannelHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Demo {
	private static int port = 9991;
	public static void main(String[] args) throws InterruptedException {
		if(args.length > 0) {
			for(String arg : args) {
				if("port".equalsIgnoreCase(arg.trim())) {
					port = Integer.parseInt(arg.replaceAll(" ", "").split("=")[1]);
					break;
				}
			}
		}
		NioEventLoopGroup boss = new NioEventLoopGroup(1);
		NioEventLoopGroup worker = new NioEventLoopGroup(10);
		ServerBootstrap server = new ServerBootstrap();
		server.group(boss, worker)
			.channel(NioServerSocketChannel.class)
			.childHandler(new ChannelInitializer<SocketChannel>() { // (4)
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new ServerChannelHandler());
                }
            })
			.option(ChannelOption.SO_BACKLOG, 128)
			.childOption(ChannelOption.SO_KEEPALIVE, true)
			.childOption(ChannelOption.TCP_NODELAY, true);
		ChannelFuture cf = server.bind(port).sync();
		
		cf.channel();
	}

}
