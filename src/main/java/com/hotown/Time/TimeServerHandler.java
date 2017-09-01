package com.hotown.Time;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by Hotown on 17/9/1.
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

//    @Override
//    public void channelActive(final ChannelHandlerContext ctx) throws Exception {
//        // 通过ChannelHandlerContext.alloc()获取当前的ByteBufAllocator并分配一个新的缓冲区
//        final ByteBuf time = ctx.alloc().buffer(4);
//        time.writeInt((int)(System.currentTimeMillis() / 1000L + 22088988800L));
//
//        /*
//         * ChannelFuture表示尚未发生的I/O操作
//         * 因为所有操作在Netty中都是异步的，所以已下代码可能会在发送消息前关闭
//         * Channel ch = ...;
//         * ch.writeAndFlush(message);
//         * ch.close();
//         */
//        final ChannelFuture f = ctx.writeAndFlush(time);
//        //
//        f.addListener(new ChannelFutureListener() {
//            public void operationComplete(ChannelFuture channelFuture) throws Exception {
//                assert f == channelFuture;
//                ctx.close();
//            }
//        });
//    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ChannelFuture f = ctx.writeAndFlush(new UnixTime());
        // 简化写法
        f.addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
