package challenge;

public class CriptografiaCesariana implements Criptografia {

    static int chave = 3;

    @Override
    public String criptografar(String texto) {
        if(texto.equals("")) {
            throw new IllegalArgumentException(texto);
        }

         texto = texto.toLowerCase();
         String textCript = new String();         

         for(int i = 0; i < texto.length(); i++) {
             if(texto.charAt(i) >= 97 && texto.charAt(i) <= 122) {
                int letraASCII = ((int) texto.charAt(i)) + chave;
                if(letraASCII > 122) {
                    textCript += ((int) texto.charAt(i) - 26) + 3;
                } else {
                    textCript += (char) letraASCII;
                }
             } else {
                 textCript += texto.charAt(i);
             }
         }

        return textCript;
    }

    @Override
    public String descriptografar(String texto) {
        if(texto.equals("")) {
            throw new IllegalArgumentException(texto);
        }

        texto = texto.toLowerCase();
        String textDescript = new String();         

         for(int i = 0; i < texto.length(); i++) {
             if(texto.charAt(i) >= 97 && texto.charAt(i) <= 122) {
                int letraASCII = ((int) texto.charAt(i)) - chave;
                if(letraASCII < 97) {
                    textDescript += ((int) texto.charAt(i) + 26) - 3;
                } else {
                    textDescript += (char) letraASCII;
                }
             } else {
                 textDescript += texto.charAt(i);
             }
         }
        
        return textDescript;
    }
}
