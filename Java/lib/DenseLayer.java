// TODO: comments, Helper, set private/public methods, specify types

package Java.lib;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class DenseLayer {
    private int n_neurons;
    private ArrayList<ArrayList<Double>> weights = new ArrayList<ArrayList<Double>>();
    private ArrayList<ArrayList<Double>> biases = new ArrayList<ArrayList<Double>>();
    private ArrayList<ArrayList<Double>> inputs;
    private ArrayList<ArrayList<Double>> output;
    private ArrayList<Double> delta_weights;
    private ArrayList<Double> delta_biases;

    private Helper function = new Helper();

    public DenseLayer(int n_neurons) {
        this.n_neurons = n_neurons;
    }

    public void create(int n_inputs) {
        stand_norm_dist(n_inputs, this.n_neurons, 0.1);

        this.biases.add(new ArrayList<Double>());
        for (int i=0; i<n_neurons; i++) {
            this.biases.get(0).add(0.0);
        }
    }

    public void forward(ArrayList<ArrayList<Double>> inputs) { // differing?? Maybe overloading.. (now set to 2fdd)
        this.inputs = inputs;
        output = function.zeros_like(inputs);  // initialize output with zeros

        // perform dot product on inputs and weights
        function.dot_product(inputs, weights, output);

        // add biases
        double cur; 
        for (int i=0; i<output.size(); i++) {
            for (int j=0; j<output.get(0).size(); j++) {
                cur = output.get(i).get(j);
                this.output.get(i).set(j, cur + biases.get(0).get(j));
            }
        }
    }

    public void backward(ArrayList<Double> delta_values) {  // perform backpass on y (delta_values)
        delta_weights = ; // dot vv (and transpose)
        delta_biases = ;
        delta_inputs = ;
    }

    public String json() {
        return String.format("'type': 'Dense', \n'weights': %s, \n'biases': %s ", this.weights.toString(), this.biases.toString());
    }

    private void stand_norm_dist(int n_inputs, int n_neurons, double factor) {
        Random rand = new Random();
        
        for (int i=0; i<n_inputs; i++) {
            weights.add(new ArrayList<Double>());
            for (int j=0; j<n_neurons; j++) {
                weights.get(i).add(factor * rand.nextGaussian());
            }
        }
    }

    
}
