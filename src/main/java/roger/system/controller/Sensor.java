package roger.system.controller;

import roger.rpc.*;

// Sensor client class
public class Sensor extends RPCStub {

	private byte RPCID = 1;
	
	public int read() {
		rmiclient.connect();

		byte[] data = RPCUtils.marshallVoid(RPCID);
		byte[] response = rmiclient.call(data);
		
		return RPCUtils.unmarshallInteger(response);
	}
}
