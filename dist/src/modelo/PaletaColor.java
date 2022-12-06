
package modelo;

import java.awt.Color;


public class PaletaColor {
    
    private String id_paleta;
    private Color Background;
    private Color Panel;
    private Color MouseEnter;
    private Color MouseClick;
    
    public PaletaColor(){
        this.id_paleta = "";
        this.Background = Color.decode("#fff1d0");
        this.Panel = Color.decode("#07a0c3");
        this.MouseEnter = Color.decode("#086788");
        this.MouseClick = Color.decode("#56b4e8");
    }
    
    public PaletaColor(String id_paleta, String bg, String panel, String mouse_enter, String mouse_click){
        this.id_paleta = id_paleta;
        this.Background = Color.decode(bg);
        this.Panel = Color.decode(panel);
        this.MouseEnter = Color.decode(mouse_enter);
        this.MouseClick = Color.decode(mouse_click);

    }


    
    public String getId_paleta() {
        return id_paleta;
    }

    public void setId_paleta(String id_paleta) {
        this.id_paleta = id_paleta;
    }

    public Color getBackground() {
        return Background;
    }

    public void setBackground(Color Background) {
        this.Background = Background;
    }

    public Color getPanel() {
        return Panel;
    }

    public void setPanel(Color Panel) {
        this.Panel = Panel;
    }

    public Color getMouseEnter() {
        return MouseEnter;
    }

    public void setMouseEnter(Color MouseEnter) {
        this.MouseEnter = MouseEnter;
    }

    public Color getMouseClick() {
        return MouseClick;
    }

    public void setMouseClick(Color MouseClick) {
        this.MouseClick = MouseClick;
    }
    
    
    
}
