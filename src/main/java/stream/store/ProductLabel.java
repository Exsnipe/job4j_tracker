package stream.store;

import java.util.List;
import java.util.stream.Collectors;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter(p -> p.getStandard() - p.getActual() >= 0)
                .filter(p -> p.getStandard() - p.getActual() <= 3)
                .map(p -> new Label(p.getName(), (float) (p.getPrice() * 0.5)))
                .map(Label::toString)
                .collect(Collectors.toList());
    }
}
