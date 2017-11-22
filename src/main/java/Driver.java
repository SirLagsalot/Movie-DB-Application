public class Driver {

    public static void main(String[] args) {
        QueryEngine queryEngine = new QueryEngine();
        IModelBuilder builder = new kNearestNeighbor(3);
        IModelRenderer renderer = new ModelRenderer();
        renderer.renderModel(builder.createModel(null));
    }
}
