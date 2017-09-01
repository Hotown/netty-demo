package com.hotown.Discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by Hotown on 17/8/30.
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        // 静默方式丢弃接收到的数据
        System.out.println("Yes, A new client in = " + channelHandlerContext.name());
        ((ByteBuf)o).release();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) throws Exception {
        // 出现异常时关闭连接
        throwable.printStackTrace();
        channelHandlerContext.close();
    }
}
