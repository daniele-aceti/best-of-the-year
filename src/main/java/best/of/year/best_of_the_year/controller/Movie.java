package best.of.year.best_of_the_year.controller;

public class Movie {

    private String titolo;

    private String id;

    public Movie() {

    }

    public Movie(String titolo, String id) {
        this.titolo = titolo;
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
