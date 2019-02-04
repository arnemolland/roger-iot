package roger.system.controller;

import roger.rpc.*;

// Display Client class
public class Display extends RPCStub {

	private byte RPCID = 1;

	public void write(String message) {
		rmiclient.connect();

		byte[] data = RPCUtils.marshallString(RPCID, message);
		rmiclient.call(data);
	}
}
