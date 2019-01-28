package roger.rpc;

import roger.rpc.RPCStub;
import roger.rpc.RPCUtils;

public class TestStringStringStub extends RPCStub {

	public String m(String str) {
		
		byte[] request = RPCUtils.marshallString((byte)2,str);
		
		byte[] reply = rmiclient.call(request);
		
		String strres = RPCUtils.unmarshallString(reply);
		
		return strres;
	}
}
