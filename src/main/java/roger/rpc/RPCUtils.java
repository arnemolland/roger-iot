package roger.rpc;

import java.util.Arrays;
import java.nio.ByteBuffer;

public class RPCUtils {

	public static byte[] marshallString(byte rpcid, String str) {

		byte[] strData = str.getBytes();

		byte[] encoded = new byte[strData.length + 1];

		encoded[0] = rpcid;

		for (int i = 0; i < strData.length; i++) {
			encoded[i + 1] = strData[i];
		}

		return encoded;
	}

	public static String unmarshallString(byte[] data) {
		String decoded = new String(Arrays.copyOfRange(data, 1, data.length));
		
		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {
		byte[] encoded = {rpcid};

		return encoded;
	}

	public static void unmarshallVoid(byte[] data) {
		// Unmarshall void type
		return;
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {
		byte[] encoded = new byte[2];

		encoded[0] = rpcid;
		encoded[1] = (byte) (b ? 1 : 0);

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {
		return (data[1] > 0);
	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		// Make byte array for int
		ByteBuffer bb = ByteBuffer.allocate(4);

		bb.putInt(x);

		byte[] data = bb.array();

		// Encode byte array
		byte[] encoded = new byte[data.length + 1];
		
		encoded[0] = rpcid;

		for (int i = 0; i < data.length; i++) {
			encoded[i + 1] = data[i];
		}

		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		int decoded;

		byte[] integer = new byte[data.length - 1];

		for (int i = 0; i < data.length - 1; i++) {
			integer[i] = data[i + 1];
		}

		ByteBuffer bb = ByteBuffer.wrap(integer);

		decoded = bb.getInt();

		return decoded;
	}
}
