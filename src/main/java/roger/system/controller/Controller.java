package roger.system.controller;

import roger.rpc.RPCClient;
import roger.rpc.RPCServerStopStub;

public class Controller {

	private static int N = 5;

	public static void main(String[] args) {

		System.out.println("Controller starting...");

		// Create display and sensor object
		Display display = new Display();
		Sensor sensor = new Sensor();

		// Create RPC clients for display device and sensor device
		RPCClient displayClient = new RPCClient(Common.DISPLAYHOST, Common.DISPLAYPORT);
		RPCClient sensorClient = new RPCClient(Common.SENSORHOST, Common.SENSORPORT);

		RPCServerStopStub stopdisplay = new RPCServerStopStub();
		RPCServerStopStub stopsensor = new RPCServerStopStub();

		// Register RPC methods in the RPC layer
		displayClient.register(display);
		sensorClient.register(sensor);

		// Register stop methods in the RPC middleware
		displayClient.register(stopdisplay);
		sensorClient.register(stopsensor);

		try {
			for (int i = 0; i < N; i++) {
				int value = sensor.read();
				display.write(value + "°C");

				System.out.println(value);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			System.out.println("Error occurred: " + e);
		}

		System.out.println("Done");

		stopdisplay.stop();
		stopsensor.stop();

		displayClient.disconnect();
		sensorClient.disconnect();

		System.out.println("Controller stopping ...");
	}
}
