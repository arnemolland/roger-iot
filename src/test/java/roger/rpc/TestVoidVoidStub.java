package roger.rpc;

import roger.rpc.RPCStub;
import roger.rpc.RPCUtils;

public class TestVoidVoidStub extends RPCStub {

	public void m() {
		
		byte[] request = RPCUtils.marshallVoid((byte)1);
		
		byte[] reply = rmiclient.call(request);
		
		RPCUtils.unmarshallVoid(reply);
		
	}
}
