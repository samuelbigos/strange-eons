package ca.cgjennings.apps.arkham.project;

import ca.cgjennings.ui.FilteredDocument;
import static resources.Language.string;
import resources.ResourceKit;

/**
 * Configures how the Open command handles various file types.
 *
 * @author Chris Jennings <https://cgjennings.ca/contact>
 */
@SuppressWarnings("serial")
public class FileHandlingConfigurationPanel extends javax.swing.JPanel {

    /**
     * Creates new form FileHandlingConfigurationPanel
     */
    public FileHandlingConfigurationPanel() {
//		// we need to catch exceptions here to allow this to be created in the GUI editor
//		try {
//			initComponents();
//			AbstractGameComponentEditor.localizeComboBoxLabels( actionBox, null );
//
//			DocumentEventAdapter updater = new DocumentEventAdapter() {
//				@Override
//				public void changedUpdate( DocumentEvent e ) {
//					updateRule();
//				}
//			};
//			extField.getDocument().addDocumentListener( updater );
//			cmdField.getDocument().addDocumentListener( updater );
//
//			loadRules();
//			ruleList.setModel( rules );
//		} catch( Exception e ) {
//			e.printStackTrace();
//		}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ruleList = new javax.swing.JList();
        addExtBtn = new javax.swing.JButton();
        remExtBtn = new javax.swing.JButton();
        cmdInfo = new javax.swing.JPanel();
        actionLabel = new javax.swing.JLabel();
        actionBox = new javax.swing.JComboBox();
        cmdLabel = new javax.swing.JLabel();
        cmdField = new javax.swing.JTextField();
        cmdNote = new javax.swing.JLabel();
        extField = new javax.swing.JTextField();

        ruleList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ruleListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(ruleList);

        addExtBtn.setIcon( ResourceKit.getIcon( "ui/button/plus.png" ) );

        remExtBtn.setIcon( ResourceKit.getIcon( "ui/button/minus.png" ) );
        remExtBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remExtBtnActionPerformed(evt);
            }
        });

        cmdInfo.setBackground(java.awt.Color.white);
        cmdInfo.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.gray));
        cmdInfo.setForeground(java.awt.Color.white);

        actionLabel.setText(string( "proj-l-fhc-action" )); // NOI18N

        actionBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "proj-cb-fhc-action-0", "proj-cb-fhc-action-1", "proj-cb-fhc-action-2", "proj-cb-fhc-action-3", "proj-cb-fhc-action-4", "proj-cb-fhc-action-5" }));
        actionBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionBoxActionPerformed(evt);
            }
        });

        cmdLabel.setText(string( "proj-l-fhc-cmd" )); // NOI18N

        cmdNote.setFont(cmdNote.getFont().deriveFont(cmdNote.getFont().getSize()-1f));
        cmdNote.setText(string( "proj-l-fhc-escape" )); // NOI18N

        extField.setBackground(java.awt.Color.gray);
        extField.setDocument(new FilteredDocument( ".?[]/\\=+<>:;\",*|^~" ) );
        extField.setFont(extField.getFont().deriveFont(extField.getFont().getStyle() | java.awt.Font.BOLD, extField.getFont().getSize()+4));
        extField.setForeground(java.awt.Color.white);
        extField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(2, 4, 2, 4)));
        extField.setCaretColor(new java.awt.Color(30, 30, 30));
        extField.setMargin(new java.awt.Insets(0, 0, 0, 0));
        extField.setOpaque( true );

        javax.swing.GroupLayout cmdInfoLayout = new javax.swing.GroupLayout(cmdInfo);
        cmdInfo.setLayout(cmdInfoLayout);
        cmdInfoLayout.setHorizontalGroup(
            cmdInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cmdInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cmdInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdLabel)
                    .addComponent(actionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cmdInfoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(cmdInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmdNote)
                            .addComponent(cmdField, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                            .addComponent(actionBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addComponent(extField, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
        );
        cmdInfoLayout.setVerticalGroup(
            cmdInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cmdInfoLayout.createSequentialGroup()
                .addComponent(extField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(actionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(actionBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(cmdNote)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addExtBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(remExtBtn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(cmdInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addExtBtn)
                    .addComponent(remExtBtn))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

	private void actionBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionBoxActionPerformed
//		boolean enable = actionBox.getSelectedIndex() == 5;
//		cmdLabel.setEnabled( enable );
//		cmdField.setEnabled( enable );
//		cmdNote.setEnabled( enable );
//		updateRule();
	}//GEN-LAST:event_actionBoxActionPerformed

	private void ruleListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ruleListValueChanged
//		updateRule();
//
//		Rule sel = (Rule) ruleList.getSelectedValue();
//		editing = sel;
//
//		if( sel == null ) {
//			actionBox.setSelectedIndex(0);
//			cmdField.setText( "" );
//
//			extField.setText( string("proj-l-fhc-ext") );
//			extField.selectAll();
//			extField.setEditable( true );
//			extField.requestFocusInWindow();
//		} else {
//			extField.setText( sel.ext );
//			extField.setEditable( false );
//			extField.select( 0, 0 );
//
//			actionBox.setSelectedIndex( ruleToIndex( sel.rule ) );
//			if( sel.rule == OpenRule.CUSTOM_COMMAND ) {
//				cmdField.setText( sel.command == null ? "" : sel.command );
//			} else {
//				cmdField.setText( "" );
//			}
//			actionBoxActionPerformed( null );
//		}
	}//GEN-LAST:event_ruleListValueChanged

	private void remExtBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remExtBtnActionPerformed
            // TODO add your handling code here:
	}//GEN-LAST:event_remExtBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox actionBox;
    private javax.swing.JLabel actionLabel;
    private javax.swing.JButton addExtBtn;
    private javax.swing.JTextField cmdField;
    private javax.swing.JPanel cmdInfo;
    private javax.swing.JLabel cmdLabel;
    private javax.swing.JLabel cmdNote;
    private javax.swing.JTextField extField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton remExtBtn;
    private javax.swing.JList ruleList;
    // End of variables declaration//GEN-END:variables

}
