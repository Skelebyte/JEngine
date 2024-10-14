package JEngine;

public enum RendererType {

    DefaultRenderer(0),
    Renderer3D(1),
    Renderer2D(2);



    final int index;

    RendererType(int value) {
        index = value;
    }

}
