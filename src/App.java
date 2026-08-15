import model.Pokemon;
import model.tipos.Agua;

public class App {
    public static void main(String[] args) throws Exception {
        
        Pokemon[] album = {
            new Agua("Pikachu", 000123, 10, 2, 4, 6, 
            "Agua", "1.5m", "Fuego", "4kg", "Tobogan", "Macho", 
            "src/images/agua.jpg", 8, 6, "Agua", "Tierra")
        };

        for (Pokemon p : album) {
            System.out.println(p.mostrarFicha());
            System.out.println(p.verHabilidad());
        }
    }
}
