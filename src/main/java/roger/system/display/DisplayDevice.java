package roger.system.display;

import roger.rpc.RPCServer;
import roger.system.controller.Common;

public class DisplayDevice {
	
	public static void main(String[] args) {
		
		System.out.println("Display server starting...");
		
		RPCServer displayServer = new RPCServer(Common.DISPLAYPORT);

		DisplayImpl display = new DisplayImpl();

		displayServer.register(1, display);
		displayServer.run();
		displayServer.stop();
		
		System.out.println("Display server stopping...");
	}
}
