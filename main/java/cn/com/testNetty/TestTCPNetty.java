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
        //�����������Ҫ�ķ���������
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        //=======================�������������̳߳�
        //BOSS�̳߳�
        EventLoopGroup bossLoopGroup = new NioEventLoopGroup();
        //WORK�̳߳أ�������������ʽ����Ҫ��Ϊ�������˵��Netty���߳�������ô����
        ThreadFactory threadFactory = new DefaultThreadFactory("work thread pool");
        //CPU����
        int processorsNumber = Runtime.getRuntime().availableProcessors();
        EventLoopGroup workLoopGroup = new NioEventLoopGroup(processorsNumber * 2, (ExecutorServiceFactory) threadFactory, SelectorProvider.provider());
        //ָ��Netty��Boss�̺߳�work�߳�
        serverBootstrap.group(bossLoopGroup, workLoopGroup);
        //��������µ�������ʽ��˵��BOSS�̺߳�work�̹߳���һ���̳߳�
        //(ʵ����һ�������£����ֹ����̳߳صķ�ʽ�Ѿ�����)
        //serverBootstrap.group(workLoopGroup);
        //===============================���������������ǵķ����ͨ������
        //ֻ����ʵ����ServerChannel�ӿڵġ���������ͨ��
        serverBootstrap.channel(NioServerSocketChannel.class);
        //��ȻҲ���������������Ǹ�SelectorProvider�ǲ��Ǹо�����Ϥ����
        //serverBootstrap.channelFactory(new ChannelFactory<NioServerSocketChannel>() {
        //  @Override
        //  public NioServerSocketChannel newChannel() {
        //      return new NioServerSocketChannel(SelectorProvider.provider());
        //  }
        //});
        //===================���ô�����
        //Ϊ����ʾ����������������һ��򵥵�ByteArrayDecoder��ByteArrayEncoder
        //Netty����ɫ������һ������ͨ��ˮ�ܡ��еġ���������
        serverBootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {

            }
        });

    }
}

class TCPServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * ��־
     */
    private static Log LOGGER = LogFactory.getLog(TCPServerHandler.class);

    /**
     * ÿһ��channel�����ж�����handler��ChannelHandlerContext��ChannelPipeline��Attribute
     * ���Բ��赣�Ķ��channel����Щ�����໥Ӱ��
     * ��������ʹ��content���key����¼���handler���Ѿ����յ�����Ϣ
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
         * ����ʹ��IDE����ģ�ⳤ�����е����ݻ����ύ��
         * ��read��������������ݣ���ֻ�ǽ��������ۼӣ��������κδ���
         */
        ByteBuf byteBuf = (ByteBuf) msg;
        try {
            StringBuffer contextBuffer = new StringBuffer();
            while (byteBuf.isReadable()) {
                contextBuffer.append((char)byteBuf.readByte());
            }
            //������ʱ����

        } catch (Exception e) {

        }

    }
}
