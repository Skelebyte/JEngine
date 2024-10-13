package JEngine;

public enum RendererType {
    Renderer3D(0),
    Renderer2D(1),
    None(2);


    public final int index;
    RendererType(int i) {
        this.index = i;
    }
}
