package roger.rpc;

import java.util.HashMap;

import roger.messaging.Connection;
import roger.messaging.Message;
import roger.messaging.MessagingServer;

public class RPCServer {

	private MessagingServer msgserver;
	private Connection connection;

	// hashmap to register RPC methods which are required to implement RPCImpl

	private HashMap<Integer, RPCImpl> services;

	public RPCServer(int port) {

		this.msgserver = new MessagingServer(port);
		this.services = new HashMap<Integer, RPCImpl>();

		// the stop RPC methods is built into the server
		services.put((int) RPCCommon.RPIDSTOP, new RPCServerStopImpl());
	}

	public void run() {

		System.out.println("RPC SERVER RUN - Services: " + services.size());

		connection = msgserver.accept();

		System.out.println("RPC SERVER ACCEPTED");

		boolean stop = false;

		while (!stop) {

			int rpcid;

			Message message = connection.receive();

			byte[] messageData = message.getData();

			

			// TODO
			// - receive message containing RPC request
			// - find the identifier for the RPC methods to invoke
			// - lookup the methods to be invoked
			// - invoke the method
			// - send back message containing RPC reply

			if (true) {
				throw new RuntimeException("not yet implemented");
			}

			if (rpcid == RPCCommon.RPIDSTOP) {
				stop = true;
			}
		}

	}

	public void register(int rmid, RPCImpl impl) {
		services.put(rmid, impl);
	}

	public void stop() {
		connection.close();
		msgserver.stop();
	}
}
