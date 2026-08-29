package model.tipos;

import model.Pokemon;

public class Hada extends Pokemon {

    private int ataqueEspecial;
    private int defensaEspecial;
    private String elemento;

    public Hada(String nombre, int numeroPokemon, int ps, int ataque, int defensa,
            int ataqueEspecial, int defensaEspecial, int velocidad, String tipo,
            String altura, String categoria, String peso, String habilidad,
            String descripcion, String genero, String elemento,
            String debilidades, String rutaImagen) {

        super(nombre, numeroPokemon, ps, ataque, defensa, velocidad, tipo, altura, debilidades, descripcion, categoria, peso, habilidad, genero, rutaImagen);

        this.ataqueEspecial = ataqueEspecial;
        this.defensaEspecial = defensaEspecial;
        this.elemento = elemento;
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

    @Override
    public String verHabilidad() {
        return getNombre() + " tiene la habilidad especial de: " + getHabilidad();
    }

    @Override
    public String mostrarFicha() {
        return super.mostrarFicha()
                + " | Elemento: " + getElemento()
                + " | Débil contra: " + getDebilidades();
    }
}
