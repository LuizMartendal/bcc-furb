package view;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Application {

	private JFrame frame;
	private JTextArea textAreaMessages;
	private JLabel lblStatus;
	private JTextArea textAreaEditor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application window = new Application();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Application() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Compilador");
		frame.getContentPane().setMinimumSize(new Dimension(910, 600));
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.75);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JPanel upPanel = new JPanel();
		splitPane.setLeftComponent(upPanel);
		upPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneEditor = new JScrollPane();
		upPanel.add(scrollPaneEditor, BorderLayout.CENTER);
		scrollPaneEditor.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneEditor.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		this.textAreaEditor = new JTextArea();
		scrollPaneEditor.setViewportView(this.textAreaEditor);
		this.textAreaEditor.setBorder(new NumberedBorder());
		
		JToolBar barraDeFerramentas = new JToolBar();
		barraDeFerramentas.setPreferredSize(new Dimension(900, 70));
		upPanel.add(barraDeFerramentas, BorderLayout.NORTH);
		
		JButton btnNew = new JButton("novo [crtl+n]");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cleanNewFile();
			}
		});
		btnNew.setFocusable(false);
		btnNew.setMaximumSize(new Dimension(100, 60));
		btnNew.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNew.setHorizontalTextPosition(SwingConstants.CENTER);
		ImageIcon icon = new ImageIcon(Application.class.getResource("/novo - recortar.png"));
		btnNew.setIcon(resizeIcon(icon, 25, 25));
		barraDeFerramentas.add(btnNew);
		
		JButton btnOpen = new JButton("abrir [crtl+o]");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openNewFile();
			}
		});
		btnOpen.setFocusable(false);
		btnOpen.setMaximumSize(new Dimension(100, 60));
		btnOpen.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnOpen.setHorizontalTextPosition(SwingConstants.CENTER);
		icon = new ImageIcon(Application.class.getResource("/abrir.png"));
		btnOpen.setIcon(resizeIcon(icon, 25, 25));
		barraDeFerramentas.add(btnOpen);
		
		JButton btnSave = new JButton("salvar [crtl+s]");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveFile();
			}
		});
		btnSave.setFocusable(false);
		btnSave.setMaximumSize(new Dimension(100, 60));
		btnSave.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSave.setHorizontalTextPosition(SwingConstants.CENTER);
		icon = new ImageIcon(Application.class.getResource("/salvar.png"));
		btnSave.setIcon(resizeIcon(icon, 25, 25));
		barraDeFerramentas.add(btnSave);
		
		JButton btnCopy = new JButton("copiar [crtl+c]");
		btnCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				copyText();
			}
		});
		btnCopy.setFocusable(false);
		btnCopy.setMaximumSize(new Dimension(100, 60));
		btnCopy.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCopy.setHorizontalTextPosition(SwingConstants.CENTER);
		icon = new ImageIcon(Application.class.getResource("/copiar.png"));
		btnCopy.setIcon(resizeIcon(icon, 25, 25));
		barraDeFerramentas.add(btnCopy);
		
		JButton btnPaste = new JButton("colar [crtl+v]");
		btnPaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasteText();
			}
		});
		btnPaste.setFocusable(false);
		btnPaste.setMaximumSize(new Dimension(100, 60));
		btnPaste.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPaste.setHorizontalTextPosition(SwingConstants.CENTER);
		icon = new ImageIcon(Application.class.getResource("/colar.png"));
		btnPaste.setIcon(resizeIcon(icon, 25, 25));
		barraDeFerramentas.add(btnPaste);
		
		JButton btnCut = new JButton("recortar [crtl+x]");
		btnCut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cutText();
			}
		});
		btnCut.setFocusable(false);
		btnCut.setMaximumSize(new Dimension(110, 60));
		btnCut.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCut.setHorizontalTextPosition(SwingConstants.CENTER);
		icon = new ImageIcon(Application.class.getResource("/novo - recortar.png"));
		btnCut.setIcon(resizeIcon(icon, 25, 25));
		barraDeFerramentas.add(btnCut);
		
		JButton btnCompile = new JButton("compilar [F7]");
		btnCompile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				compile();
			}
		});
		btnCompile.setFocusable(false);
		btnCompile.setMaximumSize(new Dimension(100, 60));
		btnCompile.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCompile.setHorizontalTextPosition(SwingConstants.CENTER);
		icon = new ImageIcon(Application.class.getResource("/compile.png"));
		btnCompile.setIcon(resizeIcon(icon, 25, 25));
		barraDeFerramentas.add(btnCompile);
		
		JButton btnTeam = new JButton("equipe [F1]");
		btnTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTeam();
			}
		});
		btnTeam.setFocusable(false);
		btnTeam.setMaximumSize(new Dimension(100, 60));
		btnTeam.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnTeam.setHorizontalTextPosition(SwingConstants.CENTER);
		icon = new ImageIcon(Application.class.getResource("/equipe.png"));
		btnTeam.setIcon(resizeIcon(icon, 25, 25));
		barraDeFerramentas.add(btnTeam);
		
		JPanel downPanel = new JPanel();
		splitPane.setRightComponent(downPanel);
		downPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPaneMessages = new JScrollPane();
		downPanel.add(scrollPaneMessages, BorderLayout.CENTER);
		scrollPaneMessages.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneMessages.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		this.textAreaMessages = new JTextArea();
		this.textAreaMessages.setEditable(false);
		scrollPaneMessages.setViewportView(this.textAreaMessages);
		
		JPanel status = new JPanel();
		status.setMinimumSize(new Dimension(900, 25));
		status.setPreferredSize(new Dimension(900, 25));
		downPanel.add(status, BorderLayout.SOUTH);
		SpringLayout sl_status = new SpringLayout();
		status.setLayout(sl_status);
		
		this.lblStatus = new JLabel("novo");
		sl_status.putConstraint(SpringLayout.NORTH, this.lblStatus, 0, SpringLayout.NORTH, status);
		sl_status.putConstraint(SpringLayout.WEST, this.lblStatus, 10, SpringLayout.WEST, status);
		sl_status.putConstraint(SpringLayout.EAST, this.lblStatus, -10, SpringLayout.EAST, status);
		this.lblStatus.setPreferredSize(new Dimension(50, 20));
		status.add(this.lblStatus);
		frame.setMinimumSize(new Dimension(910, 600));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String newDocument = "newDocument";
        KeyStroke newDocumentKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK);
        btnNew.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(newDocumentKeyStroke, newDocument);
        btnNew.getActionMap().put(newDocument, (Action) new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				cleanNewFile();
            }
        });
        
        String openDocument = "openDocument";
        KeyStroke openDocumentKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK);
        btnOpen.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(openDocumentKeyStroke, openDocument);
        btnOpen.getActionMap().put(openDocument, (Action) new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				openNewFile();
            }
        });
        
        String saveDocument = "saveDocument";
        KeyStroke saveDocumentKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK);
        btnSave.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(saveDocumentKeyStroke, saveDocument);
        btnSave.getActionMap().put(saveDocument, (Action) new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				saveFile();
            }
        });
        
        String compileDocument = "compileDocument";
        KeyStroke compileDocumentKeyStroke = KeyStroke.getKeyStroke("F7");
        btnCompile.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(compileDocumentKeyStroke, compileDocument);
        btnCompile.getActionMap().put(compileDocument, (Action) new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				compile();
            }
        });
        
        String showTeam = "showTeam";
        KeyStroke showTeamKeyStroke = KeyStroke.getKeyStroke("F1");
        btnTeam.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(showTeamKeyStroke, showTeam);
        btnTeam.getActionMap().put(showTeam, (Action) new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				showTeam();
            }
        });
		
	}
	
	private void setFilePath(String path) {
		this.lblStatus.setText(path);
	}
	
	private void cleanNewFile() {
		this.textAreaEditor.setText("");
		this.textAreaMessages.setText("");;
		this.setFilePath("novo");
	}
	
	private void openNewFile() {
		JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
        	String file = fileChooser.getSelectedFile().getAbsoluteFile().toString();
        	textAreaMessages.setText("");
        	
        	try {
        		textAreaEditor.setText("");
                List<String> lines = Files.readAllLines(Paths.get(file));
                for (String line : lines) {
                	textAreaEditor.append(line + "\n");
                }
                this.setFilePath(file);
            } catch (Exception e) {}
        }
	}
	
	private void saveFile() {
		File file = new File(this.lblStatus.getText());
		textAreaMessages.setText("");
		if (file.exists()) {
			this.updateFile(file.getAbsolutePath());
		} else {
			this.saveNewFile();
		}
	}
	
	private void saveNewFile() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int result = fileChooser.showOpenDialog(frame);
		
		if (result == JFileChooser.APPROVE_OPTION) {
			String path = fileChooser.getSelectedFile().getAbsoluteFile().toString();
			if (!path.endsWith(".txt")) {
				path += ".txt";
			}
			this.updateFile(path);
		}
	}
	
	private void updateFile(String path) {
		try {
			Files.write(Paths.get(path), textAreaEditor.getText().getBytes());
			this.setFilePath(path);
		} catch (Exception e) {}
	}
	
	private void copyText() {
		String textToCopy = textAreaEditor.getSelectedText();
        StringSelection stringSelection = new StringSelection(textToCopy);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
	}
	
	private void pasteText() {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable content = clipboard.getContents(null);
		String text = "";
		try {
			text = (String) content.getTransferData(DataFlavor.stringFlavor);
		} catch (Exception e) {}
		int position = textAreaEditor.getCaretPosition();
		textAreaEditor.insert(text, position);
	}
	
	private void cutText() {
		this.copyText();
		int start = textAreaEditor.getSelectionStart();
        int end = textAreaEditor.getSelectionEnd();
        textAreaEditor.replaceRange("", start, end);
	}
	
	private void compile() {
		textAreaMessages.setText("Compilação de programas ainda não foi implementada");
	}
	
	private void showTeam() {
		textAreaMessages.setText("Integrantes: Augusto Juan Dalprá Arraga, Daniel Krüger e Luiz Henrique Martendal");
	}
	
	private static Icon resizeIcon(Icon icon, int width, int height) {
        if (icon instanceof ImageIcon) {
            Image image = ((ImageIcon) icon).getImage();
            Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(resizedImage);
        }
        return icon;
    }
}
