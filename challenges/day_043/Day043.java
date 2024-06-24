import java.awt.*;
import java.awt.print.*;
import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;

public class Day043 extends JFrame implements Printable {
    private JTextArea textArea;
    private JButton addButton;
    private JButton addImageButton;
    private JButton saveButton;
    private Image image;

    public Day043() {
        setTitle("Criar PDF Simples");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Adicionar Texto");
        addImageButton = new JButton("Adicionar Imagem");
        saveButton = new JButton("Salvar como PDF");
        
        buttonPanel.add(addButton);
        buttonPanel.add(addImageButton);
        buttonPanel.add(saveButton);
        
        add(buttonPanel, BorderLayout.SOUTH);
        
        addButton.addActionListener(e -> addText());
        addImageButton.addActionListener(e -> addImage());
        saveButton.addActionListener(e -> saveAsPDF());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Day043 frame = new Day043();
            frame.setVisible(true);
        });
    }

    private void addText() {
        String text = JOptionPane.showInputDialog(this, "Digite o texto a ser adicionado:");
        if (text != null) {
            textArea.append(text + "\n");
        }
    }

    private void addImage() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                image = ImageIO.read(file);
                textArea.append("[Imagem adicionada]\n");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao adicionar a imagem.");
            }
        }
    }

    private void saveAsPDF() {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPrintable(this);
        PageFormat pageFormat = printerJob.defaultPage();
        pageFormat.setOrientation(PageFormat.PORTRAIT);

        if (printerJob.printDialog()) {
            try {
                printerJob.print();
                JOptionPane.showMessageDialog(this, "PDF salvo com sucesso!");
            } catch (PrinterException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao salvar o PDF.");
            }
        }
    }

    @Override
    public int print(Graphics g, PageFormat pf, int pageIndex) {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        textArea.printAll(g);

        if (image != null) {
            g2d.drawImage(image, 0, textArea.getHeight(), this);
        }

        return PAGE_EXISTS;
    }
}
