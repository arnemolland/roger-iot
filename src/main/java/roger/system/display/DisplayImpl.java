package roger.system.display;

import roger.rpc.RPCImpl;
import roger.rpc.RPCUtils;

public class DisplayImpl implements RPCImpl {

	public void write(String message) {
		System.out.println("DISPLAY:" + message);
	}
	
	public byte[] invoke(byte[] request) {
		
		byte[] reply;
		byte rpcid;
		
		// TODO: 
		// implement unmarshalling, call, and marshall for write RPC method
		// look at how this is done int he SensorImpl for the read method
		
		if (true) {
			  throw new RuntimeException("not yet implemented");
		}
		
		return reply;
	}
}
