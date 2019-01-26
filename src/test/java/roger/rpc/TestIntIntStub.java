package roger.rpcs;

import roger.rpc.RPCStub;
import roger.rpc.RPCUtils;

public class TestIntIntStub extends RPCStub {

	private byte RPCID = 3;
	
	public int m(int x) {
				
		byte[] request = RPCUtils.marshallInteger(RPCID,x);
		
		byte[] reply = rmiclient.call(request);
		
		int xres = RPCUtils.unmarshallInteger(reply);
		
		return xres;
	}
}
