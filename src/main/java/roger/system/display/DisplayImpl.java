package roger.system.display;

import roger.rpc.RPCImpl;
import roger.rpc.RPCUtils;

public class DisplayImpl implements RPCImpl {

	public void write(String message) {
		System.out.println("DISPLAY:" + message);
	}
	
	public byte[] invoke(byte[] request) {
		byte rpcid = request[0];
		String str = RPCUtils.unmarshallString(request); 
		
		write(str);
		
		return RPCUtils.marshallVoid(rpcid);
	}
}
