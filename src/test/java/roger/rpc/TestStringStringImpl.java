package roger.rpc;

import roger.rpc.RPCImpl;
import roger.rpc.RPCUtils;

public class TestStringStringImpl implements RPCImpl {

	public byte[] invoke(byte[] request) {
	
		String str = RPCUtils.unmarshallString(request);
		
		String resstr = m(str);
		
		byte[] reply = RPCUtils.marshallString(request[0],resstr);
		
		return reply;
	}
	
	public String m(String str) {
		System.out.println("String m("+str+") executed");
		return str+str;
	}
}
