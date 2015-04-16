package cn.edu.nsu.im.util;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;

public class XMPP {

	private static XMPPConnection conn = null;
	private static String SERVER = "192.168.137.1";
	private static final int PORT = 5222;

	private static void open() {
		ConnectionConfiguration config;
		try {
			config = new ConnectionConfiguration(SERVER, PORT);
			conn = new XMPPConnection(config);
			conn.connect();
		} catch (XMPPException xe) {
			xe.printStackTrace();
		}
	}

	public static XMPPConnection get() {
		if (conn == null) {
			open();
		}
		return conn;
	}

	public static void close() {
		conn.disconnect();
		conn = null;
	}
}
