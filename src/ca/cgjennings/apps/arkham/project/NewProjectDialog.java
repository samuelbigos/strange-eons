package ca.cgjennings.apps.arkham.project;

import ca.cgjennings.apps.arkham.AbstractGameComponentEditor;
import ca.cgjennings.apps.arkham.dialog.ErrorDialog;
import ca.cgjennings.platform.AgnosticDialog;
import ca.cgjennings.platform.PlatformSupport;
import ca.cgjennings.ui.DocumentEventAdapter;
import ca.cgjennings.ui.FilteredDocument;
import ca.cgjennings.ui.JFileField.FileType;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import javax.swing.event.DocumentEvent;
import javax.swing.filechooser.FileSystemView;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import static resources.Language.string;
import resources.RawSettings;
import resources.ResourceKit;

/**
 * Dialog that manages the creation of a new project folder.
 *
 * @author Chris Jennings <https://cgjennings.ca/contact>
 */
@SuppressWarnings("serial")
public class NewProjectDialog extends javax.swing.JDialog implements AgnosticDialog {

    private static final String PROJ_FOLDER_KEY = "default-project-folder";

    /**
     * Creates new form NewProjectDialog
     */
    public NewProjectDialog(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        AbstractGameComponentEditor.localizeComboBoxLabels(formatCombo, null);
        getRootPane().setDefaultButton(okBtn);
        PlatformSupport.makeAgnosticDialog(this, okBtn, cancelBtn);

        projLocationField.setOpaque(false);

        String folder = RawSettings.getUserSetting(PROJ_FOLDER_KEY);
        if (folder == null) {
            folder = FileSystemView.getFileSystemView().getDefaultDirectory().getAbsolutePath();
        }
        folderField.setText(folder);

        nameField.setText(string("prj-l-title"));
        nameField.selectAll();
        nameField.requestFocusInWindow();

        folderField.getDocument().addDocumentListener(new DocumentEventAdapter() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                fieldKeyReleased(null);
            }
        });
        updateProjectFolder();

        banner.setSize(banner.getWidth(), contentPanel.getPreferredSize().height);
        pack();

        Point loc = parent.getLocationOnScreen();
        loc.translate(64, 64);
        setLocation(loc);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        startLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        folderLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        errorLabel = new javax.swing.JLabel();
        cancelBtn = new javax.swing.JButton();
        okBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        startLabel1 = new javax.swing.JLabel();
        projLocationField = new javax.swing.JTextField();
        helpBtn = new ca.cgjennings.ui.JHelpButton();
        jLabel6 = new javax.swing.JLabel();
        formatCombo = new javax.swing.JComboBox<>();
        jTip2 = new ca.cgjennings.ui.JTip();
        folderField = new ca.cgjennings.ui.JFileField();
        folderField.setFileType( FileType.PROJECT_CONTAINER );
        jHeading1 = new ca.cgjennings.ui.JHeading();
        banner = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(string("prj-l-title")); // NOI18N

        startLabel.setFont(startLabel.getFont().deriveFont(startLabel.getFont().getSize()-1f));
        startLabel.setText(string("prj-l-intro2")); // NOI18N

        nameLabel.setText(string("prj-l-new-name")); // NOI18N

        folderLabel.setText(string("prj-l-new-folder")); // NOI18N

        nameField.setColumns(40);
        nameField.setDocument( FilteredDocument.createFileNameDocument() );
        nameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldKeyReleased(evt);
            }
        });

        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getSize()-1f));
        jLabel1.setText(string("prj-l-folder")); // NOI18N

        errorLabel.setForeground(java.awt.Color.red);
        errorLabel.setText(" ");

        cancelBtn.setText(string("cancel")); // NOI18N

        okBtn.setText(string("prj-b-make-new")); // NOI18N

        jLabel4.setFont(jLabel4.getFont().deriveFont(jLabel4.getFont().getSize()-1f));
        jLabel4.setText(string("prj-l-new-folder-desc")); // NOI18N

        startLabel1.setFont(startLabel1.getFont().deriveFont(startLabel1.getFont().getSize()-1f));
        startLabel1.setText(string("prj-l-intro")); // NOI18N

        projLocationField.setEditable(false);
        projLocationField.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
        projLocationField.setText("/example");
        projLocationField.setDisabledTextColor(java.awt.Color.black);
        projLocationField.setEnabled(false);
        projLocationField.setMargin(new java.awt.Insets(1, 1, 1, 1));

        helpBtn.setHelpPage("proj-intro");

        jLabel6.setText(string( "prj-l-new-proj-pkg" )); // NOI18N

        formatCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "prj-cb-new-pkg-0", "prj-cb-new-pkg-1" }));
        formatCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formatComboActionPerformed(evt);
            }
        });

        jTip2.setTipText(string( "prj-l-pkg-desc" )); // NOI18N

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("resources/text/interface/eons-text"); // NOI18N
        jHeading1.setText(bundle.getString("prj-l-title")); // NOI18N

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(nameLabel))
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(formatCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTip2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(folderLabel))
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(startLabel))
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(startLabel1))
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(nameField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(folderField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                .addComponent(helpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 353, Short.MAX_VALUE)
                                .addComponent(okBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelBtn))
                            .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(jHeading1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(projLocationField, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        contentPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelBtn, okBtn});

        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jHeading1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(startLabel1)
                .addGap(0, 0, 0)
                .addComponent(startLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(folderLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(folderField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(5, 5, 5)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTip2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formatCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(projLocationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(errorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cancelBtn)
                        .addComponent(okBtn))
                    .addComponent(helpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        contentPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {formatCombo, jTip2});

        getContentPane().add(contentPanel, java.awt.BorderLayout.CENTER);

        banner.setBackground(java.awt.Color.darkGray);
        banner.setIcon(resources.ResourceKit.createBleedBanner("new-proj.jpg")
        );
        banner.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        banner.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, java.awt.Color.gray));
        banner.setOpaque(true);
        getContentPane().add(banner, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

//	private static final int FORMAT_FOLDER = 0;
    private static final int FORMAT_PACKAGE = 1;

    private void updateProjectFolder() {
        File dir = new File(folderField.getText());
        String name = ResourceKit.makeStringFileSafe(nameField.getText());
        if (formatCombo.getSelectedIndex() == FORMAT_PACKAGE) {
            name += ".seproject";
        }
        File out = new File(dir, name);
        projLocationField.setText(out.getAbsolutePath());
        updateErrorMessage();
    }

	private void fieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldKeyReleased
            updateProjectFolder();
}//GEN-LAST:event_fieldKeyReleased

	private void formatComboActionPerformed( java.awt.event.ActionEvent evt ) {//GEN-FIRST:event_formatComboActionPerformed
            updateProjectFolder();
	}//GEN-LAST:event_formatComboActionPerformed

    public void updateErrorMessage() {
        String msg = " ";

        File dir = new File(folderField.getText());
        if (!dir.isDirectory()) {
            msg = string("prj-err-fnf");
        }

        // is this folder already part of a project?
        // check all the way up the tree since Tasks can contain plain folders
        File tree = dir;
        while (tree != null) {
            if (Task.isTaskFolder(dir)) {
                msg = string("prj-err-loc-is-proj");
                break;
            }
            tree = tree.getParentFile();
        }

        if (nameField.getText().length() == 0) {
            msg = string("prj-err-name");
        } else {
            // corollary to parent folder is project case:
            // folder + proj name already exists and is a project
            File projFile = new File(dir, nameField.getText());
            if (Task.isTaskFolder(projFile)) {
                msg = string("prj-err-exists");
            }
        }

        errorLabel.setText(msg);
        PlatformSupport.getAgnosticOK(true, okBtn, cancelBtn).setEnabled(" ".equals(msg));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel banner;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel errorLabel;
    private ca.cgjennings.ui.JFileField folderField;
    private javax.swing.JLabel folderLabel;
    private javax.swing.JComboBox<String> formatCombo;
    private ca.cgjennings.ui.JHelpButton helpBtn;
    private ca.cgjennings.ui.JHeading jHeading1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private ca.cgjennings.ui.JTip jTip2;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton okBtn;
    private javax.swing.JTextField projLocationField;
    private javax.swing.JLabel startLabel;
    private javax.swing.JLabel startLabel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void handleOKAction(ActionEvent evt) {
//		String resid = resIdField.getText();
        String folder = folderField.getText();
        String name = ResourceKit.makeStringFileSafe(nameField.getText());

        boolean pkg = formatCombo.getSelectedIndex() == FORMAT_PACKAGE;
        String projFolder = folder;
        if (pkg) {
            File temp = new File(System.getProperty("java.io.tmpdir"), "seprojpkg" + Integer.toHexString((int) System.currentTimeMillis()));
            temp = ProjectUtilities.getAvailableFile(temp);
            if (!temp.mkdirs()) {
                ErrorDialog.displayError(string("prj-err-create"), null);
                return;
            }
            projFolder = temp.getAbsolutePath();
        }

//		RawSettings.setUserSetting( RES_ID_KEY, resid );
        RawSettings.setUserSetting(PROJ_FOLDER_KEY, folder);

        try {
            File proj = Project.createProject(new File(projFolder), name);
            newProject = new Project(proj);
            newProject.getSettings().set(Project.KEY_RESOURCE_ID, getDefaultResourceID());
            newProject.writeTaskSettings();
            if (pkg) {
                File pkgFile = new File(new File(folder), name + ".seproject");
                newProject.toPackage(pkgFile);
                newProject.close();
                ProjectUtilities.deleteAll(proj);
                newProject = Project.fromPackage(pkgFile);
            }
            dispose();
        } catch (IOException e) {
            ErrorDialog.displayError(string("prj-err-create"), e);
        }
    }

    public Project showDialog() {
        newProject = null;
        setVisible(true);
        return newProject;
    }

    private Project newProject;

    @Override
    public void handleCancelAction(ActionEvent e) {
        dispose();
    }

    /**
     * Returns a default resource ID. The resource ID is a property of a project
     * (with key {@link Project#KEY_RESOURCE_ID}) that identifies the default
     * name for the subfolder within a plug-in task's resources folder that
     * should be used in order to avoid naming conflicts with other plug-ins.
     * The method returns a default resource ID to use when this value is not
     * available. The new project dialog will set a project's resource ID to
     * this value unless the project type sets its own value.
     *
     * @return a default resource ID
     */
    public static String getDefaultResourceID() {
        String resid = System.getProperty("user.name", "ext");
        resid = resid.replace(" ", "").toLowerCase(Locale.CANADA);
        Document fd = FilteredDocument.createFileNameDocument();
        try {
            fd.insertString(0, resid, null);
            return fd.getText(0, fd.getLength());
        } catch (BadLocationException ex) {
            throw new AssertionError();
        }
    }
}
