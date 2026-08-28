package view;

import model.Pokemon;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaPrincipal extends JFrame {

    private CardLayout cardLayout;
    private JPanel PanelContenedor;
    private JPanel PanelGrid;
    private PanelDetallesPokemon panelDetalle;


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

        //Principal
        cardLayout = new CardLayout();
        PanelContenedor = new JPanel(cardLayout);

        // Catalogos
        PanelGrid = new JPanel(new GridLayout(0, 4, 14,30));
        PanelGrid.setBackground(Color.WHITE);
        PanelGrid.setBorder(BorderFactory.createEmptyBorder(20,25,30,25));

        JScrollPane scrollPane = new JScrollPane(PanelGrid);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(16);

        //Detalles
        panelDetalle = new PanelDetallesPokemon(() -> cardLayout.show(PanelContenedor, "GRID"));

        PanelContenedor.add(scrollPane, "GRID");
        PanelContenedor.add(panelDetalle, "DETALLE");

        add(PanelContenedor, BorderLayout.CENTER);
    }


    // cargar los pokemosnes

    public void cargarPokemon (List<Pokemon> lista){
        renderizarGrid(lista);
    }

    private void renderizarGrid(List<Pokemon> pokemones){
        PanelGrid.removeAll();

        for (Pokemon p : pokemones){

            TarjetaPokemon tarjeta = new TarjetaPokemon(p, selec -> {

                //aqui muestra los detalles del pokemon ejegido.
                panelDetalle.mostrarPokemon(selec);

                cardLayout.show(PanelContenedor, "DETALLE");
            });

            PanelGrid.add(tarjeta);
        }

        PanelGrid.revalidate();
        PanelGrid.repaint();
    }


}
