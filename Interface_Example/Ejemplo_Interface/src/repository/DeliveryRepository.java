package repository;

import shipping.Delivery;
import shipping.FrozenDelivery;
import shipping.StandardDelivery;
import shipping.State;
import shipping.TrackableDelivery;
import shipping.UrgentDelivery;

public class DeliveryRepository {

	public static Delivery[] delivery = new Delivery[0];
	
	/**
	 * 
	 * @param el pedido que quieras añadir
	 */
	public static void createDelivery(Delivery d) {
		Delivery[] aux = delivery;
		delivery = new Delivery[aux.length+1];
		for(int i = 0 ; i<aux.length ; i++)
			delivery[i] = aux[i];
		delivery[aux.length] = d;
	}
	
	/**
	 * si el pedido no se encuentra te devolvera ERROR: index out of bound
	 * @param el pedido que quieras eliminar
	 */
	public static void deleteDelivery(Delivery d) {
		Delivery[] aux = new Delivery[delivery.length-1];
		boolean found = false;
		for(int i = 0 ; i<aux.length ; i++) {
			if(d.equals(delivery[i]))
				found = true;
			if(!found)
				aux[i] = delivery[i];
			else
				aux[i] = delivery[i+1];
		}
	}
	
	/**
	 * 
	 * @param envio. Tiene que tener el mismo codigo que el que quieras modificar. El resto de atributos
	 * pueden ser distintos
	 */
	public static void updateDelivery(Delivery d) {
		boolean found = false;
		for(int i = 0 ; i<delivery.length && !found ; i++)
			if(delivery[i].equals(d)) {
				delivery[i] = d;
				found = true;
			}
	}
	
	/**
	 * 
	 * @param code
	 * @return el pedido con ese codigo correspondiente. Si no existe te devolvera ERROR index out of bound
	 */
	public static Delivery readDelivery(int code) {
		boolean found = false;
		int selected = -1;
		for(int i = 0 ; i<delivery.length && !found ; i++)
			if(delivery[i].getCode() == code) {
				found = true;
				selected = i;
			}
		return delivery[selected];
	}
	
	public static boolean searchDelivery(int code) {
		boolean found = false;
		for(int i = 0 ; i<delivery.length && !found ; i++)
			if(delivery[i].getCode() == code)
				found = true;
		return found;
	}
	
	public static void printDeliveries() {
		for(Delivery d : delivery)
			System.err.println(d);
	}
	
	public static double totalCost() {
		double total = 0;
		for(Delivery d : delivery)
			total += d.totalCost();
		return total;
	}
	
	public static double insuranceCost() {
		double total = 0;
		for(Delivery d : delivery)
			if(d instanceof FrozenDelivery)
				total += ((FrozenDelivery) d).insuranceCost();
			else if(d instanceof UrgentDelivery)
				total += ((UrgentDelivery) d).insuranceCost();
		return total;
	}
	
	public static void updateState(State state, int code) {
		((TrackableDelivery) readDelivery(code)).setState(state);
	}
	
}
