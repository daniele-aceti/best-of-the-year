package best.of.year.best_of_the_year.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class BestOfYear {

    private List<Movie> getBestMovies() {
        Movie RitornoAlFuturo = new Movie("Ritorno al futuro", "654321");
        Movie RitornoAlFuturoII = new Movie("Ritorno al futuroII", "102531");
        Movie RitornoAlFuturoIII = new Movie("Ritorno al futuroIII", "123456");
        List<Movie> listaFilm = new ArrayList<>();
        listaFilm.add(RitornoAlFuturo);
        listaFilm.add(RitornoAlFuturoII);
        listaFilm.add(RitornoAlFuturoIII);
        return listaFilm;
    }

    private List<Song> getBestSongs() {
        Song traccia = new Song("Traccia1", "654321");
        Song traccia1 = new Song("Traccia2", "102531");
        Song traccia2 = new Song("Traccia3", "123456");
        List<Song> listaCanzoni = new ArrayList<>();
        listaCanzoni.add(traccia);
        listaCanzoni.add(traccia1);
        listaCanzoni.add(traccia2);
        return listaCanzoni;
    }

    @GetMapping
    public String nome(@RequestParam String name,
            Model model) {
        model.addAttribute("name", name);
        return "bestPage";
    }

    @GetMapping("/movies")
    public String bestMovies(Model model) {
        List<Movie> films = getBestMovies();
        model.addAttribute("film", films);
        //PARTE1
        /*  String film = "";
        for(Movie f : films ){
            film += f.getTitolo() + ", ";
        }
        film = film.substring(0, film.length()-2);
        model.addAttribute("filmFormat", film); */
        return "movies";
    }

    @GetMapping("/songs")
    public String bestSongs(Model model) {
        List<Song> songs = getBestSongs();
        model.addAttribute("song", songs);

        //PARTE1
        /*     String canzoni = "";
        for(Song c : songs ){
            canzoni += c.getTitolo() + ", ";
        }
        canzoni = canzoni.substring(0, canzoni.length()-2);
        model.addAttribute("canzoniFormat", canzoni); */
        return "songs";
    }

    @GetMapping("/songID")
    public String songID(@RequestParam(name = "id") String id, Model model) {
        List<Song> song = getBestSongs();
        for (Song canzoni : song) {
            if (canzoni.getId().equals(id)) {
                model.addAttribute("song", canzoni);
            }
        }
        return "cercaCanzone";
    }

    @GetMapping("/filmID")
    public String filmID(@RequestParam(name = "id") String id, Model model) {
        List<Movie> movie = getBestMovies();
        for (Movie film : movie) {
            if (film.getId().equals(id)) {
                model.addAttribute("film", film);
            }
        }
        return "cercaFilm";
    }

}
