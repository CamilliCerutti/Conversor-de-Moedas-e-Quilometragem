import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Screen extends JFrame {
    private final String[] menuPrincipal = {"Conversor de moeda", "Conversor de Quilometragem"};
    private double valorDeConversao = 0.0;
    private String valor;
    private double resultadoConversao;
    private String cifrao;
    public Screen() {
        menuPrincipal();
    }

    // captando o valor que sera convertido
    public void menuPrincipal() {
        String opcaoEscolhida = (String)  JOptionPane.showInputDialog(null, "Escolha uma opção", "Menu", JOptionPane.PLAIN_MESSAGE, null, this.menuPrincipal, this.menuPrincipal[0]);
        this.valor = JOptionPane.showInputDialog(null, "Insira o Valor que deseja converter:");

        try {
            this.valorDeConversao = Double.parseDouble(this.valor);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "A digitação precisa ser do tipo numerico!", "Erro", JOptionPane.ERROR_MESSAGE);
            menuPrincipal();
        }

        if(opcaoEscolhida != null) {
            switch (opcaoEscolhida) {
                case "Conversor de moeda"->
                        menuConversorDeMoeda();
                case "Conversor de Quilometragem" ->
                        menuConversorDeKm();
            }
        }

    }
    // Convertendo De acordo com a moeda
    public void menuConversorDeMoeda() {
        double valorDolar = 4.94;
        double valorEuro = 5.41;
        double valorLibraEsterlina = 6.23;
        double valorPesoArgentino = 0.022;
        double valorPesoChileno = 0.0063;
        cifrao = "$";
        String[] opcoesDeConversao = {"Converter de Reais a Dólar", "Converter de Reais a Euro", "Converter de Reais a Libras Esterlinas",
                "Converter de Reais a Peso argentino", "Converter de Reais a Peso Chileno", "Converter de Dólar a Reais",
                "Converter de Euro a Reais", "Converter de Libras Esterlinas a Reais", "Converter de Peso argentino a  Reais",
                "Converter de Peso Chileno a Reais"};
        String opcaoEscolhida = (String)  JOptionPane.showInputDialog(null, "Escolha qual a moeda que voce deseja girar seu dinheiro", "Menu", JOptionPane.PLAIN_MESSAGE, null, opcoesDeConversao, opcoesDeConversao[0]);


        // convertendo
        switch (opcaoEscolhida) {
            case "Converter de Reais a Dólar" ->
                    resultadoConversao = Math.round((this.valorDeConversao / valorDolar) * 100.0) / 100.0;
            case "Converter de Reais a Euro" ->
                    resultadoConversao = Math.round((this.valorDeConversao / valorEuro) * 100.0) / 100.0;
            case "Converter de Reais a Libras Esterlinas" ->
                    resultadoConversao = Math.round((this.valorDeConversao / valorLibraEsterlina) * 100.0) / 100.0;
            case "Converter de Reais a Peso argentino" ->
                    resultadoConversao = Math.round((this.valorDeConversao / valorPesoArgentino) * 100.0) / 100.0;
            case "Converter de Reais a Peso Chileno" ->
                    resultadoConversao = Math.round((this.valorDeConversao / valorPesoChileno) * 100.0) / 100.0;
            case "Converter de Dólar a Reais" -> {
                resultadoConversao = Math.round((this.valorDeConversao * valorDolar) * 100.0) / 100.0;
                cifrao = "R$";
            }
            case "Converter de Euro a Reais" -> {
                resultadoConversao = Math.round((this.valorDeConversao * valorEuro) * 100.0) / 100.0;
                cifrao = "R$";
            }
            case "Converter de Libras Esterlinas a Reais" -> {
                resultadoConversao = Math.round((this.valorDeConversao * valorLibraEsterlina) * 100.0) / 100.0;
                cifrao = "R$";
            }
            case "Converter de Peso argentino a  Reais" -> {
                resultadoConversao = Math.round((this.valorDeConversao * valorPesoArgentino) * 100.0) / 100.0;
                cifrao = "R$";
            }
            case "Converter de Peso Chileno a Reais" -> {
                resultadoConversao = Math.round((this.valorDeConversao * valorPesoChileno) * 100.0) / 100.0;
                cifrao = "R$";
            }
        }
        telaFinal();
    }

    public void menuConversorDeKm(){
        String[] conversao = {"km/h para m/s", "km/h para milha", "m/s para km/h", "m/s para milha", "milha para km/h", "milha para m/s"};
        String opcaoEscolhida = (String)  JOptionPane.showInputDialog(null, "Escolha qual unidade de medida voce quer converter?", "Menu", JOptionPane.PLAIN_MESSAGE, null, conversao, conversao[0]);

        switch (opcaoEscolhida) {
            case "km/h para m/s" -> {
                resultadoConversao = Math.round((valorDeConversao / 3.6) * 100.0) / 100.0;
                cifrao = "m/s";
            }
            case "km/h para milha" -> {
                resultadoConversao = Math.round((valorDeConversao * 0.621371) * 100.0) / 100.0;
                cifrao = "mi";
            }
            case "m/s para km/h" -> {
                resultadoConversao = Math.round((valorDeConversao * 3.6) * 100.0) / 100.0;
                cifrao = "km/h";
            }
            case "m/s para milha" -> {
                resultadoConversao = Math.round((valorDeConversao * 2.237) * 100.0) / 100.0;
                cifrao = "mi";
            }
            case "milha para km/h" -> {
                resultadoConversao = Math.round((valorDeConversao / 0.621371) * 100.0) / 100.0;
                cifrao = "km/h";
            }
            case "milha para m/s" -> {
                resultadoConversao = Math.round((valorDeConversao / 2.237) * 100.0) / 100.0;
                cifrao = "m/s";
            }
        }
        telaFinal();
    }

    // verificando se o uruario quer continuar
    public void telaFinal() {
        JOptionPane.showMessageDialog(null, ("O valor da conversão é "+ cifrao + resultadoConversao), "Mensagem", JOptionPane.INFORMATION_MESSAGE);

        int opcao = JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Select On Option", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if(opcao == JOptionPane.YES_OPTION) {
            menuPrincipal();
        } else if (opcao == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Programa Finalizado", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "Programa Finalizado", "mensagem", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}