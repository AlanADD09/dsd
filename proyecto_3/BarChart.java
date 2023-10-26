//Proyecto 3 -- Dominguez Duran Alan Axel -- 4CM11
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class BarChart extends JPanel {

    private Map<String, Integer> data;

    public BarChart(Map<String, Integer> data) {
        this.data = data;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int barWidth = 40;
        int spacing = 50; // aumentar el espacio entre las barras y los nombres
        int x = 50;
        // int maxHeight = getHeight() - 100;
        int maxHeight = 500;

        int maxValue = data.values().stream().max(Integer::compareTo).orElse(0);

        // reducir el tamaño de la fuente
        Font font = new Font("Arial", Font.PLAIN, 12);
        g.setFont(font);

        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            String escolaridad = entry.getKey();
            int barHeight = (int) ((double) entry.getValue() / maxValue * maxHeight);
            g.setColor(Color.blue);
            g.fillRect(x, maxHeight - barHeight, barWidth, barHeight);
            g.setColor(Color.black);
            g.drawRect(x, maxHeight - barHeight, barWidth, barHeight);

            // Dibuja el nombre de escolaridad centrado debajo de la barra
            g.setColor(Color.black);
            FontMetrics fm = g.getFontMetrics();
            int stringWidth = fm.stringWidth(escolaridad);
            g.drawString(escolaridad, x + (barWidth - stringWidth) / 2, maxHeight + 30); // aumentar la posición vertical del nombre

            // Dibuja la cantidad debajo de la barra
            String cantidad = String.valueOf(entry.getValue());
            int cantidadWidth = fm.stringWidth(cantidad);
            g.drawString(cantidad, x + (barWidth - cantidadWidth) / 2, maxHeight + 45);

            x += (barWidth + spacing);
        }
    }

    public static void main(String[] args) {
        final String filePath = "Logs.txt";
        final Map<String, Integer> data = DataReader.readData(filePath);

        final BarChart barChart = new BarChart(data);

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Gráfica de Barras");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.add(barChart);
            frame.setVisible(true);

            // Crea un temporizador que actualiza la gráfica cada 3 segundos
            Timer timer = new Timer(3000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Map<String, Integer> newData = DataReader.readData(filePath);
                    barChart.setData(newData);
                    barChart.repaint();
                }
            });
            timer.start();
        });
    }

    public void setData(Map<String, Integer> data) {
        this.data = data;
    }
}