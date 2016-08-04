package cn.com.testNetty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.concurrent.ExecutorServiceFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;

import java.nio.channels.spi.SelectorProvider;
import java.util.concurrent.ThreadFactory;

/**
 * Created by Administrator on 2016/6/24.
 */
public class TestTCPNetty {

    static {
        BasicConfigurator.configure();
    }

    public static void main(String[] args) {
        //这就是我们主要的服务启动器
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        //=======================下面我们设置线程池
        //BOSS线程池
        EventLoopGroup bossLoopGroup = new NioEventLoopGroup();
        //WORK线程池：这样的申明方式，主要是为了向读者说明Netty的线程组是怎么工作
        ThreadFactory threadFactory = new DefaultThreadFactory("work thread pool");
        //CPU个数
        int processorsNumber = Runtime.getRuntime().availableProcessors();
        EventLoopGroup workLoopGroup = new NioEventLoopGroup(processorsNumber * 2, (ExecutorServiceFactory) threadFactory, SelectorProvider.provider());
        //指定Netty的Boss线程和work线程
        serverBootstrap.group(bossLoopGroup, workLoopGroup);
        //如果是以下的申明方式，说明BOSS线程和work线程共享一个线程池
        //(实际上一般的情况下，这种共享线程池的方式已经够了)
        //serverBootstrap.group(workLoopGroup);
        //===============================下面我们设置我们的服务的通道类型
        //只能是实现了ServerChannel接口的“服务器”通道
        serverBootstrap.channel(NioServerSocketChannel.class);
        //当然也可以这样创建（那个SelectorProvider是不是感觉很熟悉？）
        //serverBootstrap.channelFactory(new ChannelFactory<NioServerSocketChannel>() {
        //  @Override
        //  public NioServerSocketChannel newChannel() {
        //      return new NioServerSocketChannel(SelectorProvider.provider());
        //  }
        //});
        //===================设置处理器
        //为了演示，这里我们设置了一组简单的ByteArrayDecoder和ByteArrayEncoder
        //Netty的特色就在这一连串“通道水管”中的“处理器”
        serverBootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {

            }
        });

    }
}

class TCPServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 日志
     */
    private static Log LOGGER = LogFactory.getLog(TCPServerHandler.class);

    /**
     * 每一个channel，都有独立的handler、ChannelHandlerContext、ChannelPipeline、Attribute
     * 所以不需担心多个channel中这些对象相互影响
     * 这里我们使用content这个key，记录这个handler中已经接收到的信息
     */
    private static AttributeKey<StringBuffer> content = AttributeKey.valueOf("content");

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        TCPServerHandler.LOGGER.info("super channelRegistered(ctx)");
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        TCPServerHandler.LOGGER.info("super.channelUnregistered(ctx)");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        TCPServerHandler.LOGGER.info("super.channelActive(ctx) = " + ctx.toString());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        TCPServerHandler.LOGGER.info("super.channelInactive(ctx)");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        TCPServerHandler.LOGGER.info("channelRead(ChannelHandlerContext ctx, Object msg)");
        /**
         * 我们使用IDE工具模拟长连接中的数据缓慢提交。
         * 由read方法负责接收数据，但只是进行数据累加，不进行任何处理
         */
        ByteBuf byteBuf = (ByteBuf) msg;
        try {
            StringBuffer contextBuffer = new StringBuffer();
            while (byteBuf.isReadable()) {
                contextBuffer.append((char)byteBuf.readByte());
            }
            //加入临时区域

        } catch (Exception e) {

        }

    }
}
