package roger.rpc;

import roger.rpc.RPCImpl;
import roger.rpc.RPCUtils;

public class TestVoidVoidImpl implements RPCImpl {

	public void m() {
		System.out.println("void m() executed");
	}
	
	public byte[] invoke(byte[] request) {
		
		RPCUtils.unmarshallVoid(request);
		
		m();
		
		byte[] reply = RPCUtils.marshallVoid(request[0]);
		
		return reply;
	}
}
