package help;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

public abstract class ListHashMap {
	public static ArrayList<String> recupList(String s){ //Renvoie une ArrayList compos�e des diff�rents lignes : (Interpr�te_-_titre)
		String[] stringLine = s.split("\n");
		ArrayList<String> listLine = new ArrayList<String>();
		for (String s2:stringLine){
			listLine.add(s2);
		}
		return listLine;
	}
	
	public static SortedMap<String, ArrayList<String>> ListToHash(ArrayList<String> l){
		SortedMap<String, ArrayList<String>> M = new TreeMap<String,ArrayList<String>>(); //Permet de trier par ordre alphab�tique
		for (String s:l){
			String[] artisteTitre = s.split("-"); //["artiste","chanson"]
			if (artisteTitre.length == 2){ //Evite les noms de chansons non g�r�s
			if (M.containsKey(artisteTitre[0])){
				M.get(artisteTitre[0]).add(artisteTitre[1]);
			}
			else{
				M.put(artisteTitre[0],new ArrayList<String>());
				M.get(artisteTitre[0]).add(artisteTitre[1]);
			}}
		}
		return M;
	}
}
