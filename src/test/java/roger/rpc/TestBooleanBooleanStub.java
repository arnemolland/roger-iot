package roger.rpc;

import roger.rpc.RPCStub;
import roger.rpc.RPCUtils;

public class TestBooleanBooleanStub extends RPCStub {

	private byte RPCID = 4;
	
	public boolean m(boolean b) {
		
		byte[] request = RPCUtils.marshallBoolean(RPCID,b);
		
		byte[] reply = rmiclient.call(request);
		
		boolean bres = RPCUtils.unmarshallBoolean(reply);
		
		return bres;
	}
	
}
