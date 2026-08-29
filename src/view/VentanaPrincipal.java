package view;

import model.Pokemon;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class VentanaPrincipal extends JFrame {

    private CardLayout cardLayout;
    private JPanel PanelContenedor;

    private JPanel panelTipos;

    private JPanel PanelGrid;
    private JLabel lblTipoSeleccionado;
    private PanelDetallesPokemon panelDetalle;

    private List<Pokemon> listaCompleta;


    public VentanaPrincipal(){
        super("Album Pokemon");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,750);
        setMinimumSize(new Dimension(950, 700));
        setLocationRelativeTo(null);


        inicializarComponentes();
    }

    private void inicializarComponentes(){
        setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        PanelContenedor = new JPanel(cardLayout);

        //Panel de tipos
        JPanel pantallaTipos = new JPanel(new BorderLayout());
        pantallaTipos.setBackground(Color.WHITE);

        // Encabezado
        JPanel encabezadoTipos = new JPanel();
        encabezadoTipos.setLayout(new BoxLayout(encabezadoTipos,BoxLayout.Y_AXIS));

        encabezadoTipos.setBackground(Color.WHITE);
        encabezadoTipos.setBorder(new EmptyBorder(25,20,20,20));

        JLabel lblTitulo = new JLabel("Tipos de pokemones");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 28));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblInstruccion = new JLabel("Selecciona un tipo para ver sus pokemones");
        lblInstruccion.setFont(new Font("SansSerif", Font.PLAIN, 14));

        lblInstruccion.setForeground(new Color(100,100,100));
        lblInstruccion.setAlignmentX(Component.CENTER_ALIGNMENT);

        encabezadoTipos.add(lblTitulo);
        encabezadoTipos.add(Box.createVerticalStrut(8));
        encabezadoTipos.add(lblInstruccion);
        pantallaTipos.add(encabezadoTipos,BorderLayout.NORTH);


        // aqui es donde se mustran todos los tipos
        panelTipos = new JPanel(new GridLayout(0,4,20,20));
        panelTipos.setBackground(Color.WHITE);
        panelTipos.setBorder(new EmptyBorder(30,60,40,60));

        JScrollPane scrollTipos = new JScrollPane(panelTipos);
        scrollTipos.setBorder(null);
        scrollTipos.getVerticalScrollBar().setUnitIncrement(16);

        pantallaTipos.add(scrollTipos, BorderLayout.CENTER);

        //Pantalla de los Pokemones
        JPanel pantallaGrid = new JPanel(new BorderLayout());
        pantallaGrid.setBackground(Color.WHITE);

        //barra superior
        JPanel barraGrid = new JPanel(new BorderLayout(20,0));

        barraGrid.setBackground(new Color(245,245,245));
        barraGrid.setBorder(new EmptyBorder(12,20,12,20));


        //creamos un boton para volver a los tipos
        JButton btnVolverTipos = new JButton("<- Volver a Tipos");
        btnVolverTipos.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnVolverTipos.setBackground(new Color(40,45,50));
        btnVolverTipos.setForeground(Color.WHITE);
        btnVolverTipos.setFocusPainted(false);
        btnVolverTipos.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnVolverTipos.addActionListener(e->{
            cardLayout.show(PanelContenedor, "TIPOS");
        });

        //nombre del tipo seleccionado
        lblTipoSeleccionado = new JLabel("Pokemon", SwingConstants.CENTER);
        lblTipoSeleccionado.setFont(new Font("SansSerif", Font.BOLD,22));

        barraGrid.add(btnVolverTipos,BorderLayout.WEST);
        barraGrid.add(lblTipoSeleccionado,BorderLayout.CENTER);
        pantallaGrid.add(barraGrid, BorderLayout.NORTH);

        PanelGrid = new JPanel(new GridLayout(0,4,14,30));
        PanelGrid.setBackground(Color.WHITE);
        PanelGrid.setBorder(new EmptyBorder(20, 25, 30, 25));

        JScrollPane scrollPokemon = new JScrollPane(PanelGrid);
        scrollPokemon.setBorder(null);

        scrollPokemon.getVerticalScrollBar().setUnitIncrement(16);
        pantallaGrid.add(scrollPokemon, BorderLayout.CENTER);


        //Muestra los detalles de cada pokemon
        panelDetalle = new PanelDetallesPokemon(() -> cardLayout.show(PanelContenedor, "GRID"));


        // con esto lo agregamos a la pantalla
        PanelContenedor.add(pantallaTipos, "TIPOS");
        PanelContenedor.add(pantallaGrid, "GRID");
        PanelContenedor.add(panelDetalle, "DETALLE");

        add(PanelContenedor, BorderLayout.CENTER);

        cardLayout.show(PanelContenedor, "TIPOS");

    }

    // cargar los pokemosnes

    public void cargarPokemon (List<Pokemon> lista){
        this.listaCompleta = lista;
        mostrarTiposDisponibles();
    }

    private void mostrarTiposDisponibles() {

        panelTipos.removeAll();

        if (listaCompleta == null) {
            return;
        }


        // Evita que aparezcan tipos repetidos
        Set<String> tiposEncontrados =
                new LinkedHashSet<>();


        for (Pokemon p : listaCompleta) {

            if (p.getTipo() != null &&
                    !p.getTipo().isEmpty()) { String[] tipos = p.getTipo().split("/");
                for (String tipo : tipos) { tiposEncontrados.add(tipo.trim()
                    );
                }
            }
        }

        // Crear una tarjeta por cada tipo
        for (String tipo : tiposEncontrados) {
            JButton botonTipo = crearBotonTipo(tipo); botonTipo.addActionListener(
                    e -> mostrarPokemonPorTipo(tipo)
            );

            panelTipos.add(botonTipo);
        }


        panelTipos.revalidate();
        panelTipos.repaint();
    }

    private JButton crearBotonTipo(String tipo){
        JButton boton = new JButton(tipo.toUpperCase());
        boton.setFont(new Font("SansSerif", Font.BOLD, 16));

        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setPreferredSize(new Dimension(180,90));


        switch (tipo.toLowerCase()) {
            case "planta":
                boton.setBackground(new Color(120, 200, 80));
                break;
            case "agua":
                boton.setBackground(new Color(104, 144, 240));
                break;
            case "bicho":
                boton.setBackground(new Color(168, 184, 32));
                break;
            case "dragon":
                boton.setBackground(new Color(255, 42, 42));
                break;
            case "electrico":
                boton.setBackground(new Color(194, 241, 244));
                break;
            case "fantasma":
                boton.setBackground(new Color(255, 255, 255));
                break;
            case "fuego":
                boton.setBackground(new Color(240, 128, 48));
                break;
            case "hielo":
                boton.setBackground(new Color(106, 232, 239));
                break;
            case "lucha":
                boton.setBackground(new Color(138, 42, 37));
                break;
            case "normal":
                boton.setBackground(new Color(168, 168, 120));
                break;
            case "psiquico":
                boton.setBackground(new Color(131, 81, 175));
                break;
            case "roca":
                boton.setBackground(new Color(74, 47, 7));
                break;
            case "tierra":
                boton.setBackground(new Color(46, 21, 20));
                break;
            case "veneno":
                boton.setBackground(new Color(160, 64, 160));
                break;
            case "volador":
                boton.setBackground(new Color(168, 144, 240));
                break;
        }
        return boton;
    }

    private  void mostrarPokemonPorTipo(String tipoSeleccionado){
        if (listaCompleta == null){
            return;
        }
        List<Pokemon> filtrados = new ArrayList<>();

        for (Pokemon p : listaCompleta){
            if (p.getTipo() == null){
                continue;
            }

            String[] tiposPokemon = p.getTipo().split("/");

            for (String tipo : tiposPokemon){
                if (tipo.trim().equalsIgnoreCase(tipoSeleccionado)){
                    filtrados.add(p);
                    break;
                }
            }
        }

        // cambia el titulo
        lblTipoSeleccionado.setText("Pokemon de tipo" + tipoSeleccionado);

        renderizarGrid(filtrados);

        cardLayout.show(PanelContenedor, "GRID");
    }

    private void renderizarGrid(
            List<Pokemon> pokemones){
        PanelGrid.removeAll();

        for (Pokemon p : pokemones){
            TarjetaPokemon tarjeta = new TarjetaPokemon(p, seleccionado ->{
                panelDetalle.mostrarPokemon(seleccionado);
                cardLayout.show(PanelContenedor, "DETALLE");
            });
            PanelGrid.add(tarjeta);
        }
        PanelGrid.revalidate();
        PanelGrid.repaint();
    }


}

