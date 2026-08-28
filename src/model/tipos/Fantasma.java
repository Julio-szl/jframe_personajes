package model.tipos;

import model.Pokemon;

public class Fantasma extends Pokemon {

    private int ataqueEspecial;
    private int defensaEspecial;
    private String elemento;
    private String debilidad;

    public Fantasma(String nombre, int numeroPokemon, int ps, int ataque, int defensa, int ataqueEspecial, int defensaEspecial, int velocidad, String tipo,
                    String altura, String categoria, String peso, String habilidad,String descripcion, String genero,
                    String elemento, String debilidad, String rutaImagen) {
        super(nombre, numeroPokemon, ps, ataque, defensa, velocidad, tipo, altura, categoria, peso, habilidad, genero,
                rutaImagen);
        this.ataqueEspecial = ataqueEspecial;
        this.defensaEspecial = defensaEspecial;
        this.elemento = elemento;
        this.debilidad = debilidad;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public int getDefensaEspecial() {
        return defensaEspecial;
    }

    public String getElemento() {
        return elemento;
    }

    public String getDebilidad() {
        return debilidad;
    }

    @Override
    public String mostrarFicha() {
        return super.mostrarFicha() + " | Elemento: " + elemento
                + " | Débil contra: " + debilidad;
    }

    @Override
    public String verHabilidad() {
        return getNombre() + " tiene la habilidad: " + getHabilidad();
    }

}
