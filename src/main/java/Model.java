import java.util.List;

public class Model {

    private List<Double> dependentVariables;
    private List<Double> independentVariables;

    public Model(List<Double> dependentVariables, List<Double> independentVariables) {
        assert dependentVariables.size() == independentVariables.size() : "Invalid variable sets!";

        this.dependentVariables = dependentVariables;
        this.independentVariables = independentVariables;
    }

    public List<Double> getDependentVariables() {
        return dependentVariables;
    }

    public void setDependentVariables(List<Double> dependentVariables) {
        this.dependentVariables = dependentVariables;
    }

    public List<Double> getIndependentVariables() {
        return independentVariables;
    }

    public void setIndependentVariables(List<Double> independentVariables) {
        this.independentVariables = independentVariables;
    }
}
