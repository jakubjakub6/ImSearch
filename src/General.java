import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class General {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					General window = new General();
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
	public General() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	//zmienna globalna
	BufferedImage picture, pictureCopy;
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 610, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("ImSearch 1.0");
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 614, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu mnPlik = new JMenu("Plik");
		menuBar.add(mnPlik);
		
		JLabel lblImage = new JLabel("image");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(0, 22, 300, 300);
		frame.getContentPane().add(lblImage);
		
		JLabel lblImagecopy = new JLabel("imageCopy");
		lblImagecopy.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagecopy.setBounds(301, 22, 300, 300);
		frame.getContentPane().add(lblImagecopy);
		
		
		JMenu mnObraz = new JMenu("Obraz");
		menuBar.add(mnObraz);
		
		JMenu mnOtworzKanal = new JMenu("Otworz kanal");
		if(picture == null) mnOtworzKanal.setEnabled(false);
		mnObraz.add(mnOtworzKanal);
		
		JMenuItem mntmOtworz = new JMenuItem("Otw\u00F3rz obraz");
		mntmOtworz.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				final JFileChooser img = new JFileChooser();
				int returnKey = img.showOpenDialog(null);
				if(returnKey == JFileChooser.APPROVE_OPTION) {
					try {
						picture = ImageIO.read(new File(img.getSelectedFile().toString()));
					} catch (IOException e) {}
					finally {
						lblImage.setIcon(new ImageIcon(picture.getScaledInstance(lblImage.getWidth(),lblImage.getHeight() , 0)));
						mnOtworzKanal.setEnabled(true);
					}
				}
				
				
			}
		});
		mnPlik.add(mntmOtworz);
		
		JMenuItem mntmZapisz = new JMenuItem("Zapisz wynik");
		mnPlik.add(mntmZapisz);
		
		JMenuItem mntmWyjscie = new JMenuItem("Wyj\u015Bcie");
		mnPlik.add(mntmWyjscie);
		
		JMenuItem mntmCzerwony = new JMenuItem("Czerwony");
		mntmCzerwony.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int width = picture.getWidth();
				int height = picture.getHeight();
				BufferedImage temp = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
				
				//temp = picture;
				Color color;
				
				
				int pixel, r, g, b;
				
				for(int i = 0; i<width; ++i) {
					for(int j=0;j<height; ++j) {
						pixel = picture.getRGB(i, j);
						color = new Color(pixel, true);
						
						r = color.getRed();
						g = color.getGreen();
						b = color.getBlue();
						
						g = 0;
						b = 0;
						
						color = new Color(r,g,b);
						pixel = color.getRGB();
						temp.setRGB(i, j, pixel);
					}
				}
				lblImagecopy.setIcon(new ImageIcon(temp.getScaledInstance(lblImage.getWidth(),lblImage.getHeight() , 0)));
			}
		});
		mnOtworzKanal.add(mntmCzerwony);
		
		JMenuItem mntmZielony = new JMenuItem("Zielony");
		mntmZielony.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int width = picture.getWidth();
				int height = picture.getHeight();
				BufferedImage temp = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
				
				//temp = picture;
				Color color;
				
				
				int pixel, r, g, b;
				
				for(int i = 0; i<width; ++i) {
					for(int j=0;j<height; ++j) {
						pixel = picture.getRGB(i, j);
						color = new Color(pixel, true);
						
						r = color.getRed();
						g = color.getGreen();
						b = color.getBlue();
						
						r = 0;
						b = 0;
						
						color = new Color(r,g,b);
						pixel = color.getRGB();
						temp.setRGB(i, j, pixel);
					}
				}
				lblImagecopy.setIcon(new ImageIcon(temp.getScaledInstance(lblImage.getWidth(),lblImage.getHeight() , 0)));
			}
		});
		mnOtworzKanal.add(mntmZielony);
		
		JMenuItem mntmNiebieski = new JMenuItem("Niebieski");
		mntmNiebieski.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int width = picture.getWidth();
				int height = picture.getHeight();
				BufferedImage temp = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
				
				//temp = picture;
				Color color;
				
				
				int pixel, r, g, b;
				
				for(int i = 0; i<width; ++i) {
					for(int j=0;j<height; ++j) {
						pixel = picture.getRGB(i, j);
						color = new Color(pixel, true);
						
						r = color.getRed();
						g = color.getGreen();
						b = color.getBlue();
						
						r = 0;
						g = 0;
						
						color = new Color(r,g,b);
						pixel = color.getRGB();
						temp.setRGB(i, j, pixel);
					}
				}
				lblImagecopy.setIcon(new ImageIcon(temp.getScaledInstance(lblImage.getWidth(),lblImage.getHeight() , 0)));
			}
		});
		mnOtworzKanal.add(mntmNiebieski);
		
		JMenuItem mntmModyfikujPaleteRgb = new JMenuItem("Modyfikuj palet\u0119 RGB");
		mnObraz.add(mntmModyfikujPaleteRgb);
		
		JMenu mnFiltry = new JMenu("Filtry");
		menuBar.add(mnFiltry);
		
		JMenu mnPomoc = new JMenu("Pomoc");
		menuBar.add(mnPomoc);
		
		JMenuItem mntmOProgramie = new JMenuItem("O programie");
		mnPomoc.add(mntmOProgramie);
		
	}
}
