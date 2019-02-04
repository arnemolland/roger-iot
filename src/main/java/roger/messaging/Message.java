package roger.messaging;

import java.util.Arrays;
import static roger.messaging.MessageConfig.SEGMENTSIZE;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		if(payload.length <= SEGMENTSIZE) {
			this.payload = payload;
		} else {
			System.out.println("Message size too large.");
		}
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload;
	}

	public byte[] encapsulate() {

		byte[] encoded = new byte[SEGMENTSIZE];

		encoded[0] = (byte) this.payload.length; //(byte)length;

		for (int i = 0; i < this.payload.length; i++) {
			encoded[i + 1] = this.payload[i];
		}

		return encoded;
	}

	public void decapsulate(byte[] received) {

		int length = received[0];
		byte[] decoded = new byte[length];

		for (int i = 0; i < length; i++) {
			decoded[i] = received[i + 1];
		}

		this.payload = decoded;
	}
}
