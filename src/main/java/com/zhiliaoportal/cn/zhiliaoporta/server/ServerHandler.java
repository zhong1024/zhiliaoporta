package com.zhiliaoportal.cn.zhiliaoporta.server;

import java.net.InetSocketAddress;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;

import static com.zhiliaoportal.cn.zhiliaoporta.util.Hex22String.arr2HexStr;

/**
 * 控制器
 *
 * @author Mr.Zhong
 * @create2019-08-30 9:30
 */
public class ServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {


    boolean flag = false;
    InetSocketAddress addr1 = null;
    InetSocketAddress addr2 = null;

    /**
     * channelRead0 是对每个发送过来的UDP包进行处理
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet)
            throws Exception {
        ByteBuf buf = (ByteBuf) packet.copy().content();
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);


        String be = arr2HexStr(req, false);
        System.out.println("GET DATA Hex:" + be);

        System.out.println(be.length());

        String str = new String(req, "UTF-8");
        System.out.println("GET DATA String　：" + str);


        ctx.writeAndFlush(new DatagramPacket(
                Unpooled.copiedBuffer("02", CharsetUtil.UTF_8), packet.sender()
        )).sync();



    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("============Server Start============");
        super.channelActive(ctx);
    }
}