package roger.rpcs;

import roger.rpc.RPCImpl;
import roger.rpc.RPCUtils;

public class TestIntIntImpl implements RPCImpl {

	public byte[] invoke(byte[] request) {
		
		int x = RPCUtils.unmarshallInteger(request);
		
		int resx = m(x);
		
		byte[] reply = RPCUtils.marshallInteger(request[0],resx);
		
		return reply;
	}
	
	public int m(int x) {
		System.out.println("int m("+x+") executed");
		return x;
	} 
}
