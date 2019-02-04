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

			// Receive message containing RPC request
			Message message = connection.receive();

			// Find the identifier for the RPC methods to invoke
			byte[] messageData = message.getData();

			int rpcid = 0;
			
			try {
				rpcid = messageData[0];
			} catch (Exception ex) {
				System.out.println("Client disconnected, stopping server...");
			}

			// Lookup the methods to be invoked
			RPCImpl rpcimpl = services.get(rpcid);

			// Invoke the method
			byte[] responseData = rpcimpl.invoke(messageData);

			// Send back message containing RPC reply
			Message response = new Message(responseData);
			connection.send(response);
			
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
