package ca.cgjennings.apps.arkham.dialog;

import ca.cgjennings.apps.arkham.TextEncoding;
import ca.cgjennings.apps.arkham.StrangeEons;
import ca.cgjennings.apps.arkham.StrangeEonsEditor;
import ca.cgjennings.apps.arkham.plugins.BundleInstaller;
import ca.cgjennings.apps.arkham.plugins.PluginRoot;
import ca.cgjennings.apps.arkham.plugins.catalog.CatalogID;
import ca.cgjennings.apps.arkham.project.Member;
import ca.cgjennings.apps.arkham.project.Project;
import ca.cgjennings.apps.arkham.project.ProjectUtilities;
import ca.cgjennings.graphics.ImageUtilities;
import static ca.cgjennings.graphics.filters.AbstractImageFilter.*;
import ca.cgjennings.graphics.filters.BrightnessContrastFilter;
import ca.cgjennings.platform.PlatformSupport;
import ca.cgjennings.ui.DocumentEventAdapter;
import ca.cgjennings.ui.JFileField.FileType;
import ca.cgjennings.ui.JIconDrop;
import ca.cgjennings.ui.JUtilities;
import ca.cgjennings.ui.theme.Theme;
import gamedata.Expansion;
import gamedata.ExpansionSymbolTemplate;
import gamedata.Game;
import gamedata.SymbolVariantUtilities;
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import static resources.Language.string;
import resources.ResourceKit;

/**
 * Guides the user through the process of creating and registering a custom
 * expansion. A plug-in can be generated and the expansion will be added
 * dynamically to those available.
 *
 * @author Chris Jennings <https://cgjennings.ca/contact>
 * @since 3.00
 */
@SuppressWarnings("serial")
public class EndUserExpansion extends javax.swing.JDialog {

    /**
     * Creates new form EndUserExpansion
     */
    public EndUserExpansion(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        backBtn.setIcon(ResourceKit.getIcon("ui/go-back.png"));
        nextBtn.setIcon(ResourceKit.getIcon("ui/continue.png"));

        getRootPane().setDefaultButton(okBtn);

        if (PlatformSupport.PLATFORM_IS_MAC) {
            cancelBtn.setVisible(false);
        } else {
            cancelBtn2.setVisible(false);
        }

        nameField.getDocument().addDocumentListener(new DocumentEventAdapter() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                p1UpdateButtons();
            }
        });

        saveField.setFileType(FileType.GENERIC_SAVE);
        saveField.setGenericFileTypeDescription(string("eue-l-save-desc"));
        saveField.setGenericFileTypeExtensions("seext");

        loadPage(1);
        p1UpdateButtons();

        // by default, select the game of the current component (if any)
        StrangeEonsEditor ed = StrangeEons.getWindow().getActiveEditor();
        if (ed != null && ed.getGameComponent() != null) {
            Game g = Game.get(ed.getGameComponent().getSettings().get(Game.GAME_SETTING_KEY));
            if (g != null) {
                gameCombo.setSelectedItem(g);
            }
        }

        // since the user is most likely about to type the expansion name,
        // select the default name and give the name field focus;
        // the blinking caret will also help draw the user's locus of attention
        EventQueue.invokeLater(() -> {
            nameField.selectAll();
            nameField.requestFocusInWindow();
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        banner = new javax.swing.JLabel();
        headerAndPagePanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cardPanel = new javax.swing.JPanel();
        page1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        gameCombo = new ca.cgjennings.ui.JGameCombo();
        jLabel4 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        page2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        symbolScroll = new javax.swing.JScrollPane();
        centeringPanel = new javax.swing.JPanel();
        symbolPanel = new javax.swing.JPanel();
        generatorPanel = new javax.swing.JPanel();
        generateLabel = new javax.swing.JLabel();
        generatorDrop = new ca.cgjennings.ui.JIconDrop();
        page3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        saveField = new ca.cgjennings.ui.JFileField();
        backNextPanel = new javax.swing.JPanel();
        cancelBtn = new javax.swing.JButton();
        cancelBtn2 = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();
        okBtn = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(string( "eue-l-title" )); // NOI18N

        banner.setBackground(java.awt.Color.darkGray);
        banner.setIcon(resources.ResourceKit.createBleedBanner("new-expansion.jpg")
        );
        banner.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        banner.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, java.awt.Color.gray));
        banner.setOpaque(true);
        getContentPane().add(banner, java.awt.BorderLayout.WEST);

        headerAndPagePanel.setLayout(new java.awt.BorderLayout());

        headerPanel.setBackground(UIManager.getColor(Theme.MESSAGE_BACKGROUND));
        headerPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(128, 128, 128)));
        headerPanel.setForeground(UIManager.getColor(Theme.MESSAGE_FOREGROUND));

        jLabel10.setFont(jLabel10.getFont().deriveFont(jLabel10.getFont().getStyle() | java.awt.Font.BOLD, jLabel10.getFont().getSize()+3));
        jLabel10.setText(string("eue-l-heading")); // NOI18N

        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getSize()+1f));
        jLabel1.setText(string( "eue-l-info1" )); // NOI18N

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel1))
                .addContainerGap(171, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        headerAndPagePanel.add(headerPanel, java.awt.BorderLayout.NORTH);

        cardPanel.setLayout(new java.awt.CardLayout());

        jLabel2.setText(string( "eue-l-info4" )); // NOI18N

        gameCombo.setMaximumRowCount(12);
        gameCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameComboActionPerformed(evt);
            }
        });

        jLabel4.setText(string( "eue-l-info2" )); // NOI18N

        nameField.setColumns(30);
        nameField.setText(string( "eue-l-title" )); // NOI18N
        nameField.selectAll();

        jLabel5.setText(string( "eue-l-info3" )); // NOI18N

        javax.swing.GroupLayout page1Layout = new javax.swing.GroupLayout(page1);
        page1.setLayout(page1Layout);
        page1Layout.setHorizontalGroup(
            page1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(page1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(page1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addGroup(page1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(page1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(gameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(200, Short.MAX_VALUE))
        );
        page1Layout.setVerticalGroup(
            page1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(page1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(1, 1, 1)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(181, Short.MAX_VALUE))
        );

        cardPanel.add(page1, "p1");

        jLabel3.setText(string( "eue-l-info5" )); // NOI18N

        symbolScroll.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.gray));
        symbolScroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        centeringPanel.setLayout(new java.awt.BorderLayout());

        symbolPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 16, 5));
        centeringPanel.add(symbolPanel, java.awt.BorderLayout.CENTER);

        symbolScroll.setViewportView(centeringPanel);

        generatorPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(string( "eue-b-generate" ))); // NOI18N

        generateLabel.setText(string( "eue-l-nogen-info" )); // NOI18N
        generateLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        generatorDrop.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                generatorDropPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout generatorPanelLayout = new javax.swing.GroupLayout(generatorPanel);
        generatorPanel.setLayout(generatorPanelLayout);
        generatorPanelLayout.setHorizontalGroup(
            generatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generatorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(generatorDrop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(generateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        generatorPanelLayout.setVerticalGroup(
            generatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generatorPanelLayout.createSequentialGroup()
                .addGroup(generatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(generateLabel)
                    .addComponent(generatorDrop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout page2Layout = new javax.swing.GroupLayout(page2);
        page2.setLayout(page2Layout);
        page2Layout.setHorizontalGroup(
            page2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(page2Layout.createSequentialGroup()
                .addGroup(page2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(page2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(generatorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(page2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(symbolScroll))
                    .addGroup(page2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );
        page2Layout.setVerticalGroup(
            page2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(page2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(symbolScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(generatorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cardPanel.add(page2, "p2");

        jLabel6.setText(string( "eue-l-info6" )); // NOI18N
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel7.setText(string( "eue-l-info7" )); // NOI18N

        jLabel8.setText(string( "eue-l-save" )); // NOI18N

        jLabel9.setFont(jLabel9.getFont().deriveFont(jLabel9.getFont().getSize()-1f));
        jLabel9.setText(string( "eue-l-no-save" )); // NOI18N

        javax.swing.GroupLayout page3Layout = new javax.swing.GroupLayout(page3);
        page3.setLayout(page3Layout);
        page3Layout.setHorizontalGroup(
            page3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(page3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(page3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addGroup(page3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(page3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveField, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                            .addComponent(jLabel9))))
                .addContainerGap())
        );
        page3Layout.setVerticalGroup(
            page3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, page3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel9)
                .addGap(34, 34, 34)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        cardPanel.add(page3, "p3");

        headerAndPagePanel.add(cardPanel, java.awt.BorderLayout.CENTER);

        cancelBtn.setText(string( "cancel" )); // NOI18N
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        cancelBtn2.setText(string("cancel")); // NOI18N
        cancelBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        backBtn.setText(string("backpage")); // NOI18N
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        nextBtn.setText(string("nextpage")); // NOI18N
        nextBtn.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });

        okBtn.setText(string("finish")); // NOI18N
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });

        errorLabel.setForeground(java.awt.Color.red);
        errorLabel.setText(" ");

        javax.swing.GroupLayout backNextPanelLayout = new javax.swing.GroupLayout(backNextPanel);
        backNextPanel.setLayout(backNextPanelLayout);
        backNextPanelLayout.setHorizontalGroup(
            backNextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backNextPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backNextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(backNextPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                        .addComponent(cancelBtn2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(backBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(okBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelBtn))
                    .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        backNextPanelLayout.setVerticalGroup(
            backNextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backNextPanelLayout.createSequentialGroup()
                .addComponent(errorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(backNextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn2)
                    .addComponent(okBtn)
                    .addComponent(nextBtn)
                    .addComponent(backBtn)
                    .addComponent(cancelBtn))
                .addContainerGap())
        );

        headerAndPagePanel.add(backNextPanel, java.awt.BorderLayout.SOUTH);

        getContentPane().add(headerAndPagePanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadPage(int p) {
        page = p;
        backBtn.setEnabled(p > 1);
        nextBtn.setEnabled(p < 3);

        if (p == 2) {
            createIconDrops(gameCombo.getSelectedItem());
        } else if (p == 3) {
            Project proj = StrangeEons.getWindow().getOpenProject();
            if (proj != null) {
                String fieldText = ResourceKit.makeStringFileSafe(nameField.getText()) + ".seext";
                if (!fieldText.equals(filledInSaveFieldWith)) {
                    saveField.setText(
                            new File(proj.getFile(), fieldText)
                                    .getAbsolutePath()
                    );
                }
            }
        }

        ((CardLayout) cardPanel.getLayout()).show(cardPanel, "p" + p);
    }
    private int page = 1;
    private String filledInSaveFieldWith;

	private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
            dispose();
	}//GEN-LAST:event_cancelActionPerformed

	private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtnActionPerformed
            Game game = gameCombo.getSelectedItem();
            String name = nameField.getText().trim();
            String code = Expansion.generateEndUserIdentifier(game);
            BufferedImage[] images = createExpansionImages();
            String bundleName = ResourceKit.makeStringFileSafe(name.replace(" ", "")) + ".seext";
            File installFile = ProjectUtilities.getAvailableFile(new File(BundleInstaller.PLUGIN_FOLDER, bundleName));
            File saveFile = saveField.getFile();
            if (saveFile != null && saveFile.isDirectory()) {
                saveFile = new File(saveFile, bundleName);
                saveFile = ProjectUtilities.getAvailableFile(saveFile);
            }

            try {
                JUtilities.showWaitCursor(this);
                File plugin = createPlugin(game, code, name, images);
                ProjectUtilities.copyFile(plugin, installFile);
                if (saveFile != null) {
                    ProjectUtilities.copyFile(plugin, saveFile);
                    Project p = StrangeEons.getWindow().getOpenProject();
                    if (p != null) {
                        Member projLoc = p.findMember(saveFile);
                        if (projLoc != null && projLoc != p) {
                            projLoc.getParent().synchronize();
                        }
                    }
                }
                installExpansion(game, code, name, images);
                dispose();
            } catch (Exception e) {
                ErrorDialog.displayError(string("eue-error"), e);
            } finally {
                JUtilities.hideWaitCursor(this);
            }
	}//GEN-LAST:event_okBtnActionPerformed

	private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
            loadPage(page - 1);
	}//GEN-LAST:event_backBtnActionPerformed

	private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
            loadPage(page + 1);
	}//GEN-LAST:event_nextBtnActionPerformed

	private void gameComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gameComboActionPerformed
            Game g = gameCombo.getSelectedItem();
            if (g != null) {
                createIconDrops(g);
            }
            p1UpdateButtons();
	}//GEN-LAST:event_gameComboActionPerformed

	private void generatorDropPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_generatorDropPropertyChange
            if (evt.getPropertyName().equals(JIconDrop.SELECTED_IMAGE_CHANGED_PROPERTY)) {

                BufferedImage template = (BufferedImage) evt.getNewValue();
                Game g = gameCombo.getSelectedItem();
                if (template == null || g == null) {
                    return;
                }

                try {
                    JUtilities.showWaitCursor(this);

                    // generate the symbols
                    if (g.getSymbolTemplate().canGenerateVariantsAutomatically()) {
                        ExpansionSymbolTemplate est = g.getSymbolTemplate();
                        for (int i = 1; i < drops.length; ++i) {
                            drops[i].drop.setImage(est.generateVariant(template, i - 1));
                        }
                    }

                    // generate an icon
                    drops[0].drop.setImage(generateIcon(template));
                } finally {
                    JUtilities.hideWaitCursor(this);
                }
            }
	}//GEN-LAST:event_generatorDropPropertyChange

    private static BufferedImage generateIcon(BufferedImage template) {
        int w = template.getWidth();
        int h = template.getHeight();

        // use the same alpha channel as an extracted symbol, but use the
        // original image colours
        BufferedImage alphaSource = SymbolVariantUtilities.extractSymbol(template);
        int[] rgbPix = getARGB(template, 0, 0, w, h, null);
        int[] alphaPix = getARGB(alphaSource, 0, 0, w, h, null);
        for (int i = 0; i < rgbPix.length; ++i) {
            rgbPix[i] = (rgbPix[i] & 0xff_ffff) | (alphaPix[i] & 0xff00_0000);
        }

        BufferedImage icon = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB_PRE);
        setARGB(icon, 0, 0, w, h, rgbPix);
        icon = ImageUtilities.trim(icon);

        // Before shrinking a large input image down to icon size, increase the
        // contrast and sharpen the source image. This helps keep the icon from
        // becoming indistinct and blurry looking at small sizes.
        if (icon.getWidth() >= ICON_WIDTH * 2 || icon.getHeight() >= ICON_HEIGHT * 2) {
            BufferedImage highContrast = new BrightnessContrastFilter(0f, 0.25f).filter(icon, null);
            ConvolveOp sharpenFilter = new ConvolveOp(
                    new Kernel(3, 3, new float[]{
                0.00f, -0.50f, 0.00f,
                -0.50f, 3.00f, -0.50f,
                0.00f, -0.50f, 0.00f
            }), ConvolveOp.EDGE_NO_OP, null
            );
            sharpenFilter.filter(highContrast, icon);
        }

        // Scale the input image down to a size 2 less than the final icon size
        // in each dimension. This leaves space for the glow effect we will add.
        float scale = ImageUtilities.idealCoveringScaleForImage(ICON_WIDTH - 2, ICON_HEIGHT - 2, w, h);
        icon = ImageUtilities.resample(icon, scale);
        icon = ImageUtilities.center(icon, ICON_WIDTH - 2, ICON_HEIGHT - 2);

        // This is where the final image will go.
        BufferedImage out = new BufferedImage(ICON_WIDTH, ICON_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        // This has a 1-pixel margin around the outside to allow for blur filter not blurring edge pixels
        BufferedImage glowImage = new BufferedImage(ICON_WIDTH + 2, ICON_HEIGHT + 2, BufferedImage.TYPE_INT_ARGB_PRE);

        // Stamp the icon image down in the glow effect colour.
        Graphics2D g = glowImage.createGraphics();
        try {
            g.setComposite(AlphaComposite.SrcOver);
            // This is at (2,2) because: it is smaller than the final
            // image size (+1) and the glow image has a 1 pixel margin (+1)
            g.drawImage(icon, 2, 2, null);
            g.setComposite(AlphaComposite.SrcIn);
            g.setColor(new Color(0xff_ffbe));
            g.fillRect(2, 2, ICON_WIDTH - 2, ICON_HEIGHT - 2);
        } finally {
            g.dispose();
        }

        // Blur the stamp to create the glow image.
        ConvolveOp blur = new ConvolveOp(
                new Kernel(3, 3, new float[]{
            1 / 9f, 1 / 9f, 1 / 9f,
            1 / 9f, 1 / 9f, 1 / 9f,
            1 / 9f, 1 / 9f, 1 / 9f
        }),
                ConvolveOp.EDGE_ZERO_FILL,
                null
        );
        BufferedImage glowTemp = blur.filter(glowImage, null);
        blur.filter(glowTemp, glowImage);
        blur.filter(glowImage, glowTemp);
        blur.filter(glowTemp, glowImage);

        // create the final image by stacking the glow image and icon image
        g = out.createGraphics();
        try {
            // At (-1,-1) due to the 1 pixel border
            g.drawImage(glowImage, -1, -1, null);
            g.drawImage(glowImage, -1, -1, null);
            // At (1,1) since it is smaller by 2 in both dimensions.
            g.drawImage(icon, 1, 1, null);
        } finally {
            g.dispose();
        }

        return out;
    }

    private void p1UpdateButtons() {
        Game g = gameCombo.getSelectedItem();
        boolean canGen = false;
        if (g == null) {
            nextBtn.setEnabled(false);
            okBtn.setEnabled(false);
        } else {
            String t = nameField.getText().trim();
            nextBtn.setEnabled(!t.isEmpty());
            okBtn.setEnabled(!t.isEmpty());
            errorLabel.setText(t.isEmpty() ? string("eue-l-err-name") : " ");

            canGen = g.getSymbolTemplate().canGenerateVariantsAutomatically();
        }

        generateLabel.setText(string(canGen ? "eue-l-gen-info" : "eue-l-nogen-info"));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JPanel backNextPanel;
    private javax.swing.JLabel banner;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton cancelBtn2;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JPanel centeringPanel;
    private javax.swing.JLabel errorLabel;
    private ca.cgjennings.ui.JGameCombo gameCombo;
    private javax.swing.JLabel generateLabel;
    private ca.cgjennings.ui.JIconDrop generatorDrop;
    private javax.swing.JPanel generatorPanel;
    private javax.swing.JPanel headerAndPagePanel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton nextBtn;
    private javax.swing.JButton okBtn;
    private javax.swing.JPanel page1;
    private javax.swing.JPanel page2;
    private javax.swing.JPanel page3;
    private ca.cgjennings.ui.JFileField saveField;
    private javax.swing.JPanel symbolPanel;
    private javax.swing.JScrollPane symbolScroll;
    // End of variables declaration//GEN-END:variables

    private void createIconDrops(Game g) {
        // already have drops for this game, don't recreate so that we don't
        //    lose existing user selections
        if (g == dropsShowingForGame) {
            return;
        }

        ExpansionSymbolTemplate t = g.getSymbolTemplate();

        drops = new SymbolPanel[t.getVariantCount() + 1];
        drops[0] = new SymbolPanel(string("expsym-desc-icon"), null);
        drops[0].drop.setImage(ResourceKit.getImage("icons/un-expansion-icon.png"));
        drops[0].drop.setBackgroundPaint(new Color(0x8a_8a8a));

        for (int i = 1; i < drops.length; ++i) {
            drops[i] = new SymbolPanel(t.getVariantName(i - 1), t.getVariantIcon(i - 1));
            drops[i].drop.setImage(t.getDefaultSymbol(i - 1));
            Paint backdrop = t.getDesignBackdropForVariant(i - 1);
            if (backdrop != null) {
                drops[i].drop.setBackgroundPaint(backdrop);
            }
        }

        symbolPanel.removeAll();
        for (int i = 0; i < drops.length; ++i) {
            symbolPanel.add(drops[i]);
        }

        dropsShowingForGame = g;
    }
    private SymbolPanel[] drops;
    private Game dropsShowingForGame;

    private static class SymbolPanel extends JPanel {

        JIconDrop drop;
        JLabel label;

        public SymbolPanel(String text, Icon icon) {
            setLayout(new BorderLayout(0, 4));
            drop = new JIconDrop();
            drop.setPreferredSize(new Dimension(96, 96));
            label = new JLabel(text);
            label.setFont(label.getFont().deriveFont(label.getFont().getSize2D() - 1f));
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setIcon(icon);
            add(drop, BorderLayout.CENTER);
            add(label, BorderLayout.SOUTH);
        }
    }

    @SuppressWarnings("deprecated")
    private void installExpansion(Game g, String code, String name, BufferedImage[] images) {
        Expansion.register(g, code, name, name, images[0], Arrays.copyOfRange(images, 1, images.length - 1));
    }

    private String settingSafe(String s) {
        return s.replace("\\", "\\\\").replace("\n", "\\n");
    }

    private String literalSafe(String s) {
        return s.replace("\\", "\\\\").replace("\n", "\\n").replace("'", "\\'");
    }

    /**
     * Creates a plug-in for the expansion in a temporary file.
     *
     * @return the file containing the plug-in
     */
    private File createPlugin(Game g, String code, String name, BufferedImage[] images) throws IOException {
        File z = File.createTempFile("se-eue-", ".tmp");
        z.deleteOnExit();

        String path = "resources/" + code + "/";
        String scriptName = ResourceKit.makeStringFileSafe(name.replace(' ', '-')).toLowerCase(Locale.CANADA) + ".js";

        try (JarOutputStream jar = new JarOutputStream(new FileOutputStream(z))) {

            String rootFile = "id = " + new CatalogID() + '\n'
                    + "priority = EXPANSION\n"
                    + "catalog-name = " + settingSafe(name) + '\n'
                    + "catalog-description = " + string("eue-l-plug-desc") + '\n'
                    + "catalog-game = " + settingSafe(g.getCode()) + '\n'
                    + '\n' + PluginRoot.decoratePluginIdentifier("script:" + path + scriptName);

            addString(jar, "eons-plugin", rootFile);

            for (int i = 0; i < images.length; ++i) {
                addImage(jar, path + (i == 0 ? "icon.png" : "symbol" + i + ".png"), images[i]);
            }

            StringBuilder script = new StringBuilder(
                    "useLibrary('extension');\nuseLibrary('imageutils');\n\n"
                    + "const name = new java.lang.String( '" + literalSafe(name) + "' );\n"
                    + "const game = Game.get('" + literalSafe(g.getCode()) + "');\n\n"
                    + "function getName() { return name; }\n"
                    + "function getDescription() { return @eue_l_plug_desc; }\n\n"
                    + "if( game != null ) Expansion.register(\n\tgame, '" + literalSafe(code) + "', name, name,\n"
                    + "\tImageUtils.get('" + literalSafe(code) + "/icon.png'),\n\t[\n"
            );
            for (int i = 1; i < images.length; ++i) {
                if (i > 1) {
                    script.append(",\n");
                }
                script.append("\t\tImageUtils.get('").append(literalSafe(code)).append("/symbol").append(i).append(".png')");
            }
            script.append("\n\t]\n);");

            addString(jar, path + scriptName, script.toString());

        }

        return z;
    }

    private void addString(JarOutputStream z, String path, String s) throws IOException {
        ZipEntry e = new ZipEntry(path);
        z.putNextEntry(e);
        z.write(s.getBytes(TextEncoding.SOURCE_CODE));
        z.closeEntry();
    }

    private void addImage(JarOutputStream z, String path, BufferedImage bi) throws IOException {
        ZipEntry e = new ZipEntry(path);
        z.putNextEntry(e);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write(bi, "png", out);
        z.write(out.toByteArray());
        z.closeEntry();
    }

    /**
     * Processes the dropped images to make them conform to the standard sizing
     * conventions.
     *
     * @return possibly resized versions of the user-supplied images
     */
    private BufferedImage[] createExpansionImages() {
        BufferedImage[] out = new BufferedImage[drops.length];

        BufferedImage icon = drops[0].drop.getImage();
        if (icon.getWidth() != ICON_WIDTH || icon.getHeight() != ICON_HEIGHT) {
            float scale = ImageUtilities.idealCoveringScaleForImage(ICON_WIDTH, ICON_HEIGHT, icon.getWidth(), icon.getHeight());
            icon = ImageUtilities.resample(icon, scale);
            icon = ImageUtilities.center(icon, ICON_WIDTH, ICON_HEIGHT);
        }
        out[0] = icon;

        for (int i = 1; i < out.length; ++i) {
            BufferedImage bi = drops[i].drop.getImage();

            if (bi.getWidth() != bi.getHeight()) {
                BufferedImage trimmed = ImageUtilities.trim(bi);

                int s = Math.max(bi.getWidth(), bi.getHeight());
                BufferedImage aligned = new BufferedImage(s, s, BufferedImage.TYPE_INT_ARGB);

                Graphics2D g = aligned.createGraphics();
                try {
                    g.drawImage(trimmed, (s - trimmed.getWidth()) / 2, s - trimmed.getHeight(), null);
                } finally {
                    g.dispose();
                }
                bi = aligned;
            }
            out[i] = bi;
        }

        return out;
    }

    private static final int ICON_WIDTH = 24;
    private static final int ICON_HEIGHT = 18;
}
