package lambda;

public class ConstructorRefName {
    public static void main(String[] args) {
        FuncInterface funcInterface = Model::new;
        Model model = funcInterface.function("new model");
        System.out.println(model.getName());
    }
}
