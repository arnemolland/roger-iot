package roger.system.sensor;

import roger.rpc.RPCServer;
import roger.system.controller.Common;

public class SensorDevice {

	public static void main(String[] args) {

		System.out.println("Sensor server starting...");

		RPCServer sensorserver = new RPCServer(Common.SENSORPORT);

		SensorImpl sensor = new SensorImpl();

		sensorserver.register(1, sensor);
		sensorserver.run();
		sensorserver.stop();

		System.out.println("Sensor server stopping ...");
	}
}
