
public class Day025 {

    public static void main(String[] args) {
        Day025 day15 = new Day025();
        day15.contagemDeVogais("vc");
    }

    public int contagemDeVogais(String palavra) {
        int count = 0;
        String vogais = "aeiouAEIOU"; 
    
        for (int i = 0; i < palavra.length(); i++) { 
            char c = palavra.charAt(i); 
            if (vogais.indexOf(c) != -1) { 
                count++; 
            }
        }
        
        return count; 
    }

}