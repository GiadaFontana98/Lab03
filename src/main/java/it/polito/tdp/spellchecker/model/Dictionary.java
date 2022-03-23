package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Dictionary {
   
	List<String>dizionario;
	//utente puo scegliere due lingue, io mi conservo nella stringa tutte le parole.
	//ogni volta leggo la parola e la conservo, faccio le letture dal file.
	
	//Adesso controllo l'efficienza
	long start,end, temp=0;
	
	
	public long getTemp() {
		return temp;
	}

	public void setTemp(long temp) {
		this.temp = temp;
	}

	public void loadDictionary(String language)
	{
		
		
		
		dizionario= new LinkedList<String>();
		String l=null;
	if(language.compareTo("English")==0)
	{
		l="C:\\Users\\39327\\git\\Lab03\\src\\main\\resources\\English.txt";
	}
		else
		{
			l="C:\\Users\\39327\\git\\Lab03\\src\\main\\resources\\Italian.txt";
		}
	

		
		try {
			FileReader fr = new FileReader(l);
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
			// Aggiungere parola alla struttura dati
				dizionario.add(word); 
			}
			br.close();
			} catch (IOException e){
			System.out.println("Errore nella lettura del file");
			}
	}
   
	//qui verifico il primo passsaggio, le robe che mette l'utente
	 public List<String>spellCheckTest(String testo)
	{ 
		List<String>paroleErrate= new LinkedList<String>();
		testo=testo.toLowerCase(); //mi porto tutto il testo in minuscolo, cosi non ho problemi per svolgere la traduzione
		testo.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
		String [] parole=testo.split(" ");
		start=System.nanoTime();
		for(String p : parole)
		{
			if(!dizionario.contains(p))
			{
				paroleErrate.add(p);
			}
		}
		end=System.nanoTime();
		temp=(long) ((end-start)*(10e9));  //facciamo le prove per capire quale è la più efficiente.La più efficiente è sempre LinkedList
		return paroleErrate;
	}


	public List<String>spellCheckTextLinear(String testo1)  //Ricerca Lineare
	 {
		 int i =0;
			List<String>paroleErrate= new LinkedList<String>();
			testo1=testo1.toLowerCase(); //mi porto tutto il testo in minuscolo, cosi non ho problemi per svolgere la traduzione
			testo1.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
			String [] parole=testo1.split(" ");
			start=System.nanoTime();
			for(String p : parole)
			{ 
				while(i<dizionario.size())
				if(dizionario.get(i).compareTo(p)==0)
				break;
				if(i==dizionario.size())
				{
					paroleErrate.add(p);
				}
					i++;
			}
		//per testarlo bisogna cambiare il controller e specificare il metodo che voglio provare, io lascio le robe così per come sono per non rovinare il programma.
			
			end=System.nanoTime();
			temp=(long) ((end-start)*(10e9));  //facciamo le prove per capire quale è la più efficiente.La più efficiente è sempre LinkedList
			return paroleErrate;
	 }
	 
	public List<String>spellCheckTextDichonotic()  //Con l'aiuto di Wikipedia
	{
		return null;
	}
  }

