public class Nomination { //Con lambdas
   private int year_film;
   private int year_ceremony;
    private int ceremony;
    private String category;
    private String name;
    private String film;
    private boolean winner;

    public Nomination(int year_film, int year_ceremony, int ceremony, String category, String name, String film, boolean winner) {
        this.year_film = year_film;
        this.year_ceremony = year_ceremony;
        this.ceremony = ceremony;
        this.category = category;
        this.name = name;
        this.film = film;
        this.winner = winner;
    }

    public int getYear_film() {
        return year_film;
    }

    public void setYear_film(int year_film) {
        this.year_film = year_film;
    }

    public int getYear_ceremony() {
        return year_ceremony;
    }

    public void setYear_ceremony(int year_ceremony) {
        this.year_ceremony = year_ceremony;
    }

    public int getCeremony() {
        return ceremony;
    }

    public void setCeremony(int ceremony) {
        this.ceremony = ceremony;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }
}
