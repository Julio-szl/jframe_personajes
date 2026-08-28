import model.Pokemon;
import repository.PokedexJohtoRepository;
import repository.PokedexRepository;
import view.VentanaPrincipal;

import javax.swing.SwingUtilities;
import java.util.List;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();

            List<Pokemon> listaPokemon = new ArrayList<>();
            listaPokemon.addAll(PokedexRepository.obtenerListaPokemon());
            listaPokemon.addAll(PokedexJohtoRepository.obtenerListaPokemon());

            ventana.cargarPokemon(listaPokemon);
            ventana.setVisible(true);
        });
    }
}