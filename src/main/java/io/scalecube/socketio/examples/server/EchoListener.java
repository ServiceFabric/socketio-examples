package io.scalecube.socketio.examples.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import io.scalecube.socketio.Session;
import io.scalecube.socketio.SocketIOListener;

public class EchoListener implements SocketIOListener {

  private static final Logger LOGGER = LoggerFactory.getLogger(EchoListener.class);

  @Override
  public void onConnect(final Session session) {
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("Session connected: {}", session);
    }
  }

  @Override
  public void onMessage(final Session session, final ByteBuf message) {
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("{} received message: {}", session.getSessionId(), message.toString(CharsetUtil.UTF_8));
    }
    session.send(message);
  }

  @Override
  public void onDisconnect(final Session session) {
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("Session disconnected: {}", session);
    }
  }

}
