public class Day007 {
    public static void main(String[] args) {
        Day007 d1 = new Day007();
        d1.inverteString("Edvaldo");
    }

    public void inverteString(String nome){
        String nomeInvertido = "";
        for(int i = nome.length() - 1; i >= 0; i--){
            nomeInvertido += nome.charAt(i);
        }
        System.out.println(nomeInvertido);
    }
}
