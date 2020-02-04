package graphicsapp;

import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;

public class DemoApp extends GraphicsApp {

    /**
     * Implementieren Sie eine GraphicsApp, die es Nutzern und Nutzerinnen erlaubt, über vier unterschiedlich-
     * farbige, runde Schaltflächen Zufallskreise mit der ausgewählten Farbe zu erstellen. Die Kreise erscheinen
     * an einer zufälligen Position außerhalb des oberen Bildschirmrandes und fallen mit zufälliger, in jedem Frame
     * steigender, Geschwindigkeit zu Boden und bleiben dort liegen.
     */

    private static final int CANVAS_WIDTH = 500;
    private static final int CANVAS_HEIGHT = 500;
    private static final Color BACKGROUND_COLOR = Colors.WHITE;

    @Override
    public void initialize() {
        setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
    }

    @Override
    public void draw() {
        drawBackground(BACKGROUND_COLOR);
    }

}
