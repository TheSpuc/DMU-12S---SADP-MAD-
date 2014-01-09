package Opg2;

import java.util.Iterator;

public interface DictionaryI<K, V> {
	/**
	 * Returner værdien hørende til nøglen k. Returner null, hvis nøglen k ikke
	 * er i dictionary.
	 * 
	 * @param k
	 * @return
	 */
	public V get(K key);

	/**
	 * Indsættet parret (nøgle, værdi) i dictionary med k som nøgle og v som
	 * værdi. Returner den gamle værdi, hvis nøglen k i forvejen var i
	 * dictionary. Hvis ikke, returneres null. Hverken nøglen k eller værdien v
	 * kan være null.
	 * 
	 * @return
	 */
	public V put(K key, V value);

	/**
	 * Fjerner (nøgle, værdi)-parret med nøgle k fra dictionary. Returnerer
	 * værdien kørende til nøglen, hvis nøglen var I dictionary. Hvis ikke
	 * returneres null.
	 * 
	 * @return
	 */
	public V remove(K key);

	/**
	 * Returnerer en iterator med alle nøgler.
	 * 
	 * @return
	 */
	public Iterator<K> keys();

	/**
	 * Returnerer en iterator med alle værdier.
	 * 
	 * @return
	 */
	public Iterator<V> values();

	/**
	 * Returnerer antallet af (nøgle,værdi)-par.
	 * 
	 * @return
	 */
	public int size();

	/**
	 * Returnerer true hvis dictionary er tom, false ellers
	 * 
	 * @return
	 */
	public boolean isEmpty();

}
