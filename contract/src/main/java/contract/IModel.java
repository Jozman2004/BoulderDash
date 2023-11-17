package contract;

import entity.element.IMap;
import entity.element.mobile.IMobile;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	/**
	 * Gets the hello world.
	 *
	 * @return the helloworld entity
	 */
	IMap getMap();

	IMobile getMyPlayer();
}
