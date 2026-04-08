package singleton;

import java.util.ArrayList;

import classi.Ordine;
import observers.Observer;

public class GestoreOrdini {

    private static GestoreOrdini instance;

    private ArrayList<Ordine> ordini;
    private ArrayList<Observer> observers;

    private GestoreOrdini() {
        ordini = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static GestoreOrdini getInstance() {
        if (instance == null) {
            instance = new GestoreOrdini();
        }
        return instance;
    }

    public void aggiungiOrdine(Ordine ordine) {
        ordini.add(ordine);
    }

    public ArrayList<Ordine> getOrdini() {
        return ordini;
    }

    public Ordine getOrdineById(int id) {
        for (Ordine o : ordini) {
            if (o.getId() == id) {
                return o;
            }
        }
        return null;
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void notifyObservers(String stato) {
        for (Observer o : observers) {
            o.aggiorna(stato);
        }
    }

    public void aggiornaStato(int id, String nuovoStato) {
        Ordine ordine = getOrdineById(id);
        if (ordine != null) {
            ordine.setStato(nuovoStato);
            notifyObservers(nuovoStato);
        }
    }
}