package model;

public abstract class Pokemon {

    private String nombre;
    private int numeroPokemon;
    private int ps;
    private int ataque;
    private int defensa;
    private int velocidad;
    private String tipo;
    private String altura;
    private String debilidades;
    private String descripcion;
    private String categoria;
    private String peso;
    private String habilidad;
    private String genero;
    private String rutaImagen;

    public Pokemon(String nombre, int numeroPokemon, int ps, int ataque, int defensa,
        int velocidad, String tipo, String altura, String debilidades, String descripcion, String categoria, String peso, String habilidad,
        String genero, String rutaImagen) {
        this.nombre = nombre;
        this.numeroPokemon = numeroPokemon;
        this.ps = ps;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.tipo = tipo;
        this.altura = altura;
        this.debilidades = debilidades;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.peso = peso;
        this.habilidad = habilidad;
        this.genero = genero;
        this.rutaImagen = rutaImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroPokemon() {
        return numeroPokemon;
    }

    public int getPs() {
        return ps;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }


    public int getVelocidad() {
        return velocidad;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDebilidades(){return  debilidades;}

    public String getDescripcion(){return  descripcion;}

    public String getAltura() {
        return altura;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getPeso() {
        return peso;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public String getGenero() {
        return genero;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public abstract int getAtaqueEspecial();

    public abstract int getDefensaEspecial();

    public abstract String getElemento();


    public abstract String verHabilidad();

    public String mostrarFicha(){
        return String.format(
            "%s [%s] - Puntos de Salud: %d | Daño: %d",
            nombre, categoria, ps, ataque
        );
    }

}
