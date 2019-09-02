package com.zhiliaoportal.cn.zhiliaoporta.server;


import java.net.InetAddress;
import java.net.InetSocketAddress;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;

import static com.zhiliaoportal.cn.zhiliaoporta.util.Hex22String.arr2HexStr;
import static com.zhiliaoportal.cn.zhiliaoporta.util.Hex22String.hexStr2Str;

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


        String be = arr2HexStr(req,false);
        System.out.println("GET DATA Hex:"+be);

        System.out.println(be.length());

        String str = new String(req, "UTF-8");
        System.out.println("GET DATA String　："+str);


        if (str.equalsIgnoreCase("L")) {
            //保存到addr1中 并发送addr2
            addr1 = packet.sender();
            System.out.println("L 命令， 保存到addr1中 ");
        } else if (str.equalsIgnoreCase("R")) {
            //保存到addr2中 并发送addr1
            addr2 = packet.sender();
            System.out.println("R 命令， 保存到addr2中 ");
        } else if (str.equalsIgnoreCase("M")) {
            //addr1 -> addr2
            String remot = "A " + addr2.getAddress().toString().replace("/", "")
                    + " " + addr2.getPort();
            ctx.writeAndFlush(new DatagramPacket(
                    Unpooled.copiedBuffer(remot.getBytes()), addr1));
            //addr2 -> addr1
            remot = "A " + addr1.getAddress().toString().replace("/", "")
                    + " " + addr1.getPort();
            ctx.writeAndFlush(new DatagramPacket(
                    Unpooled.copiedBuffer(remot.getBytes()), addr2));
            System.out.println("M 命令");
        }

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("============Server Start============");

        super.channelActive(ctx);
    }
}