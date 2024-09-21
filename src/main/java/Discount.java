public interface Discount {

    //applicerar rabatten på produkten och returnerar rabattbeloppet
    double apply(Product product);


    //returnerar en beskrivning av rabatten som en textsträng
    String getDescription(Product product);
}
