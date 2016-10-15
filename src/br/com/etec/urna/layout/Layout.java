
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.urna.layout;

import static br.com.etec.urna.animacoes.Animacoes.animation;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.WindowListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import br.com.etec.urna.botoes.*;
import br.com.etec.urna.utils.ConexaoBD;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTextField;

/**
 *
 * @author Victor
 */
public class Layout extends JFrame {

    public static ImageIcon n_0, n_1, n_2, n_3, n_4, n_5, n_6, n_7, n_8, n_9, corrige, confirmar, branco;
    public static ImageIcon tela;
    public static JLabel lbl2;
    public static JLabel lbl1;
    public static JLabel lbl3;
    public static JLabel lbl4;
    public static JLabel lbl5;
    public static JLabel lbl6;
    public static JLabel lbl7;
    public static JLabel lbl8;
    public static JLabel lbl9;
    public static JLabel lbl0;
    public static JLabel tla;
    public static ImageIcon ladoEsq;
    public static JLabel lblLadoEsq;
    public static JLabel lblEsp7;
    public static JLabel lblEsp9;
    public static ImageIcon espaco7;
    public static ImageIcon topo;
    public static JLabel lblTopo;
    public static JLabel lblInferior;
    public static ImageIcon inferior;
    public static JLabel lblDir;
    public static ImageIcon direita;
    public static JLabel lblBordaDir;
    public static ImageIcon bordaDireita;
    public static ImageIcon espaco9;
    public static JLabel lblBranco;
    public static JLabel lblCorrige;
    public static JLabel lblConfirma;
    public static String caminhoRecursos = "/br/com/etec/urna/recursos/";
    public static JLabel lblFim = new JLabel("FIM");
    public static JLabel lblNum1;
    public static JLabel lblNum2;
    public static JLabel lblNum3;
    public static JLabel lblNum4;
    public static JLabel lblNum5;
    public static JLabel lblNumero;
    public static JLabel lblNumeroErrado;
    public static JLabel lblNome;
    public static JLabel lblPartido;
    public static JLabel lblNomeCandidato;
    public static JLabel lblNomePartido;
    public static JLabel lblInstrucoes3;
    public static JLabel lblInstrucoes2;
    public static JLabel lblInstrucoes1;
    public static JLabel lblCargo;
    public static JLabel lblInfo;
    public static boolean voto = false;
    public static boolean desabilitado = true;
    public static boolean brancoDesabilitado = true;
    public static boolean brancoPressionado = false;
    public static boolean candidatoExiste = false;
    public static String cargo;
    public static JLabel lblLinha;
    public static ImageIcon linhaTela;
    public static JLabel lblCandidatoInexistente;
    public static JLabel lblLegendaPeq;
    public static JLabel lblLegendaGrande;
    public static JLabel lblNulo;
    public static JLabel lblVotoBranco;
    public static JLabel lblImgPrefeito;
    public static JLabel lblImgVice;
    private final int largura = 120;
    private final int altura = 165;
    public static JLabel lblImgCandidato;
    private Connection connection;
    private final JTextField tecladoListener;

    public Layout() {
        super.setLayout(null);
        super.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        super.setTitle("Urna");
        super.setSize(650, 650);
        super.setExtendedState(JFrame.MAXIMIZED_BOTH);
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        super.addWindowListener(new WindowListener() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent we) {
            }

            @Override
            public void windowOpened(java.awt.event.WindowEvent we) {
            }

            @Override
            public void windowClosed(java.awt.event.WindowEvent we) {
            }

            @Override
            public void windowIconified(java.awt.event.WindowEvent we) {
            }

            @Override
            public void windowDeiconified(java.awt.event.WindowEvent we) {
            }

            @Override
            public void windowActivated(java.awt.event.WindowEvent we) {
            }

            @Override
            public void windowDeactivated(java.awt.event.WindowEvent we) {
            }

        });

        JPanel painel = (JPanel) getContentPane();
        painel.setBackground(Color.WHITE);
        super.setUndecorated(true);
        //Tela
        tela = new ImageIcon(getClass().getResource(caminhoRecursos + "tela.jpg"));
        tla = urnaLabels(painel, tla, tela, 150, 90, tela.getIconWidth(), tela.getIconHeight());
        //Borda ESQ
        ladoEsq = new ImageIcon(getClass().getResource(caminhoRecursos + "ladoEsqTec.jpg"));
        lblLadoEsq = urnaLabels(painel, lblLadoEsq, ladoEsq, tela.getIconWidth() + tla.getX(), tla.getY() + 258, ladoEsq.getIconWidth(), ladoEsq.getIconHeight());
        //Topo
        topo = new ImageIcon(getClass().getResource(caminhoRecursos + "topo.jpg"));
        lblTopo = urnaLabels(painel, lblTopo, topo, tela.getIconWidth() + 150, 90 - 3, topo.getIconWidth(), topo.getIconHeight());
        //Inferior
        inferior = new ImageIcon(getClass().getResource(caminhoRecursos + "abaixoTec.jpg"));
        lblInferior = urnaLabels(painel, lblInferior, inferior, tela.getIconWidth() + tla.getX(), tla.getY() + tela.getIconHeight() - 59, inferior.getIconWidth(), inferior.getIconHeight());
        //Direita
        direita = new ImageIcon(getClass().getResource(caminhoRecursos + "faixaDir.jpg"));
        lblDir = urnaLabels(painel, lblDir, direita, topo.getIconWidth() + tela.getIconWidth() + tla.getX(), tla.getY() + 32, direita.getIconWidth(), direita.getIconHeight());
        //Borda DIR
        bordaDireita = new ImageIcon(getClass().getResource(caminhoRecursos + "ladoDirTec.jpg"));
        lblBordaDir = urnaLabels(painel, lblBordaDir, bordaDireita, topo.getIconWidth() + tela.getIconWidth() - 37 + tla.getX(), tla.getY() + topo.getIconHeight() - 3, bordaDireita.getIconWidth(), bordaDireita.getIconHeight());
        //Espaços abaixo do 7 e do 9
        espaco7 = new ImageIcon(getClass().getResource(caminhoRecursos + "ptabaixo7.jpg"));
        lblEsp7 = urnaLabels(painel, lblEsp7, espaco7, tela.getIconWidth() + ladoEsq.getIconWidth() + tla.getX(), tla.getY() + ladoEsq.getIconHeight() + 258 - espaco7.getIconHeight(), espaco7.getIconWidth(), espaco7.getIconHeight());

        espaco9 = new ImageIcon(getClass().getResource(caminhoRecursos + "ptabaixo9.jpg"));
        lblEsp9 = urnaLabels(painel, lblEsp9, espaco9, tela.getIconWidth() + ladoEsq.getIconWidth() + 153 + tla.getX(), tla.getY() + ladoEsq.getIconHeight() + 247 - espaco9.getIconHeight(), espaco9.getIconWidth(), espaco9.getIconHeight());
        //Número 1
        n_1 = new ImageIcon(getClass().getResource(caminhoRecursos + "n1.jpg"));
        lbl1 = urnaLabels(painel, lbl1, n_1, ladoEsq.getIconWidth() + tela.getIconWidth() + tla.getX(), tla.getY() + 243 + 15, n_1.getIconWidth(), n_1.getIconHeight());
        lbl1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //Número 2        
        n_2 = new ImageIcon(getClass().getResource(caminhoRecursos + "n2.jpg"));
        lbl2 = urnaLabels(painel, lbl2, n_2, ladoEsq.getIconWidth() + tela.getIconWidth() + n_1.getIconWidth() + tla.getX(), tla.getY() + 243 + 15, n_2.getIconWidth(), n_2.getIconHeight());
        //Número 3
        n_3 = new ImageIcon(getClass().getResource(caminhoRecursos + "n3.jpg"));
        lbl3 = urnaLabels(painel, lbl3, n_3, ladoEsq.getIconWidth() + n_2.getIconWidth() + n_3.getIconWidth() + tela.getIconWidth() + 4 + tla.getX(), tla.getY() + 243 + 15, n_3.getIconWidth(), n_3.getIconHeight());
        lbl3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //Número 4
        n_4 = new ImageIcon(getClass().getResource(caminhoRecursos + "n4.jpg"));
        lbl4 = urnaLabels(painel, lbl4, n_4, ladoEsq.getIconWidth() + tela.getIconWidth() + tla.getX(), tla.getY() + n_1.getIconHeight() + 243 + 15, n_4.getIconWidth(), n_4.getIconHeight());
        lbl4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //Número 5
        n_5 = new ImageIcon(getClass().getResource(caminhoRecursos + "n5.jpg"));
        lbl5 = urnaLabels(painel, lbl5, n_5, ladoEsq.getIconWidth() + tela.getIconWidth() + n_4.getIconWidth() + tla.getX(), tla.getY() + n_2.getIconHeight() + 243 + 15, n_5.getIconWidth(), n_5.getIconHeight());
        lbl5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //Número 6
        n_6 = new ImageIcon(getClass().getResource(caminhoRecursos + "n6.jpg"));
        lbl6 = urnaLabels(painel, lbl6, n_6, ladoEsq.getIconWidth() + n_5.getIconWidth() + n_6.getIconWidth() + tela.getIconWidth() + 4 + tla.getX(), tla.getY() + 243 + n_3.getIconHeight() + 15, n_6.getIconWidth(), n_6.getIconHeight());
        lbl6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //Número 7
        n_7 = new ImageIcon(getClass().getResource(caminhoRecursos + "n7.jpg"));
        lbl7 = urnaLabels(painel, lbl7, n_7, ladoEsq.getIconWidth() + tela.getIconWidth() + tla.getX(), tla.getY() + n_1.getIconHeight() + n_4.getIconHeight() + 243 + 15, n_7.getIconWidth(), n_7.getIconHeight());
        lbl7.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //Número 8
        n_8 = new ImageIcon(getClass().getResource(caminhoRecursos + "n8.jpg"));
        lbl8 = urnaLabels(painel, lbl8, n_8, ladoEsq.getIconWidth() + tela.getIconWidth() + n_7.getIconWidth() + tla.getX(), tla.getY() + n_2.getIconHeight() + n_5.getIconHeight() + 243 + 15, n_8.getIconWidth(), n_8.getIconHeight());
        lbl8.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //Número 9
        n_9 = new ImageIcon(getClass().getResource(caminhoRecursos + "n9.jpg"));
        lbl9 = urnaLabels(painel, lbl9, n_9, ladoEsq.getIconWidth() + n_8.getIconWidth() + n_9.getIconWidth() + tela.getIconWidth() + 4 + tla.getX(), tla.getY() + 243 + n_3.getIconHeight() + n_6.getIconHeight() + 15, n_9.getIconWidth(), n_9.getIconHeight());
        lbl9.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //Número 0
        n_0 = new ImageIcon(getClass().getResource(caminhoRecursos + "n0.jpg"));
        lbl0 = urnaLabels(painel, lbl0, n_0, ladoEsq.getIconWidth() + tela.getIconWidth() + n_7.getIconWidth() + tla.getX(), tla.getY() + 273 + 28 + n_8.getIconHeight() + n_5.getIconHeight() + 15, n_0.getIconWidth(), n_0.getIconHeight());
        lbl0.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //Branco
        branco = new ImageIcon(getClass().getResource(caminhoRecursos + "branco.jpg"));
        lblBranco = urnaLabels(painel, lblBranco, branco, tela.getIconWidth() + tla.getX(), tla.getY() + 485, branco.getIconWidth(), branco.getIconHeight());
        lblBranco.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblBranco.addMouseListener(new MListenerBranco());
        //Corrige
        corrige = new ImageIcon(getClass().getResource(caminhoRecursos + "corrige.jpg"));
        lblCorrige = urnaLabels(painel, lblCorrige, corrige, tela.getIconWidth() + branco.getIconWidth() + tla.getX(), tla.getY() + 485, corrige.getIconWidth(), corrige.getIconHeight());
        lblCorrige.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblCorrige.addMouseListener(new MListenerCorrige());
        //Confirma
        confirmar = new ImageIcon(getClass().getResource(caminhoRecursos + "confirma.jpg"));
        lblConfirma = urnaLabels(painel, lblConfirma, confirmar, tela.getIconWidth() + branco.getIconWidth() + corrige.getIconWidth() + tla.getX(), tla.getY() + 474, confirmar.getIconWidth(), confirmar.getIconHeight());
        lblConfirma.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblConfirma.addMouseListener(new MListenerConfirmar());
        //Label "Seu voto para"
        lblInfo = new JLabel("SEU VOTO PARA");
        lblInfo.setBounds(53 + tla.getX(), tla.getY() + 205, 200, 40);
        lblInfo.setFont(new Font("Arial", Font.BOLD, 15));
        lblInfo.setForeground(Color.black);
        lblInfo.setVisible(false);
        painel.add(lblInfo);
        painel.setComponentZOrder(lblInfo, 0);
        //Label do Cargo
        lblCargo = new JLabel("Vereador");
        lblCargo.setBounds(140 + tla.getX(), tla.getY() + 245, 250, 40);
        lblCargo.setFont(new Font("Arial", Font.PLAIN, 25));
        lblCargo.setForeground(Color.black);
        painel.add(lblCargo);
        painel.setComponentZOrder(lblCargo, 0);
        //Label Número -- Aparece após terminar a digitação do número   
        lblNumero = new JLabel("Número: ");
        lblNumero.setBounds(53 + tla.getX(), tla.getY() + 315, 100, 40);
        lblNumero.setFont(new Font("Arial", Font.PLAIN, 17));
        lblNumero.setForeground(Color.black);
        lblNumero.setVisible(false);
        painel.add(lblNumero);
        painel.setComponentZOrder(lblNumero, 0);

        //Aparece caso o número não exista
        lblNumeroErrado = new JLabel("NÚMERO ERRADO");
        lblNumeroErrado.setBounds(53 + tla.getX(), tla.getY() + 360, 200, 40);
        lblNumeroErrado.setFont(new Font("Arial", Font.PLAIN, 22));
        lblNumeroErrado.setVisible(false);
        lblNumeroErrado.setForeground(Color.black);
        painel.add(lblNumeroErrado);
        painel.setComponentZOrder(lblNumeroErrado, 0);
        //Voto no partido
        lblCandidatoInexistente = new JLabel("CANDIDATO INEXISTENTE");
        lblCandidatoInexistente.setBounds(53 + tla.getX(), tla.getY() + 360, 500, 40);
        lblCandidatoInexistente.setFont(new Font("Arial", Font.PLAIN, 22));
        lblCandidatoInexistente.setVisible(false);
        lblCandidatoInexistente.setForeground(Color.black);
        painel.add(lblCandidatoInexistente);
        painel.setComponentZOrder(lblCandidatoInexistente, 0);

        lblLegendaPeq = new JLabel("(voto de legenda)");
        lblLegendaPeq.setBounds(490 + tla.getX(), tla.getY() + 480, 200, 40);
        lblLegendaPeq.setFont(new Font("Arial", Font.BOLD, 12));
        lblLegendaPeq.setVisible(false);
        lblLegendaPeq.setForeground(Color.black);
        painel.add(lblLegendaPeq);
        painel.setComponentZOrder(lblLegendaPeq, 0);

        lblLegendaGrande = newJLabelNuloLegenda(painel, "VOTO DE LEGENDA", 250 + tla.getX(), tla.getY() + 390, 500, 100);

        lblNulo = newJLabelNuloLegenda(painel, "VOTO NULO", 250 + tla.getX(), tla.getY() + 390, 500, 100);

        lblVotoBranco = new JLabel("VOTO EM BRANCO");
        lblVotoBranco.setBounds(180 + tla.getX(), tla.getY() + 300, 500, 100);
        lblVotoBranco.setFont(new Font("Arial", Font.PLAIN, 35));
        lblVotoBranco.setVisible(false);
        lblVotoBranco.setForeground(Color.black);
        painel.add(lblVotoBranco);
        painel.setComponentZOrder(lblVotoBranco, 0);
        //Aparece caso o número exista 
        lblNome = new JLabel("Nome: ");
        lblNome.setBounds(53 + tla.getX(), tla.getY() + 355, 200, 40);
        lblNome.setFont(new Font("Arial", Font.PLAIN, 17));
        lblNome.setForeground(Color.black);
        lblNome.setVisible(false);
        painel.add(lblNome);
        painel.setComponentZOrder(lblNome, 0);

        lblNomeCandidato = new JLabel("Nome do Candidato ");
        lblNomeCandidato.setBounds(135 + tla.getX(), tla.getY() + 355, 500, 40);
        lblNomeCandidato.setFont(new Font("Arial", Font.PLAIN, 17));
        lblNomeCandidato.setForeground(Color.black);
        lblNomeCandidato.setVisible(false);
        painel.add(lblNomeCandidato);
        painel.setComponentZOrder(lblNomeCandidato, 0);

        lblPartido = new JLabel("Partido: ");
        lblPartido.setBounds(53 + tla.getX(), tla.getY() + 415, 200, 40);
        lblPartido.setFont(new Font("Arial", Font.PLAIN, 17));
        lblPartido.setForeground(Color.black);
        lblPartido.setVisible(false);
        painel.add(lblPartido);
        painel.setComponentZOrder(lblPartido, 0);

        lblNomePartido = new JLabel("SIGLA ");
        lblNomePartido.setBounds(135 + tla.getX(), tla.getY() + 415, 500, 40);
        lblNomePartido.setFont(new Font("Arial", Font.PLAIN, 17));
        lblNomePartido.setForeground(Color.black);
        lblNomePartido.setVisible(false);
        painel.add(lblNomePartido);
        painel.setComponentZOrder(lblNomePartido, 0);

        //Instruções -- Só aparecem ao digitar 1 número ou voto branco
        lblInstrucoes1 = new JLabel("Aperte a tecla:");
        lblInstrucoes2 = new JLabel("    VERDE para CONFIRMAR este voto");
        lblInstrucoes3 = new JLabel("LARANJA para REINICIAR este voto");
        lblInstrucoes1.setBounds(55 + tla.getX(), tla.getY() + 388, 500, 200);
        lblInstrucoes2.setBounds(55 + tla.getX(), tla.getY() + 403, 500, 200);
        lblInstrucoes3.setBounds(55 + tla.getX(), tla.getY() + 418, 500, 200);
        lblInstrucoes1.setFont(new Font("Arial", Font.BOLD, 13));
        lblInstrucoes1.setForeground(Color.black);
        lblInstrucoes2.setFont(new Font("Arial", Font.BOLD, 13));
        lblInstrucoes2.setForeground(Color.black);
        lblInstrucoes3.setFont(new Font("Arial", Font.BOLD, 13));
        lblInstrucoes3.setForeground(Color.black);
        lblInstrucoes1.setVisible(false);
        lblInstrucoes2.setVisible(false);
        lblInstrucoes3.setVisible(false);
        painel.add(lblInstrucoes1);
        painel.add(lblInstrucoes2);
        painel.add(lblInstrucoes3);
        painel.setComponentZOrder(lblInstrucoes1, 0);
        painel.setComponentZOrder(lblInstrucoes2, 0);
        painel.setComponentZOrder(lblInstrucoes3, 0);
        //Linha acima das Instruções
        lblLinha = new JLabel();
        linhaTela = new ImageIcon(getClass().getResource(caminhoRecursos + "linhaTela.jpg"));
        lblLinha.setIcon(linhaTela);
        lblLinha.setBounds(50 + tla.getX(), tla.getY() + 475, linhaTela.getIconWidth(), linhaTela.getIconHeight());
        painel.add(lblLinha);
        painel.setComponentZOrder(lblLinha, 1);
        lblLinha.setVisible(false);
        //Labels das imagens dos candidados
        lblImgPrefeito = newJLabelImagem(painel, lblImgPrefeito, 477 + tla.getX(), tla.getY() + 207, largura, altura);
        lblImgVice = newJLabelImagem(painel, lblImgVice, 490 + tla.getX(), tla.getY() + 375, largura - 25, altura - 25);

        lblImgCandidato = newJLabelImagem(painel, lblImgCandidato, 477 + tla.getX(), tla.getY() + 207, largura, altura);

        //Espaços para os números
        lblNum1 = newJLabel(painel, lblNum1, 135 + tla.getX(), tla.getY() + 310, 30, 40);
        animation(lblNum1);
        lblNum2 = newJLabel(painel, lblNum2, 167 + tla.getX(), tla.getY() + 310, 30, 40);
        lblNum3 = newJLabel(painel, lblNum3, 199 + tla.getX(), tla.getY() + 310, 30, 40);
        lblNum4 = newJLabel(painel, lblNum4, 231 + tla.getX(), tla.getY() + 310, 30, 40);
        lblNum5 = newJLabel(painel, lblNum5, 263 + tla.getX(), tla.getY() + 310, 30, 40);
        //FIM
        lblFim.setFont(new Font("Arial", Font.PLAIN, 160));
        lblFim.setForeground(Color.BLACK);
        lblFim.setBounds(180 + tla.getX(), tla.getY() + 130, 500, 500);
        lblFim.setVisible(false);
        painel.add(lblFim);
        painel.setComponentZOrder(lblFim, 0);

        //Funcionalidades Botões
        lbl1.addMouseListener(new MListener(lbl1, " 1", new ImageIcon(getClass().getResource(caminhoRecursos + "n1_down.jpg")), new ImageIcon(getClass().getResource(caminhoRecursos + "n1.jpg"))));
        lbl2.addMouseListener(new MListener(lbl2, " 2", new ImageIcon(getClass().getResource(caminhoRecursos + "n2_down.jpg")), new ImageIcon(getClass().getResource(caminhoRecursos + "n2.jpg"))));
        lbl3.addMouseListener(new MListener(lbl3, " 3", new ImageIcon(getClass().getResource(caminhoRecursos + "n3_down.jpg")), new ImageIcon(getClass().getResource(caminhoRecursos + "n3.jpg"))));
        lbl4.addMouseListener(new MListener(lbl4, " 4", new ImageIcon(getClass().getResource(caminhoRecursos + "n4_down.jpg")), new ImageIcon(getClass().getResource(caminhoRecursos + "n4.jpg"))));
        lbl5.addMouseListener(new MListener(lbl5, " 5", new ImageIcon(getClass().getResource(caminhoRecursos + "n5_down.jpg")), new ImageIcon(getClass().getResource(caminhoRecursos + "n5.jpg"))));
        lbl6.addMouseListener(new MListener(lbl6, " 6", new ImageIcon(getClass().getResource(caminhoRecursos + "n6_down.jpg")), new ImageIcon(getClass().getResource(caminhoRecursos + "n6.jpg"))));
        lbl7.addMouseListener(new MListener(lbl7, " 7", new ImageIcon(getClass().getResource(caminhoRecursos + "n7_down.jpg")), new ImageIcon(getClass().getResource(caminhoRecursos + "n7.jpg"))));
        lbl8.addMouseListener(new MListener(lbl8, " 8", new ImageIcon(getClass().getResource(caminhoRecursos + "n8_down.jpg")), new ImageIcon(getClass().getResource(caminhoRecursos + "n8.jpg"))));
        lbl9.addMouseListener(new MListener(lbl9, " 9", new ImageIcon(getClass().getResource(caminhoRecursos + "n9_down.jpg")), new ImageIcon(getClass().getResource(caminhoRecursos + "n9.jpg"))));
        lbl0.addMouseListener(new MListener(lbl0, " 0", new ImageIcon(getClass().getResource(caminhoRecursos + "n0_down.jpg")), new ImageIcon(getClass().getResource(caminhoRecursos + "n0.jpg"))));
        //Para inserção com o teclado
        tecladoListener = new JTextField();
        tecladoListener.setBounds(0, 0, 0, 0);
        tecladoListener.addKeyListener(new TecladoListener(tecladoListener));
        painel.add(tecladoListener);
        super.setVisible(true);
        super.setAutoRequestFocus(true);
        super.toFront();

        try {
            connection = ConexaoBD.getConnection();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "        A urna não está conectada ao servidor.\nOs votos não serão computados, volte mais tarde.", "Sem conexão", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Layout layout = new Layout();
    }

    private JLabel newJLabel(JPanel painel, JLabel label, int x, int y, int width, int height) {
        label = new JLabel();
        label.setBorder(BorderFactory.createLineBorder(Color.black));
        label.setBounds(x, y, width, height);
        label.setFont(new Font("Arial", Font.PLAIN, 25));
        label.setForeground(Color.black);
        painel.add(label);
        painel.setComponentZOrder(label, 0);
        return label;
    }

    private JLabel newJLabelImagem(JPanel painel, JLabel label, int x, int y, int width, int height) {
        label = new JLabel();
        label.setBounds(x, y, width, height);
        label.setVisible(false);
        painel.add(label);
        painel.setComponentZOrder(label, 0);
        return label;
    }

    private JLabel newJLabelNuloLegenda(JPanel painel, String texto, int x, int y, int width, int height) {
        JLabel label = new JLabel(texto);
        label.setBounds(x, y, width, height);
        label.setFont(new Font("Arial", Font.PLAIN, 35));
        label.setVisible(false);
        label.setForeground(Color.black);
        painel.add(label);
        painel.setComponentZOrder(label, 0);
        return label;
    }

    private JLabel urnaLabels(JPanel painel, JLabel label, ImageIcon icone, int x, int y, int width, int height) {
        label = new JLabel();
        label.setIcon(icone);
        label.setBounds(x, y, width, height);
        painel.add(label);
        return label;
    }
}
