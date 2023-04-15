package Simualtion;

//author : Mina Mounir
import java.awt.Graphics2D;
import java.lang.Exception;

import javax.naming.OperationNotSupportedException;

/*interface Simulation
 * description : to be implemented by Instant simulation and real time simulation classes
*/
public interface Simulation {
	// returns the proper simulation object given the Queue and the flag
	public static Simulation getInstance(OpQueue queue, boolean instantFlag) {
		return instantFlag ? new InstantSimulation(queue) : new RealTimeSimualtion(queue);
	}

	// draws the simulation based inside Graphics2D object and returns it
	public abstract Graphics2D render();

	// getter for the OpQueue used for the drawing
	public abstract OpQueue getQueue();

	// steps only 1 time unit which is not supported in Instant Simulation
	public abstract void step() throws OperationNotSupportedException;
}
